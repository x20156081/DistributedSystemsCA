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
		
		System.out.println("Starting gRPC Server");
		
		int port = 50051;
		server = ServerBuilder.forPort(port)
				.addService(new NewServerImpl())
				.build()
				.start();
		
		server.awaitTermination();
		
	}
	
	//Extend abstract base class for our implementation
	static class NewServerImpl extends newServiceImplBase {
		
		@Override
		public void getFirstString(containsString request, StreamObserver<containsString> responseObserver) {
			System.out.println("Inside NewService::containsString()");
			String firstString = request.getFirstString();

			containsString.Builder response = containsString.newBuilder();
			System.out.println("firstString = " + firstString);


			response.setFirstString("Our firsrt response");
			responseObserver.onNext(response.build());
			responseObserver.onCompleted();
		}
		
		@Override
		public StreamObserver<containsString> sendStringsClientStreaming(StreamObserver<containsString> responseObserver){
			return new StreamObserver<containsString>() {
				
				@Override
				public void onNext(containsString value) {
					System.out.println("Message received " + value.getFirstString());
				}
				
								
				@Override
				public void onCompleted() {
					containsString.Builder response = containsString.newBuilder();
					response.setFirstString("Streaming now completed");
					responseObserver.onNext(response.build());
					responseObserver.onCompleted();
				}

				@Override
				public void onError(Throwable t) {
					// TODO Auto-generated method stub
					
				}
			};	
		}

	}

}
