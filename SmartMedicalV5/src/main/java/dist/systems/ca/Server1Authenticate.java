package dist.systems.ca;

import java.io.IOException;
import java.util.logging.Logger;
import dist.systems.ca.AuthenticateGrpc.AuthenticateImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class Server1Authenticate extends AuthenticateImplBase{
	
	private static Logger logger = Logger.getLogger(Server1Authenticate.class.getName());

	public static void main(String[] args) {
		
		Server1Authenticate authServer = new Server1Authenticate();
		
		int port = 50061;
		String service_type = "_authenticate._tcp.local.";
		String service_name = "GrpcServer1";
		ServiceRegister ssr1 = new ServiceRegister();
		ssr1.run(port, service_type ,service_name);
		
		try {
			Server server = ServerBuilder.forPort(port)
			    .addService(authServer)
			    .build()
			    .start();
			System.out.println("\nAuthenticate server Started");
			
			 server.awaitTermination();

			 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    logger.info("Server started, listening on " + port);		
	    
		}
	
		@Override
		public void checkIn(CheckInRequest inReq, StreamObserver<CheckInReply> responseObserver) {
			String name = inReq.getName();
			int number = inReq.getHealthServiceNumber();
			String success = "Thank you " + name + ". You have checked in for your appointment. Proceed to waiting room.";
			String fail = "Please proceed to reception for help with Check In";
			CheckInReply.Builder reply = CheckInReply.newBuilder();
			
			//Name and health number could be checked against existing database here
			//if(name.equals("Joe Bloggs") && number == 999) {
				System.out.println("Patient " + number + " has just 'self'-checked in via MedClinic self-service");
				reply.setReplyMsg(success);
			//} else {
			//	System.out.println("A self-service check-in has been unsuccessful. Patient no. " + number);
			//	reply.setReplyMsg(fail);
			//}
			
			responseObserver.onNext(reply.build());
			responseObserver.onCompleted();
		}
	
		@Override
		public void checkOut(CheckOutRequest outReq, StreamObserver<CheckOutReply> responseObserver) {
			int number = outReq.getHealthServiceNumber();
			String checkOutOK = "You have successfully self checked out. Goodbye";
			String checkOutFail = "Please proceed to reception to complete Check Out";
			
			CheckOutReply.Builder reply = CheckOutReply.newBuilder();

//			Again, this could be live for multiple users, checked against database credentials
//			if(name.equals("Joe Bloggs") && number == 999) {
				System.out.println("Patient " + number + " has 'self' checked out.");
				reply.setReply(checkOutOK);
//			} else {
//				System.out.println("A self-service check-out has been unsuccessful. Patient no. " + number);
//				reply.setReply(checkOutFail);
//			}
			
			responseObserver.onNext(reply.build());
			responseObserver.onCompleted();
		}

}
