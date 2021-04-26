package dist.systems.ca.service3;

import java.io.IOException;
import java.util.logging.Logger;
import dist.systems.ca.JmDNS.ServiceRegister;
import dist.systems.ca.service3.ChatGrpc.ChatImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class Service3Chat extends ChatImplBase{
	
	private static Logger logger3 = Logger.getLogger(Service3Chat.class.getName());

	public static void main(String[] args) {
		
		//publish Chat service via JmDNS
		Service3Chat chatServer = new Service3Chat();		
		//declare name and type of service
		int port = 50081;
		String service_type = "_chat._tcp.local.";
		String service_name = "GrpcServer3";
		ServiceRegister ssr3 = new ServiceRegister();
		ssr3.run(port, service_type ,service_name);
		
		//server build and start
		try {
			Server server = ServerBuilder.forPort(port).addService(chatServer).build().start();
			
			System.out.println("\nChat Service server Started on " + server.getPort());
			
			 server.awaitTermination();

			 
		} catch (IOException e) {
			e.printStackTrace();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    
	    logger3.info("Server started, listening on " + port);		
	    
		}

	//method for bi-directional chat streaming
	@Override
	public StreamObserver<chatMsg> chatBiDi(StreamObserver<chatMsg> responseObserver) {
		
		return new StreamObserver<chatMsg>() {
			int chatCount = 0;
		    @Override
		    public void onNext(chatMsg chatMessage) {
		    	System.out.println("Message received from patient: " + chatMessage.getMessage());
		    	chatCount++;
		    	chatMsg serverMsg = chatMsg.newBuilder().setMessage("Clinic server response msg ").build();
		    	
		    	//sample chat messages/questions
		    	String msg1 = "Hi from Smart Med. How can we help you today?";
		    	String msg2 = "What are your symptoms?";
		    	String msg3 = "Do you wish to book an appointment?";
		    	String msg4 = "We will call you within 10 minutes and confirm an appointment. Thank you for using chat service";
		    	
		    	//demonstrate chat via samples above
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
		    	System.out.println();
		    	System.out.println("Patient has closed chat. Conversation logged.");
				
				//completed
				responseObserver.onCompleted();
		    }
		  };
	}
	
	

}
