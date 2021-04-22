package dist.systems.ca;

import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import dist.systems.ca.MedWaitRoomGrpc.MedWaitRoomBlockingStub;
import dist.systems.ca.MedWaitRoomGrpc.MedWaitRoomStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class medClient23 {
	
	private static MedWaitRoomStub asyncStub;  
	private static MedWaitRoomBlockingStub stub;
	
	public static void main(String[] args) throws InterruptedException {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50061).usePlaintext().build();
		
		asyncStub = MedWaitRoomGrpc.newStub(channel);
		stub = MedWaitRoomGrpc.newBlockingStub(channel);
		//MedWaitRoomStub asyncStub = MedWaitRoomGrpc.newStub(channel);
		
		System.out.println("Stream of questionnaire answers to MedClinic (Client streaming):");
		liability(channel);
		
		System.out.println();
		System.out.println("Stream of waiting times from MedClinic (Server streaming):");
		timer(channel);
		}
	
		private static void liability(ManagedChannel channel){
		try {
			StreamObserver<acceptance> responseObserver = new StreamObserver<acceptance>() {

				@Override
				public void onNext(acceptance value) {
					System.out.println();
					System.out.println("Response message from server: Liability responses received by clinic.");
					System.out.println(value.getServerReply());
					if(value.getAccepted()) {
						System.out.println("Thank you for your consent. Please continue waiting, you will be called shortly.");
					} else {
						System.out.println("Consent not received. Please contact reception to determine consent.");
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
			StreamObserver<answer> requestObserver = asyncStub.sendLiabilityClientStreaming(responseObserver);
			String ans1, ans2, ans3;
			Scanner sc = new Scanner(System.in);
			System.out.println("Q1. Are you over 18? (Y/N)");
			ans1 = sc.nextLine().toLowerCase();
			requestObserver.onNext(answer.newBuilder().setAnswerNo(1).setRetort(ans1).build());
			Thread.sleep(1000);
			
			System.out.println("Q2. Do you consent to Smart Med Clinic's official terms of service? (Y/N)");
			ans2 = sc.nextLine().toLowerCase();
			requestObserver.onNext(answer.newBuilder().setAnswerNo(2).setRetort(ans2).build());
			Thread.sleep(1000);
			
			System.out.println("Q3. Are you happy for us to contact you via telephone? (Y/N)");
			ans3 = sc.nextLine().toLowerCase();
			requestObserver.onNext(answer.newBuilder().setAnswerNo(3).setRetort(ans3).build());
			Thread.sleep(1000);
						
			System.out.println("Saving answers");
				
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
//					channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}	
	
		}
		
		private static void timer(ManagedChannel channel) {
			waitingRoomEntry entry = waitingRoomEntry.newBuilder().setHasEnteredWaitRoom(true).setPatientFirstName("Joe").build();
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
				Iterator<waitTimeReply> replies = stub.waitingTimerStream(entry);
				while(replies.hasNext()) {
					waitTimeReply temp = replies.next();
					responseObserver.onNext(temp);
				}
			} catch(StatusRuntimeException e){
				System.out.println(e.getMessage());
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
