package dist.systems.ca;

import java.io.IOException;

import dist.systems.ca.medServer2.MedWaitRoomImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class medChatServer {

	public static void main(String[] args) throws IOException, InterruptedException {
		Server server = ServerBuilder.forPort(50061).addService(new MedWaitRoomImpl()).build();
		
		server.start();
		
		System.out.println("Waiting Room Server is running on " + server.getPort());
		
		server.awaitTermination();


	}
	
	static class ChatImpl extends ChatGrpc.ChatImplBase{

		@Override
		public StreamObserver<chatMsg> chatBiDi(StreamObserver<chatMsg> responseObserver) {
			return new StreamObserver<chatMsg>() {
			    @Override
			    public void onNext(chatMsg chatMessage) {

			    }

			    @Override
			    public void onError(Throwable throwable) {

			    }

			    @Override
			    public void onCompleted() {

			    }
			  };
		}
				
	}

}
