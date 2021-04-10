package user;

import com.dermot.User.APIResponse;
import com.dermot.User.Empty;
import com.dermot.User.LoginRequest;
import com.dermot.userGrpc.userImplBase;

import io.grpc.stub.StreamObserver;

public class UserService extends userImplBase{

	@Override
	public void login(LoginRequest request, StreamObserver<APIResponse> responseObserver) {
		System.out.println("Welcome to Medical Clinic Login");
		String userName = request.getUserName();
		String password = request.getPassword();
		
		APIResponse.Builder response = APIResponse.newBuilder();
		
		if (userName.equals(password)) {
			
			//return success message
			response.setResponseCode(0).setResponseMessage("You have checked in for appointment");
		} else {
			
			//return failed login
			response.setResponseCode(100).setResponseMessage("Unable to check in - please go to reception");
		}
		
		responseObserver.onNext(response.build());
		responseObserver.onCompleted();
	}

	@Override
	public void logout(Empty request, StreamObserver<APIResponse> responseObserver) {
		
	}
	
}
