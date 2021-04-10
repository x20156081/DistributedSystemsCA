import com.dermot.User.APIResponse;
import com.dermot.User.LoginRequest;
import com.dermot.userGrpc;
import com.dermot.userGrpc.userBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ClinicClient {
	public static void main(String[] args) {
		
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();
		
		//stubs - generate from proto file
		userBlockingStub userStub = userGrpc.newBlockingStub(channel);
		
		LoginRequest loginRequest = LoginRequest.newBuilder().setUserName("PatientA").setPassword("PatientA").build();
		
		APIResponse response = userStub.login(loginRequest);
		
		System.out.println(response.getResponseMessage());
	}
}
