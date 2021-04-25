package dist.systems.ca;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jmdns.ServiceInfo;

import dist.systems.ca.AuthenticateGrpc.AuthenticateBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class Client1Authenticate {
	
	private static final Logger logger = Logger.getLogger(SmartMedClient.class.getName());
	private static AuthenticateBlockingStub stub;
	
	public static void main(String[] args) throws InterruptedException {
		ServiceInfo serviceInfo;
		String service_type = "_authenticate._tcp.local.";
		//Now retrieve the service info - all we are supplying is the service type
		serviceInfo = ServiceDiscover.run(service_type);
		//Use the serviceInfo to retrieve the port
		int port = serviceInfo.getPort();
		String host = "localhost";
		//int port = 50051;
		
		ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		
		stub = AuthenticateGrpc.newBlockingStub(channel);

	    
	    try {
	    	System.out.println("Please enter your first name");
	    	Scanner sc = new Scanner(System.in);
	    	String name = sc.nextLine();
	    	CheckInRequest request = CheckInRequest.newBuilder().setName(name).setHealthServiceNumber(999).build();
			CheckInReply reply = stub.checkIn(request);
			System.out.println(reply.getReplyMsg());
			sc.close();
			
			CheckOutRequest request2 = CheckOutRequest.newBuilder().setName(name).setHealthServiceNumber(999).build();
			CheckOutReply reply2 = stub.checkOut(request2);
			System.out.println(reply2.getReply());
	    	 
	    } catch (StatusRuntimeException e) {
		    logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
		    
		    return;		
		    
	    } finally {
	    	//shutdown channel
	    	channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	    }

	}

}
