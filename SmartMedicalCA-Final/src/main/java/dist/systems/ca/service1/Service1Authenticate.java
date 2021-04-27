//1st server - for 'smartMedAuthenticate' service
package dist.systems.ca.service1;

import java.io.IOException;
import java.util.logging.Logger;
import dist.systems.ca.JmDNS.ServiceRegister;
import dist.systems.ca.service1.AuthenticateGrpc.AuthenticateImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class Service1Authenticate extends AuthenticateImplBase{
	
	private static Logger logger = Logger.getLogger(Service1Authenticate.class.getName());

	public static void main(String[] args) {
		
		//publish service via JmDNS
		Service1Authenticate authServer = new Service1Authenticate();
		int port = 50061;
		//accredit name and type for this service
		String service_type = "_authenticate._tcp.local.";
		String service_name = "GrpcServer1";
		ServiceRegister ssr1 = new ServiceRegister();
		ssr1.run(port, service_type ,service_name);
		
		//server build and start
		try {
			Server server = ServerBuilder.forPort(port)
			    .addService(authServer)
			    .build()
			    .start();
			System.out.println("\nAuthenticate server Started");
			
			 server.awaitTermination();

			 
		} catch (IOException e) {			
			e.printStackTrace();
			
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
	    
	    logger.info("Server started, listening on " + port);		
	    
		}
	
		//self-service 'check-in' method
		@Override
		public void checkIn(CheckInRequest inReq, StreamObserver<CheckInReply> responseObserver) {
			//retrieve patient from client message
			String name = inReq.getName();
			//retrieve health service number of patient from client message
			int number = inReq.getHealthServiceNumber();
			
			//set appropriate message to send back to client, depending on credentials matching database
			String success = "Thank you " + name + ". You have checked in for your appointment. Proceed to waiting room.";
			String fail = "Please proceed to reception for help with Check In";
			CheckInReply.Builder reply = CheckInReply.newBuilder();
			
			//Name and health number could be checked against existing database here
			if(number == 999) {
				System.out.println("Patient " + number + " has just 'self'-checked in via MedClinic self-service");
				reply.setReplyMsg(success);
			} else {
				System.out.println("A self-service check-in has been unsuccessful. Patient no. " + number);
				reply.setReplyMsg(fail);
			}
			
			responseObserver.onNext(reply.build());
			responseObserver.onCompleted();
		}
	
		//self service 'check-out' method
		@Override
		public void checkOut(CheckOutRequest outReq, StreamObserver<CheckOutReply> responseObserver) {
			//retrieve health service number of patient
			int number = outReq.getHealthServiceNumber();
			
			//set appropriate message for client, according to details matching database or not
			String checkOutOK = "You have successfully self checked out. Goodbye";
			String checkOutFail = "Please proceed to reception to complete Check Out";
			
			CheckOutReply.Builder reply = CheckOutReply.newBuilder();

//			Again, this could be live for multiple users, checked against database credentials
//			if(name.equals("Joe Bloggs") && number == 999) etc. {
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
