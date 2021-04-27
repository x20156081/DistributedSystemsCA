//stand alone client for Waiting room Service - includes client streaming and server streaming rpc

package dist.systems.ca.client;

import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jmdns.ServiceInfo;
import dist.systems.ca.JmDNS.ServiceDiscover;
import dist.systems.ca.service2.MedWaitRoomGrpc;
import dist.systems.ca.service2.MedWaitRoomGrpc.MedWaitRoomBlockingStub;
import dist.systems.ca.service2.MedWaitRoomGrpc.MedWaitRoomStub;
import dist.systems.ca.service2.acceptance;
import dist.systems.ca.service2.answer;
import dist.systems.ca.service2.waitTimeReply;
import dist.systems.ca.service2.waitingRoomEntry;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class Client2WaitRoom {
	
	private static final Logger logger2 = Logger.getLogger(Client2WaitRoom.class.getName());
	private static MedWaitRoomStub asyncStub2;
	private static MedWaitRoomBlockingStub stub2;
	
	public static void main(String[] args) {
		//JmDNS discovery
		ServiceInfo serviceInfo2;
		String service_type2 = "_waitroom._tcp.local.";
		//Retrieve service info
		serviceInfo2 = ServiceDiscover.run(service_type2);
		//Retrieve the port
		int port = serviceInfo2.getPort();
		String host = "localhost";
		
		//set channel appropriate to port seen 'advertised' by JmDNS
		ManagedChannel channel2 = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();				
		
		//both blocking stub and generic async stubs needed for streaming services here
		asyncStub2 = MedWaitRoomGrpc.newStub(channel2);
		stub2 = MedWaitRoomGrpc.newBlockingStub(channel2);
		
		System.out.println("Stream of questionnaire answers to MedClinic (Client streaming):");
		liability(channel2);
		
		System.out.println();
		System.out.println("Stream of waiting times from MedClinic (Server streaming):");
		timer(channel2);
		
		}
	
	//method to demonstrate client side streaming
	private static void liability(ManagedChannel channel){
		try {
			StreamObserver<acceptance> responseObserver = new StreamObserver<acceptance>() {

			@Override
			public void onNext(acceptance value) {
				//Liability service - single response message after client stream received
				//set the exact response according to the answers received
				System.out.println();
				System.out.println("Response message from server: Liability responses received by clinic.");
				System.out.println("Response from server: " + value.getServerReply());
				if(value.getAccepted()) {
					System.out.println("Thank you for your consent. Please continue waiting, you will be called shortly.");
					System.out.println("Your BMI  is: " + value.getBmiRes());
				} else {
					System.out.println("Please contact reception to determine consent.");
				}
			}

			@Override
			public void onError(Throwable t) {
				logger2.log(Level.WARNING, "RPC failed: {0}", t.getCause());			    
			    return;					
			}

			@Override
			public void onCompleted() {
				System.out.println();
			}
			};
			
			//Take user input. Stream consecutive answers from the client to the server
			StreamObserver<answer> requestObserver = asyncStub2.streamClientDetails(responseObserver);
			String ans1;
			double ans2;
			double ans3;
			Scanner sc = new Scanner(System.in);
			System.out.println("Q1. Do you consent to Smart Med Clinic's official terms of service? (Y/N)");
			ans1 = sc.nextLine().toLowerCase();
			requestObserver.onNext(answer.newBuilder().setAnswerNo(1).setRetort(ans1).build());
			Thread.sleep(2000);
			
			System.out.println("Q2. What is you height in metres? e.g. 1.66");
			ans2 = sc.nextDouble();
			requestObserver.onNext(answer.newBuilder().setAnswerNo(2).setMetrics(ans2).build());
			Thread.sleep(2000);
			
			System.out.println("Q3. What is your weight in kgs? e.g. 70.5");
			ans3 = sc.nextDouble();
			requestObserver.onNext(answer.newBuilder().setAnswerNo(3).setMetrics(ans3).build());
			Thread.sleep(2000);
						
			System.out.println("Saving answers");
			sc.close();	
			requestObserver.onCompleted();
				
			Thread.sleep(3000);
				
			}
			catch (StatusRuntimeException e) {
				System.out.println(e.getMessage());
				return;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	
		}
	
	//method to demonstrate server side streaming
	private static void timer(ManagedChannel channel) {
		waitingRoomEntry entry = waitingRoomEntry.newBuilder().setHasEnteredWaitRoom(true).setPatientFirstName("Joe").setHasEnteredWaitRoom(true).build();
		StreamObserver<waitTimeReply> responseObserver = new StreamObserver<waitTimeReply>() {

			@Override
			public void onNext(waitTimeReply value) {
				//set the response message and minutes value from server, dependent on the time remaining
				//display stream of message updates to client
				if(value.getMinutes()==0) {
					System.out.println();
					System.out.println("Update! " + value.getTimeMsg());	
				} else {
					System.out.println("Update! " + value.getTimeMsg() + ". Waiting time approx.: " + value.getMinutes() + " minutes");
				}
			}

			@Override
			public void onError(Throwable t) {
				logger2.log(Level.WARNING, "RPC failed: {0}", t.getCause());			    
			    return;				
			}

			@Override
			public void onCompleted() {
				//server stream completed alert
				System.out.println("Waiting times stream completed. Shutting down Waiting Room Service.");
			}
			
		};		
		
		try {
			Iterator<waitTimeReply> replies = stub2.waitingTimerStream(entry);
			//monitor response observer and output server stream responses via onNext
			while(replies.hasNext()) {
				waitTimeReply temp = replies.next();
				responseObserver.onNext(temp);
			}
		} catch(StatusRuntimeException e){
			logger2.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
			return;
		}
		finally {
			responseObserver.onCompleted();
			try {
				channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
