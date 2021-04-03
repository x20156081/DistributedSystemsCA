package user;

import com.dermot.gRPC.test.*;
import com.dermot.gRPC.test.User.APIResponse;
import com.dermot.gRPC.test.User.Empty;
import com.dermot.gRPC.test.User.LoginRequest;
import com.dermot.gRPC.test.userGrpc.userImplBase;

import io.grpc.stub.StreamObserver;

public class UserService extends userImplBase{

	@Override
	public void login(LoginRequest request, StreamObserver<APIResponse> responseObserver) {
		System.out.println("Clinic Login");
		
		String username = request.getUsername();
		String password = request.getPassword();
		
		APIResponse.Builder response = APIResponse.newBuilder();
		if(username.equals(password)) {
			
			//return success message
			response.setResponseCode(0).setResponseMessage("Login Success");
		} else {
			
			//return fail message
			response.setResponseCode(100).setResponseMessage("Invalid credentials");
		}
		
		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}

	@Override
	public void logout(Empty request, StreamObserver<APIResponse> responseObserver) {
		
	}
	
}
