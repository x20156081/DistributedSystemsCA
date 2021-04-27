package dist.systems.ca.client;

import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jmdns.ServiceInfo;

import dist.systems.ca.JmDNS.ServiceDiscover;
import dist.systems.ca.service1.AuthenticateGrpc;
import dist.systems.ca.service1.AuthenticateGrpc.AuthenticateBlockingStub;
import dist.systems.ca.service1.CheckInReply;
import dist.systems.ca.service1.CheckInRequest;
import dist.systems.ca.service1.CheckOutReply;
import dist.systems.ca.service1.CheckOutRequest;
import dist.systems.ca.service2.MedWaitRoomGrpc;
import dist.systems.ca.service2.MedWaitRoomGrpc.MedWaitRoomBlockingStub;
import dist.systems.ca.service2.MedWaitRoomGrpc.MedWaitRoomStub;
import dist.systems.ca.service2.acceptance;
import dist.systems.ca.service2.answer;
import dist.systems.ca.service2.waitTimeReply;
import dist.systems.ca.service2.waitingRoomEntry;
import dist.systems.ca.service3.ChatGrpc;
import dist.systems.ca.service3.ChatGrpc.ChatStub;
import dist.systems.ca.service3.chatMsg;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class CombinedClient {
	
	//stubs/logs for Service No.1... Authenticate....Unary rpc
	private static final Logger logger = Logger.getLogger(CombinedClient.class.getName());
	private static AuthenticateBlockingStub stub;
	
	//stubs/logs for Service No. 2...WaitRoom.... Client Stream & Server Streaming rpc
	private static final Logger logger2 = Logger.getLogger(CombinedClient.class.getName());
	private static MedWaitRoomStub asyncStub2;
	private static MedWaitRoomBlockingStub stub2;
	
	//stubs/log for Service No. 3...Chat... Bi-Directional rpc
	private static final Logger logger3 = Logger.getLogger(CombinedClient.class.getName());	
	private static ChatStub asyncStub3;
	
	
	public static void main(String[] args) throws InterruptedException {
		//
		//Discover Service 1: Authenticate
		//
		ServiceInfo serviceInfo;
		String service_type = "_authenticate._tcp.local.";
		//Retrieve the service info
		serviceInfo = ServiceDiscover.run(service_type);
		//Use the serviceInfo to retrieve the port
		int port = serviceInfo.getPort();
		String host = "localhost";
		
		//
		//Discover Service 2: Waiting Room
		//
		ServiceInfo serviceInfo2;
		String service_type2 = "_waitroom._tcp.local.";
		//get service info 
		serviceInfo2 = ServiceDiscover.run(service_type2);
		//get the port
		int port2 = serviceInfo2.getPort();
		
		//
		//Discover Service 3: Chat Service
		//
		ServiceInfo serviceInfo3;
		String service_type3 = "_chat._tcp.local.";
		//Now retrieve the service info - all we are supplying is the service type
		serviceInfo3 = ServiceDiscover.run(service_type3);
		//Use the serviceInfo to retrieve the port
		int port3 = serviceInfo3.getPort();

		
		//Set channel and associated stub for Service 1: Authenticate - Unary Calls
		ManagedChannel channel1 = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		stub = AuthenticateGrpc.newBlockingStub(channel1);
		
		//Set channel and associated stubs for Service 2: Waiting Room - Server streaming and client streaming
		ManagedChannel channel2 = ManagedChannelBuilder.forAddress(host, port2).usePlaintext().build();				
		asyncStub2 = MedWaitRoomGrpc.newStub(channel2);
		stub2 = MedWaitRoomGrpc.newBlockingStub(channel2);
		
		//Set channel and associated stubs for Service 3: Chat Service - Bi-directional
		ManagedChannel channel3 = ManagedChannelBuilder.forAddress(host, port3).usePlaintext().build();				
		asyncStub3 = ChatGrpc.newStub(channel3);
		
		//Call Login method - anary rpc demo
		authUserLogin(channel1);
		Thread.sleep(4000);
		
		//liability questionnaire - demo of client side streaming rpc, server sends single receipt acknowledgment
		System.out.println("Stream of questionnaire answers to MedClinic (Client streaming):");
		liability(channel2);
		Thread.sleep(4000);
		
		//timer method - demo of server side streaming rpc, triggered by client's single message to server
		System.out.println();
		System.out.println("Stream of waiting times from MedClinic (Server streaming):");
		timer(channel2);
		
		//chat service - demo of bi-directional streaming, messages from client to server and vice versa
		chatDemo(channel3);
		
		//logout - additional unary rpc, close of service
		Thread.sleep(4000);
		authUserLogout(channel1);
		
	}
	
	
	private static void authUserLogin(ManagedChannel channel) {
		
		try {
			System.out.println();
	    	System.out.println("Please enter your first name");
	    	Scanner sc = new Scanner(System.in);
	    	String name = sc.nextLine();
	    	CheckInRequest request = CheckInRequest.newBuilder().setName(name).setHealthServiceNumber(999).build();
			CheckInReply reply = stub.checkIn(request);
			System.out.println(reply.getReplyMsg());
			    	 
	    } catch (StatusRuntimeException e) {
		    logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
		    
		    return;		
		    
	    } 
	}
	
	private static void authUserLogout(ManagedChannel channel) {
		
		try {			
			CheckOutRequest request2 = CheckOutRequest.newBuilder().setName("Joe Bloggs").setHealthServiceNumber(999).build();
			CheckOutReply reply2 = stub.checkOut(request2);
			System.out.println(reply2.getReply());
	    	 
	    } catch (StatusRuntimeException e) {
		    logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
		    
		    return;		
		    
	    } finally {
	    	//shutdown channel
	    	try {
				channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    }
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
				// TODO Auto-generated method stub
				
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
			Scanner sc2 = new Scanner(System.in);
			System.out.println("Q1. Do you consent to Smart Med Clinic's official terms of service? (Y/N)");
			ans1 = sc2.nextLine().toLowerCase();
			requestObserver.onNext(answer.newBuilder().setAnswerNo(1).setRetort(ans1).build());
			Thread.sleep(1000);
			
			System.out.println("Q2. What is you height in metres? e.g. 1.66");
			ans2 = sc2.nextDouble();
			requestObserver.onNext(answer.newBuilder().setAnswerNo(2).setMetrics(ans2).build());
			Thread.sleep(2000);
			
			System.out.println("Q3. What is your weight in kgs? e.g. 70.5");
			ans3 = sc2.nextDouble();
			requestObserver.onNext(answer.newBuilder().setAnswerNo(3).setMetrics(ans3).build());
			Thread.sleep(2000);
						
			System.out.println("Saving answers");
			//sc2.close();	
			requestObserver.onCompleted();
				
			Thread.sleep(5000);
				
			}
			catch (StatusRuntimeException e) {
				System.out.println(e.getMessage());
				return;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//			finally {
//				try {
//					channel2.shutdown().awaitTermination(5, TimeUnit.SECONDS);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
		
	
		}
	
	private static void timer(ManagedChannel channel) {
		waitingRoomEntry entry = waitingRoomEntry.newBuilder().setHasEnteredWaitRoom(true).setPatientFirstName("Joe").setHasEnteredWaitRoom(true).build();
		StreamObserver<waitTimeReply> responseObserver = new StreamObserver<waitTimeReply>() {

			@Override
			public void onNext(waitTimeReply value) {
				if(value.getMinutes()==0) {
					System.out.println();
					System.out.println("Update! " + value.getTimeMsg());	
				} else {
					System.out.println("Update! " + value.getTimeMsg() + ". Waiting time approx.: " + value.getMinutes() + " minutes");
				}
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onCompleted() {
				System.out.println("Waiting times stream completed. Shutting down Waiting Room Service.");
			}
			
		};		
		
		try {
			Iterator<waitTimeReply> replies = stub2.waitingTimerStream(entry);
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
	
	private static void chatDemo(ManagedChannel channel) throws InterruptedException{
		StreamObserver<chatMsg> responseObserver = new StreamObserver<chatMsg>() {

			@Override
			public void onNext(chatMsg value) {
				System.out.println(value.getMessage());
				
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
				
			}
		};
		StreamObserver<chatMsg> clientObserver = asyncStub3.chatBiDi(responseObserver);
		
		Scanner sc3 = new Scanner(System.in);
		
		clientObserver.onNext(chatMsg.newBuilder().setMessage("Open Chat Request").setMessageNo(1).build());
		String answer1 = sc3.nextLine();
		clientObserver.onNext(chatMsg.newBuilder().setMessage(answer1).setMessageNo(2).build());
		String answer2 = sc3.nextLine();
		clientObserver.onNext(chatMsg.newBuilder().setMessage(answer2).setMessageNo(3).build());
		String answer3 = sc3.nextLine();
		clientObserver.onNext(chatMsg.newBuilder().setMessage(answer3).setMessageNo(4).build());
		Thread.sleep(3000);
		sc3.close();
		
		System.out.println("Chat service closing");
		System.out.println();
		
		clientObserver.onCompleted();
		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}

}
