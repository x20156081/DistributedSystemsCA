package dist.systems.ca;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jmdns.ServiceInfo;

import dist.systems.ca.ChatGrpc.ChatStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class Client3Chat {
	
	private static final Logger logger3 = Logger.getLogger(SmartMedClient.class.getName());	
	private static ChatStub asyncStub3;
	
	public static void main(String[] args) {
		ServiceInfo serviceInfo3;
		String service_type3 = "_chat._tcp.local.";
		//Now retrieve the service info - all we are supplying is the service type
		serviceInfo3 = ServiceDiscover.run(service_type3);
		//Use the serviceInfo to retrieve the port
		int port = serviceInfo3.getPort();
		String host = "localhost";
		
		ManagedChannel channel3 = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();				
		
		asyncStub3 = ChatGrpc.newStub(channel3);
		
		try {
			chatDemo(channel3);
		} catch (InterruptedException e) {
			logger3.log(Level.WARNING, "RPC failed: {0}", e.getMessage());		    
		    return;	
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
		StreamObserver<chatMsg> clientObserver = asyncStub3.chatBiDi(responseObserver);
		
		Scanner sc = new Scanner(System.in);
		
		clientObserver.onNext(chatMsg.newBuilder().setMessage("Open Chat Request").setMessageNo(1).build());
		String answer1 = sc.nextLine();
		clientObserver.onNext(chatMsg.newBuilder().setMessage(answer1).setMessageNo(2).build());
		String answer2 = sc.nextLine();
		clientObserver.onNext(chatMsg.newBuilder().setMessage(answer2).setMessageNo(3).build());
		String answer3 = sc.nextLine();
		clientObserver.onNext(chatMsg.newBuilder().setMessage(answer3).setMessageNo(4).build());
		Thread.sleep(3000);
		sc.close();
		
		System.out.println("Chat service closing");
		clientObserver.onCompleted();
		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}

}
