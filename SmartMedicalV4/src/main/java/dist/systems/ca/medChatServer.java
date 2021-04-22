package dist.systems.ca;

import java.io.IOException;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class medChatServer {

	public static void main(String[] args) throws IOException, InterruptedException {
		Server server = ServerBuilder.forPort(50071).addService(new ChatImpl()).build();
		
		server.start();
		
		System.out.println("Chat Service Server is running on " + server.getPort());
		
		server.awaitTermination();
	}
	
	static class ChatImpl extends ChatGrpc.ChatImplBase{
		int chatCount = 0;
		@Override
		public StreamObserver<chatMsg> chatBiDi(StreamObserver<chatMsg> responseObserver) {
			
			return new StreamObserver<chatMsg>() {
			    @Override
			    public void onNext(chatMsg chatMessage) {
			    	System.out.println("Message received from patient: " + chatMessage.getMessage());
			    	chatCount++;
			    	chatMsg serverMsg = chatMsg.newBuilder().setMessage("Clinic server response msg ").build();
			    	
			    	String msg1 = "Hi from Smart Med. How can we help you today?";
			    	String msg2 = "What are your symptoms?";
			    	String msg3 = "Do you wish to book an appointment?";
			    	String msg4 = "We will call you within 10 minutes and confirm an appointment. Thank you for using chat service";
			    	
			    	if(chatMessage.getMessageNo() == 1) {
			    		serverMsg = chatMsg.newBuilder().setMessage(msg1).setMessageNo(chatCount).build();
			    	} else if (chatMessage.getMessageNo() == 2){
			    		serverMsg = chatMsg.newBuilder().setMessage(msg2).setMessageNo(chatCount).build();
			    	} else if (chatMessage.getMessageNo() == 3){
			    		serverMsg = chatMsg.newBuilder().setMessage(msg3).setMessageNo(chatCount).build();
			    	} else if (chatMessage.getMessageNo() == 4){
			    		serverMsg = chatMsg.newBuilder().setMessage(msg4).setMessageNo(chatCount).build();
			    	}
			    	responseObserver.onNext(serverMsg);
			    	
			    }

			    @Override
			    public void onError(Throwable t) {
			    	t.printStackTrace();
			    }

			    @Override
			    public void onCompleted() {
			    	System.out.println("Patient has closed chat");
					
					//completed too
					responseObserver.onCompleted();
			    }
			  };
		}
				
	}

}
