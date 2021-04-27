package dist.systems.ca.service2;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import dist.systems.ca.JmDNS.ServiceRegister;
import dist.systems.ca.service2.MedWaitRoomGrpc.MedWaitRoomImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class Service2WaitRoom extends MedWaitRoomImplBase{

	private static Logger logger2 = Logger.getLogger(Service2WaitRoom.class.getName());
	
	public static void main(String[] args) {
		
		//publish service via JmDNS
		Service2WaitRoom authServer = new Service2WaitRoom();		
		int port = 50071;
		//accredit name and type of service
		String service_type = "_waitroom._tcp.local.";
		String service_name = "GrpcServer2";
		ServiceRegister ssr2 = new ServiceRegister();
		ssr2.run(port, service_type ,service_name);
		
		//server build and start
		try {
			Server server = ServerBuilder.forPort(port)
			    .addService(authServer)
			    .build()
			    .start();
			System.out.println("\nWaiting Room server Started");
			
			 server.awaitTermination();
			 
		} catch (IOException e) {
			e.printStackTrace();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    
	    logger2.info("Server started, listening on " + port);		
	    
		}

		//method for server-side streaming
		@Override
		public void waitingTimerStream(waitingRoomEntry request, StreamObserver<waitTimeReply> responseObserver) {
			//obtain message from client - if boolean 'isWaiting' is true, trigger server stream of waiting times
			boolean isWaiting = request.getHasEnteredWaitRoom();
			
			//retrieve patient name
			String fname = request.getPatientFirstName();
			int totalTime = 12;
			System.out.println();
			
			//messages for server display
			if(isWaiting) {
			System.out.println("New patient is now in the waiting room");
			System.out.println("Beginning waiting times stream for client:");
			}
			
			//for demonstration, cycle through 5 waiting time messages
			for(int i=0; i<5; i++) {
				waitTimeReply reply = waitTimeReply.newBuilder().setTimeMsg("Please wait. ").setMinutes(totalTime).build();
				if(totalTime == 0) {
					reply = waitTimeReply.newBuilder().setTimeMsg("Proceed to Doctor's room now. ").setMinutes(totalTime).build();
				}
				responseObserver.onNext(reply);
				totalTime = totalTime -3;	
				try {
					Thread.sleep(5000);
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
	
		//method to demonstrate client side streaming
		//client requested to answer several questions regarding liability
		//stream each answer consecutively via client-side streaming
		@Override
		public StreamObserver<answer> sendLiabilityClientStreaming(StreamObserver<acceptance> responseObserver) {
			return new StreamObserver<answer>() {
				
				boolean consent = false;
				double height;
				double weight;
				double bmi;
				@Override
				public void onNext(answer value) {
					System.out.println("Answer no. " + value.getAnswerNo() + " received");
					if(value.getRetort().equals("y")) {
						consent = true;
					}
					if(value.getAnswerNo() == 2) {
						height = value.getMetrics();
					}
					if(value.getAnswerNo() == 3) {
						weight = value.getMetrics();
						bmi = Math.round(weight/(height*height));
					}
				}

				@Override
				public void onError(Throwable t) {
					logger2.log(Level.WARNING, "RPC failed: {0}", t.getCause());			    
				    return;
					
				}

				@Override
				public void onCompleted() {
					acceptance reply = acceptance.newBuilder().setServerReply("Thank you for liability answers. Your bmi is " + bmi).setAccepted(consent).setBmiRes(bmi).build();
					responseObserver.onNext(reply);
					System.out.println("Client answers stream receive completed. Now sending response to client.");
					responseObserver.onCompleted();

				}
				
			};
		}

		

}
