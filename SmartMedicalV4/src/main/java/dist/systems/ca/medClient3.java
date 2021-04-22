package dist.systems.ca;

import java.util.Iterator;
import dist.systems.ca.MedWaitRoomGrpc.MedWaitRoomBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class medClient3 {
	
		public static void main(String[] args) {
		String host = "localhost";
		int port = 50061;
		
		ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		MedWaitRoomBlockingStub stub = MedWaitRoomGrpc.newBlockingStub(channel);
		
		waitingRoomEntry entry = waitingRoomEntry.newBuilder().setHasEnteredWaitRoom(true).setPatientFirstName("Joe").build();
		StreamObserver<waitTimeReply> responseObserver = new StreamObserver<waitTimeReply>() {

			@Override
			public void onNext(waitTimeReply value) {
				System.out.println("Update! " + value.getTimeMsg() + ". Waiting time approx.: " + value.getMinutes() + " minutes");
				
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
		
		}
}
