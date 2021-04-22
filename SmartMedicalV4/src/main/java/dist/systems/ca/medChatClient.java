package dist.systems.ca;

import java.util.Scanner;

import dist.systems.ca.ChatGrpc.ChatStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class medChatClient {
	
	private static ChatStub asyncStub;
	
	public static void main(String[] args) {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50071).usePlaintext().build();
		asyncStub = ChatGrpc.newStub(channel);
		try {
			chatDemo(channel);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
		
	}
	
	private static void chatDemo(ManagedChannel channel) throws InterruptedException{
		StreamObserver<chatMsg> responseObserver = new StreamObserver<chatMsg>() {

			@Override
			public void onNext(chatMsg value) {
				System.out.println(value.getMessage());
				
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub
				
			}
		};
		StreamObserver<chatMsg> clientObserver = asyncStub.chatBiDi(responseObserver);
		
		Scanner sc = new Scanner(System.in);
		
		clientObserver.onNext(chatMsg.newBuilder().setMessage("Open Chat Request").setMessageNo(1).build());
		String answer1 = sc.nextLine();
		clientObserver.onNext(chatMsg.newBuilder().setMessage(answer1).setMessageNo(2).build());
		String answer2 = sc.nextLine();
		clientObserver.onNext(chatMsg.newBuilder().setMessage(answer2).setMessageNo(3).build());
		String answer3 = sc.nextLine();
		clientObserver.onNext(chatMsg.newBuilder().setMessage(answer3).setMessageNo(4).build());
		Thread.sleep(5000);
		sc.close();
//		clientObserver.onNext(chatMsg.newBuilder().setMessage("Hi").setMessageNo(1).build());
//		Thread.sleep(5000);
//		clientObserver.onNext(chatMsg.newBuilder().setMessage("Hi").setMessageNo(2).build());
//		Thread.sleep(5000);
//		clientObserver.onNext(chatMsg.newBuilder().setMessage("Hi").setMessageNo(3).build());
//		Thread.sleep(5000);
//		clientObserver.onNext(chatMsg.newBuilder().setMessage("Hi").setMessageNo(4).build());
//		Thread.sleep(5000);
		
		System.out.println("Chat service closing");
		clientObserver.onCompleted();
	}
}
