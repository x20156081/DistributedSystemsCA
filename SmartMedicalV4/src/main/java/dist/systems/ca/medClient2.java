package dist.systems.ca;

import java.util.concurrent.TimeUnit;

import dist.systems.ca.MedWaitRoomGrpc.MedWaitRoomStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class medClient2 {
	
	private static MedWaitRoomStub asyncStub;  
	
	public static void main(String[] args) throws InterruptedException {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50061).usePlaintext().build();
		
		asyncStub = MedWaitRoomGrpc.newStub(channel);
		liability(channel);
		}
	
		private static void liability(ManagedChannel channel){
		try {
			StreamObserver<acceptance> responseObserver = new StreamObserver<acceptance>() {

				@Override
				public void onNext(acceptance value) {
					System.out.println("Liability responses received by clinic.");
					System.out.println("Response from server: " + value.getServerReply());
					if(value.getAccepted()) {
						System.out.println("Thank you for your consent. Please continue waiting, you will be called shortly.");
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
			StreamObserver<answer> requestObserver = asyncStub.sendLiabilityClientStreaming(responseObserver);
			
			System.out.println("Q1. Are you over 18?");
			Thread.sleep(2000);
			System.out.println("Yes");
			Thread.sleep(2000);
			System.out.println("Q2. Do you consent to Smart Med Clinic's official terms of use?");
			Thread.sleep(2000);
			System.out.println("Yes");
			Thread.sleep(2000);
			System.out.println("Q3. Does Smart Med have your up to date contact details?");
			Thread.sleep(2000);
			System.out.println("Yes");
			Thread.sleep(2000);
			requestObserver.onNext(answer.newBuilder().setAnswerNo(1).setRetort("Yes").build());
			requestObserver.onNext(answer.newBuilder().setAnswerNo(2).setRetort("Yes").build());
			requestObserver.onNext(answer.newBuilder().setAnswerNo(3).setRetort("Yes").build());
			
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
			finally {
				try {
					channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		
	
		}
}
