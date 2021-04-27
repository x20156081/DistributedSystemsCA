//stand alone client for Chat Service - bi-directional rpc
package dist.systems.ca.client;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jmdns.ServiceInfo;

import dist.systems.ca.JmDNS.ServiceDiscover;
import dist.systems.ca.service3.ChatGrpc;
import dist.systems.ca.service3.ChatGrpc.ChatStub;
import dist.systems.ca.service3.chatMsg;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class Client3Chat {
	
	private static final Logger logger3 = Logger.getLogger(Client3Chat.class.getName());	
	private static ChatStub asyncStub3;
	
	public static void main(String[] args) {
		//chat service discovery via JmDNS
		ServiceInfo serviceInfo3;
		String service_type3 = "_chat._tcp.local.";
		//retrieve service info
		serviceInfo3 = ServiceDiscover.run(service_type3);
		//Use the serviceInfo to retrieve the port
		int port = serviceInfo3.getPort();
		String host = "localhost";
		
		//set channel appropriate to port seen 'advertised' by JmDNS
		ManagedChannel channel3 = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();				
		
		//bi-directional rpc - use async stub
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
				//bi-directional chat, for every message sent, display server response message
				System.out.println(value.getMessage());				
			}

			@Override
			public void onError(Throwable t) {
				logger3.log(Level.WARNING, "RPC failed: {0}", t.getCause());			    
			    return;					
			}

			@Override
			public void onCompleted() {
				System.out.println();
			}
		};
		StreamObserver<chatMsg> clientObserver = asyncStub3.chatBiDi(responseObserver);
		
		//user message input
		Scanner sc = new Scanner(System.in);
		
		//send clients message to server client observer
		clientObserver.onNext(chatMsg.newBuilder().setMessage("Open Chat Request").setMessageNo(1).build());
		String answer1 = sc.nextLine();
		clientObserver.onNext(chatMsg.newBuilder().setMessage(answer1).setMessageNo(2).build());
		String answer2 = sc.nextLine();
		clientObserver.onNext(chatMsg.newBuilder().setMessage(answer2).setMessageNo(3).build());
		String answer3 = sc.nextLine();
		clientObserver.onNext(chatMsg.newBuilder().setMessage(answer3).setMessageNo(4).build());
		Thread.sleep(3000);
		sc.close();
		
		//for demonstration - message to client interface
		System.out.println("Chat service closing");
		clientObserver.onCompleted();
		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}

}
