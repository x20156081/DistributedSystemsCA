package dist.systems.ca;
import java.io.IOException;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;


public class medServer2 {

	public static void main(String[] args) throws IOException, InterruptedException{
		Server server = ServerBuilder.forPort(50061).addService(new MedWaitRoomImpl()).build();
		
		server.start();
		
		System.out.println("2nd Server is running on " + server.getPort());
		
		server.awaitTermination();

	}
	
	static class MedWaitRoomImpl extends MedWaitRoomGrpc.MedWaitRoomImplBase{

		@Override
		public void waitingTimerStream(WaitingRoomEntry req, StreamObserver<WaitTimeReply> responseObserver) {
			Boolean active = req.getHasEnteredWaitRoom();
			String fName = req.getPatientFirstName();
			
			if(active == true) {
				System.out.println("A patient has joined the waiting room");
				WaitTimeReply reply = WaitTimeReply.newBuilder().setTime("You are number 2 in line " + fName + ". Your wait time is").setMinutes(10).build();
				responseObserver.onNext(reply);
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//simulate time passing
				WaitTimeReply reply2 = WaitTimeReply.newBuilder().setTime("You are number 1 in line " + fName + ". Your wait time is").setMinutes(5).build();
				responseObserver.onNext(reply2);
				
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				WaitTimeReply reply3 = WaitTimeReply.newBuilder().setTime("You are next " + fName + ". Proceed to the Doctor's room now").setMinutes(10).build();
				responseObserver.onNext(reply3);
				active = false;
				
				responseObserver.onCompleted();
			}
		}

		
		
	}
}
