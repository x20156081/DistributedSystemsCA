package dist.systems.ca;

import dist.systems.ca.AuthenticateGrpc.AuthenticateBlockingStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class medClient {

	public static void main(String[] args) throws InterruptedException {
		String host = "localhost";
		int port = 50051;
		
		ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();

		AuthenticateBlockingStub blockingStub = AuthenticateGrpc.newBlockingStub(channel);		

		CheckInRequest request = CheckInRequest.newBuilder().setName("Joe Bloggs").setHealthServiceNumber(999).build();
		CheckInReply reply = blockingStub.checkIn(request);
		System.out.println(reply.getReplyMsg());
		
		Thread.sleep(5000);
		CheckOutRequest request2 = CheckOutRequest.newBuilder().setName("Joe Bloggs").setHealthServiceNumber(999).build();
		CheckOutReply reply2 = blockingStub.checkOut(request2);
		System.out.println(reply2.getReply());
		
		Thread.sleep(5000);
	}

}
