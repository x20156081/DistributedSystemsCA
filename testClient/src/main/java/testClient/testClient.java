package testClient;

import com.dermot.gRPC.test.User.APIResponse;
import com.dermot.gRPC.test.User.LoginRequest;
import com.dermot.gRPC.test.userGrpc;
import com.dermot.gRPC.test.userGrpc.userBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class testClient {
	public static void main(String[] args) {
		
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();
		
		//generates stubs from proto
		userBlockingStub userStub = userGrpc.newBlockingStub(channel);
		
		LoginRequest loginRequest = LoginRequest.newBuilder().setUsername("Test").setPassword("Test").build();
		APIResponse response = userStub.login(loginRequest);
		
		System.out.println(response.getResponseMessage());
		System.out.println(response.getResponseCode());
	}
}
