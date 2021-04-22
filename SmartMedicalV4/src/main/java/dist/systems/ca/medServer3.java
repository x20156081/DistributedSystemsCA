package dist.systems.ca;

import java.io.IOException;

import dist.systems.ca.medServer2.MedWaitRoomImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class medServer3 {

	public static void main(String[] args) throws IOException, InterruptedException {
		Server server = ServerBuilder.forPort(50071).addService(new MedWaitRoomImpl()).build();
				
		server.start();
		
		System.out.println("3nd Server is running on " + server.getPort());
		
		server.awaitTermination();

	}
	
	static class MedWaitRoomImpl extends MedWaitRoomGrpc.MedWaitRoomImplBase{

		@Override
		public void waitingTimerStream(waitingRoomEntry request, StreamObserver<waitTimeReply> responseObserver) {
			boolean waiting = request.getHasEnteredWaitRoom();
			String fname = request.getPatientFirstName();
			int totalTime = 12;
			System.out.println(fname + " has entered waiting room");
			
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
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			responseObserver.onCompleted();
			
		}

		@Override
		public StreamObserver<answer> sendLiabilityClientStreaming(StreamObserver<acceptance> responseObserver) {
			// TODO Auto-generated method stub
			return super.sendLiabilityClientStreaming(responseObserver);
		}
		
	}

}
