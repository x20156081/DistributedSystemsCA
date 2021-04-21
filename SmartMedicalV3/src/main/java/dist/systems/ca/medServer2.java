package dist.systems.ca;
import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;


public class medServer2 {

	public static void main(String[] args) throws IOException, InterruptedException{
		Server server = ServerBuilder.forPort(50061).addService(new MedWaitRoomImpl()).build();
		
		server.start();
		
		System.out.println("Waiting Room Server is running on " + server.getPort());
		
		server.awaitTermination();

	}
	
	static class MedWaitRoomImpl extends MedWaitRoomGrpc.MedWaitRoomImplBase{

		@Override
		public void waitingTimerStream(waitingRoomEntry request, StreamObserver<waitTimeReply> responseObserver) {
			boolean waiting = request.getHasEnteredWaitRoom();
			String fname = request.getPatientFirstName();
			int totalTime = 12;
			System.out.println();
			System.out.println("Patient '" + fname + "' is now in the waiting room");
			System.out.println("Beginning waiting times stream:");
			
			for(int i=0; i<5; i++) {
				waitTimeReply reply = waitTimeReply.newBuilder().setTimeMsg("Please wait").setMinutes(totalTime).build();
				if(totalTime == 0) {
					reply = waitTimeReply.newBuilder().setTimeMsg("Proceed to Doctor's room now").setMinutes(totalTime).build();
				}
				responseObserver.onNext(reply);
				totalTime = totalTime -3;
				try {					
					Thread.sleep(7000);					
				} catch (InterruptedException e) {					
					e.printStackTrace();
				}
				
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			responseObserver.onCompleted();
			
		}

		@Override
		public StreamObserver<answer> sendLiabilityClientStreaming(StreamObserver<acceptance> responseObserver) {
			return new StreamObserver<answer>() {
				
				boolean consent = true;
				@Override
				public void onNext(answer value) {
					System.out.println("Answer no. " + value.getAnswerNo() + " received");
					if(value.getRetort().equals("n")) {
						consent = false;
					}
				}

				@Override
				public void onError(Throwable t) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onCompleted() {
					acceptance reply = acceptance.newBuilder().setServerReply("Thank you for liability answers").setAccepted(consent).build();
					responseObserver.onNext(reply);
					System.out.println("Client answers stream receive completed");
					responseObserver.onCompleted();

				}
				
			};
		}
			
		
	}
}
