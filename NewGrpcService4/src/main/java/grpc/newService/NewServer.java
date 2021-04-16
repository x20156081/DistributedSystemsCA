package grpc.newService;

import java.io.IOException;

import grpc.newService.newServiceGrpc.newServiceImplBase;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class NewServer {
	private Server server;
	
	public static void main(String[] args) throws IOException, InterruptedException {

		final NewServer ourServer = new NewServer();
		
		ourServer.start();
		
	}
	
	private void start() throws IOException, InterruptedException {
		int port = 50051;
		server = ServerBuilder.forPort(port).addService(new NewServerImpl()).build().start();
		System.out.println("Server started; listening on port " + server.getPort());
		server.awaitTermination();
	}
	
	//Extend abstract base class
	static class NewServerImpl extends newServiceImplBase{

		@Override
		public void getFirstString(containsString request, StreamObserver<containsString> responseObserver) {
			String firstString = request.getFirstString();
			
			System.out.println("First string is " + firstString);
			
			containsString.Builder response = containsString.newBuilder();
			
			response.setFirstString(firstString + " from server");
			
			responseObserver.onNext(response.build());
			
			responseObserver.onCompleted();
		}
		
	}

}
