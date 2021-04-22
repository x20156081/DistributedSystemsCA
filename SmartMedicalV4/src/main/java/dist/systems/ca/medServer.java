package dist.systems.ca;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;


public class medServer {

	public static void main(String[] args) throws IOException, InterruptedException{
		Server server = ServerBuilder.forPort(50051).addService(new AuthenticateImpl()).build();
		
		server.start();
		
		System.out.println("Server is running on " + server.getPort());
		
		server.awaitTermination();

	}
	
	static class AuthenticateImpl extends AuthenticateGrpc.AuthenticateImplBase{

		@Override
		public void checkIn(CheckInRequest inReq, StreamObserver<CheckInReply> responseObserver) {
			String name = inReq.getName();
			int number = inReq.getHealthServiceNumber();
			String success = "You have checked in for your appointment. Proceed to waiting room.";
			String fail = "Please proceed to reception for help with Check In";
			CheckInReply.Builder reply = CheckInReply.newBuilder();
			
			if(name.equals("Joe Bloggs") && number == 999) {
				System.out.println("Patient " + number + " has just 'self'-checked in via MedClinic self-service");
				reply.setReplyMsg(success);
			} else {
				System.out.println("A self-service check-in has been unsuccessful. Patient no. " + number);
				reply.setReplyMsg(fail);
			}
			
			responseObserver.onNext(reply.build());
			responseObserver.onCompleted();
		}

		@Override
		public void checkOut(CheckOutRequest outReq, StreamObserver<CheckOutReply> responseObserver) {
			String name = outReq.getName();
			int number = outReq.getHealthServiceNumber();
			String checkOutOK = "You have successfully checked out. Goodbye";
			String checkOutFail = "Please proceed to rescption to complete Check Out";
			
			CheckOutReply.Builder reply = CheckOutReply.newBuilder();
			
			if(name.equals("Joe Bloggs") && number == 999) {
				System.out.println("Patient " + number + " has 'self' checked out.");
				reply.setReply(checkOutOK);
			} else {
				System.out.println("A self-service check-out has been unsuccessful. Patient no. " + number);
				reply.setReply(checkOutFail);
			}
			
			responseObserver.onNext(reply.build());
			responseObserver.onCompleted();
		}
		
		
	}
}
