package grpc.newService;
import java.util.concurrent.TimeUnit;

import grpc.newService.newServiceGrpc.newServiceBlockingStub;
import grpc.newService.newServiceGrpc.newServiceStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class NewClient {

	public static void main(String[] args) throws Exception {
		String host = "localhost";
		int port = 50051;

		ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();

		newServiceBlockingStub blockingStub = newServiceGrpc.newBlockingStub(channel);
		newServiceStub asyncStub = newServiceGrpc.newStub(channel);

		try {
			//Following 4 lines for unary
			//String name = "Joe and Ann";

			//containsString request = containsString.newBuilder().setFirstString(name).build();

			//containsString response = blockingStub.getFirstString(request);

			//System.out.println("Response: " + response.getFirstString());
			
			//Following for client side streaming
			
			StreamObserver<containsString> responseObserver = new StreamObserver<containsString>(){

				@Override
				public void onNext(containsString value) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onError(Throwable t) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onCompleted() {
					// TODO Auto-generated method stub
					System.out.println("Completed stream");
				}
				
				
			};
			
			StreamObserver<containsString> requestObserver = asyncStub.sendStringsClientStreaming(responseObserver);
			
			requestObserver.onNext(containsString.newBuilder().setFirstString("First Message").build());
			requestObserver.onNext(containsString.newBuilder().setFirstString("Second Message").build());
			
			System.out.println("Sending Messages");
			
			requestObserver.onCompleted();
			Thread.sleep(5000);

		} catch (StatusRuntimeException e) {
			System.out.print(e.getMessage());

			return;

		} finally {
			// shutdown channel
			channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
		}
	}

}
