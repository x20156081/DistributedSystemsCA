package dist.systems.ca;

import java.io.IOException;
import java.util.logging.Logger;

import dist.systems.ca.MedWaitRoomGrpc.MedWaitRoomImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class Server2WaitRoom extends MedWaitRoomImplBase{

	private static Logger logger2 = Logger.getLogger(Server1Authenticate.class.getName());
	
	public static void main(String[] args) {
		
		Server2WaitRoom authServer = new Server2WaitRoom();
		
		int port = 50071;
		String service_type = "_waitroom._tcp.local.";
		String service_name = "GrpcServer2";
		ServiceRegister ssr2 = new ServiceRegister();
		ssr2.run(port, service_type ,service_name);
		
		try {
			Server server = ServerBuilder.forPort(port)
			    .addService(authServer)
			    .build()
			    .start();
			System.out.println("\nWaiting Room server Started");
			
			 server.awaitTermination();

			 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    logger2.info("Server started, listening on " + port);		
	    
		}

		@Override
		public void waitingTimerStream(waitingRoomEntry request, StreamObserver<waitTimeReply> responseObserver) {
			boolean isWaiting = request.getHasEnteredWaitRoom();
			String fname = request.getPatientFirstName();
			int totalTime = 12;
			System.out.println();
			if(isWaiting) {
			System.out.println("Patient '" + fname + "' is now in the waiting room");
			System.out.println("Beginning waiting times stream for client:");
			}
			
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
