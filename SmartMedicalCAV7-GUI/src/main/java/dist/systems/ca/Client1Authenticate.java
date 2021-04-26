//Stand alone client for Unary Grpc service - Authentication at Login & Logout

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
		//JmDNS Discovery
		ServiceInfo serviceInfo;
		String service_type = "_authenticate._tcp.local.";
		serviceInfo = ServiceDiscover.run(service_type);
		//Use the serviceInfo to retrieve the port
		int port = serviceInfo.getPort();
		String host = "localhost";
		
		//set channel appropriate to port seen 'advertised' by JmDNS
		ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		
		//Unary rpc - use blocking stub type
		stub = AuthenticateGrpc.newBlockingStub(channel);
	    
	    try {
	    	//User Input via interface
	    	System.out.println("Please enter your first name");
	    	Scanner sc = new Scanner(System.in);
	    	String name = sc.nextLine();
	    	
	    	//send login request to server
	    	CheckInRequest request = CheckInRequest.newBuilder().setName(name).setHealthServiceNumber(999).build();
			
	    	//response received from server named 'reply', contained string type 'replyMsg'
	    	CheckInReply reply = stub.checkIn(request);
			System.out.println(reply.getReplyMsg());
			sc.close();
			
			Thread.sleep(5000);
			System.out.println("On leaving the clinic, self-check out msg will read:");
			//send logout unary request to server
			CheckOutRequest request2 = CheckOutRequest.newBuilder().setName(name).setHealthServiceNumber(999).build();
			
			Thread.sleep(2000);
			//server replies with 'self-service' logout success/fail
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
