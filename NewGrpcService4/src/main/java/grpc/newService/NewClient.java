package grpc.newService;

import java.util.concurrent.TimeUnit;

import grpc.newService.newServiceGrpc.newServiceBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class NewClient {

	public static void main(String[] args) throws InterruptedException{
		//Create a channel
		int port = 50051;
		String host = "localhost";
		
		ManagedChannel newChannel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		
		//code previous to this is generic for all clients
		
		//next, build our message
		containsString cString = containsString.newBuilder().setFirstString("Test").build();
		
		//now create the stub (local representation of the remote method on the server
		newServiceBlockingStub bStub = newServiceGrpc.newBlockingStub(newChannel);
		
		containsString response = bStub.getFirstString(cString);
		
		System.out.println(response.getFirstString());
		
		
		newChannel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
		
		
	}

}
