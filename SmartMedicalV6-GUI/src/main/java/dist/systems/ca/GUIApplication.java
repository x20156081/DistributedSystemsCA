package dist.systems.ca;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import dist.systems.ca.AuthenticateGrpc.AuthenticateBlockingStub;
import dist.systems.ca.ChatGrpc.ChatStub;
import dist.systems.ca.MedWaitRoomGrpc.MedWaitRoomBlockingStub;
import dist.systems.ca.MedWaitRoomGrpc.MedWaitRoomStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

public class GUIApplication {
	
	//stubs/logs for Service No.1... Authenticate....Unary rpc
	private static final Logger logger = Logger.getLogger(SmartMedClient.class.getName());
	private static AuthenticateBlockingStub stub;
	
	//stubs/logs for Service No. 2...WaitRoom.... Client Stream & Server Streaming rpc
	private static final Logger logger2 = Logger.getLogger(SmartMedClient.class.getName());
	private static MedWaitRoomStub asyncStub2;
	private static MedWaitRoomBlockingStub stub2;
	
	//stubs/log for Service No. 3...Chat... Bi-Directional rpc
	private static final Logger logger3 = Logger.getLogger(SmartMedClient.class.getName());	
	private static ChatStub asyncStub3;
	
	private JFrame frame;
	private JTextField userName;
	private JTextField userNo;
	private JTextField ans1;
	private JTextField ans2;
	private JTextField ans3;
	private JTextArea textResponse;
	private JTextArea textResponse2;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIApplication window = new GUIApplication();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public GUIApplication() {
		
		//
		//Discover Service 1: Authenticate
		//
		ServiceInfo serviceInfo;
		String service_type = "_authenticate._tcp.local.";
		//Retrieve the service info
		serviceInfo = ServiceDiscover.run(service_type);
		//Use the serviceInfo to retrieve the port
		int port = serviceInfo.getPort();
		String host = "localhost";
		
		//
		//Discover Service 2: Waiting Room
		//
		ServiceInfo serviceInfo2;
		String service_type2 = "_waitroom._tcp.local.";
		//get service info 
		serviceInfo2 = ServiceDiscover.run(service_type2);
		//get the port
		int port2 = serviceInfo2.getPort();
		
		//
		//Discover Service 3: Chat Service
		//
		ServiceInfo serviceInfo3;
		String service_type3 = "_chat._tcp.local.";
		//Now retrieve the service info - all we are supplying is the service type
		serviceInfo3 = ServiceDiscover.run(service_type3);
		//Use the serviceInfo to retrieve the port
		int port3 = serviceInfo3.getPort();

		
		//Set channel and associated stub for Service 1: Authenticate - Unary Calls
		ManagedChannel channel1 = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
		stub = AuthenticateGrpc.newBlockingStub(channel1);
		
		//Set channel and associated stubs for Service 2: Waiting Room - Server streaming and client streaming
		ManagedChannel channel2 = ManagedChannelBuilder.forAddress(host, port2).usePlaintext().build();				
		asyncStub2 = MedWaitRoomGrpc.newStub(channel2);
		stub2 = MedWaitRoomGrpc.newBlockingStub(channel2);
		
		//Set channel and associated stubs for Service 3: Chat Service - Bi-directional
		ManagedChannel channel3 = ManagedChannelBuilder.forAddress(host, port3).usePlaintext().build();				
		asyncStub3 = ChatGrpc.newStub(channel3);
		
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Client - Med Auth Controller");
		frame.setBounds(100, 100, 1000, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BoxLayout bl = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
		
		frame.getContentPane().setLayout(bl);
		
		//Login unary service panel
		JPanel loginPanel = new JPanel();
		frame.getContentPane().add(loginPanel);
		loginPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_1 = new JLabel("Enter patient name:");
		loginPanel.add(lblNewLabel_1);
		
		userName = new JTextField();
		loginPanel.add(userName);
		userName.setColumns(12);
		
		JLabel lblNewLabel_2 = new JLabel("Enter patient number:");
		loginPanel.add(lblNewLabel_2);				
		
		userNo = new JTextField();
		loginPanel.add(userNo);
		userNo.setColumns(4);
		
		JButton btnLogin = new JButton("Click to Check-In");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = userName.getText();
								
				CheckInRequest request = CheckInRequest.newBuilder().setName(name).setHealthServiceNumber(999).build();

				CheckInReply reply = stub.checkIn(request);

				textResponse.append("Reply:"+ reply.getReplyMsg());
				
				System.out.println(reply.getReplyMsg());

			}
		});
		loginPanel.add(btnLogin);
		
		textResponse = new JTextArea(3, 30);
		textResponse .setLineWrap(true);
		textResponse.setWrapStyleWord(true);
		
		JScrollPane scrollPane = new JScrollPane(textResponse);
		
		//textResponse.setSize(new Dimension(15, 30));
		loginPanel.add(scrollPane);
		
		
		//Panel 2 - Liabiltiy Q1
		
		JPanel liabilityPanel1 = new JPanel();
		frame.getContentPane().add(liabilityPanel1);
		liabilityPanel1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_3 = new JLabel("Q1. Are you over 18? (Y/N)");
		liabilityPanel1.add(lblNewLabel_3);
		
		ans1 = new JTextField();
		liabilityPanel1.add(ans1);
		ans1.setColumns(4);		
		
		//
		//Liability Panel 2 - Q2
		JPanel liabilityPanel2 = new JPanel();
		frame.getContentPane().add(liabilityPanel2);
		liabilityPanel2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_4 = new JLabel("Q2. Do you consent to Smart Med Clinic's official terms of service? (Y/N)");
		liabilityPanel2.add(lblNewLabel_4);
		
		ans2 = new JTextField();
		liabilityPanel2.add(ans2);
		ans2.setColumns(4);		
		
		
		//Liability Panel 3 - Q3
		
		JPanel liabilityPanel3 = new JPanel();
		frame.getContentPane().add(liabilityPanel3);
		liabilityPanel3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_5 = new JLabel("Q2. Do we have permission to contact you by telephone? (Y/N)");
		liabilityPanel3.add(lblNewLabel_5);
		
		ans3 = new JTextField();
		liabilityPanel3.add(ans3);
		ans3.setColumns(4);
		
		JButton btnAnswers = new JButton("Stream answers");
		liabilityPanel3.add(btnAnswers);
		btnAnswers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					StreamObserver<acceptance> responseObserver = new StreamObserver<acceptance>() {

					@Override
					public void onNext(acceptance value) {
						System.out.println();
						System.out.println("Response message from server: Liability responses received by clinic.");
						System.out.println("Response from server: " + value.getServerReply());
						if(value.getAccepted()) {
							System.out.println("Thank you for your consent. Please continue waiting, you will be called shortly.");
							textResponse2.append("Thank you for your consent. Please continue waiting, you will be called shortly.");
						} else {
							System.out.println("Please contact reception to determine consent.");
						}
					}

					@Override
					public void onError(Throwable t) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onCompleted() {
						System.out.println();
					}
					};
					
					StreamObserver<answer> requestObserver = asyncStub2.sendLiabilityClientStreaming(responseObserver);
					requestObserver.onNext(answer.newBuilder().setAnswerNo(1).setRetort(ans1.getText().toLowerCase()).build());
					Thread.sleep(1000);					
					
					requestObserver.onNext(answer.newBuilder().setAnswerNo(2).setRetort(ans2.getText().toLowerCase()).build());
					Thread.sleep(1000);
					
					requestObserver.onNext(answer.newBuilder().setAnswerNo(3).setRetort(ans3.getText().toLowerCase()).build());
					Thread.sleep(1000);
					
					requestObserver.onCompleted();		
					}
					catch (StatusRuntimeException e1) {
						System.out.println(e1.getMessage());
						return;
					} catch (InterruptedException e2) {
						e2.printStackTrace();
					}
//					finally {
//						try {
//							channel2.shutdown().awaitTermination(5, TimeUnit.SECONDS);
//						} catch (InterruptedException e) {
//							e.printStackTrace();
//						}
//					}
				
			
				}
			
		});
		
		//Liability response Panel
		
		JPanel liabilityResponsePanel = new JPanel();
		frame.getContentPane().add(liabilityResponsePanel);
		liabilityResponsePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_6 = new JLabel("Liability stream response");
		liabilityResponsePanel.add(lblNewLabel_6);
		
		textResponse2 = new JTextArea(3, 30);
		textResponse2 .setLineWrap(true);
		textResponse2.setWrapStyleWord(true);
		
		JScrollPane scrollPane2 = new JScrollPane(textResponse2);
		
		//textResponse2.setSize(new Dimension(15, 30));
		liabilityResponsePanel.add(scrollPane2);
}
	
	private static void liability(ManagedChannel channel){
		try {
			StreamObserver<acceptance> responseObserver = new StreamObserver<acceptance>() {

			@Override
			public void onNext(acceptance value) {
				System.out.println();
				System.out.println("Response message from server: Liability responses received by clinic.");
				System.out.println("Response from server: " + value.getServerReply());
				if(value.getAccepted()) {
					System.out.println("Thank you for your consent. Please continue waiting, you will be called shortly.");
				} else {
					System.out.println("Please contact reception to determine consent.");
				}
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onCompleted() {
				System.out.println();
			}
			};
			
			StreamObserver<answer> requestObserver = asyncStub2.sendLiabilityClientStreaming(responseObserver);
			String ans1, ans2, ans3;
			Scanner sc = new Scanner(System.in);
			System.out.println("Q1. Are you over 18? (Y/N)");
			ans1 = sc.nextLine().toLowerCase();
			requestObserver.onNext(answer.newBuilder().setAnswerNo(1).setRetort(ans1).build());
			Thread.sleep(1000);
			
			System.out.println("Q2. Do you consent to Smart Med Clinic's official terms of service? (Y/N)");
			ans2 = sc.nextLine().toLowerCase();
			requestObserver.onNext(answer.newBuilder().setAnswerNo(2).setRetort(ans2).build());
			Thread.sleep(1000);
			
			System.out.println("Q3. Are you happy for us to contact you via telephone? (Y/N)");
			ans3 = sc.nextLine().toLowerCase();
			requestObserver.onNext(answer.newBuilder().setAnswerNo(3).setRetort(ans3).build());
			Thread.sleep(1000);
						
			System.out.println("Saving answers");
			sc.close();	
			requestObserver.onCompleted();
				
			Thread.sleep(5000);
				
			}
			catch (StatusRuntimeException e) {
				System.out.println(e.getMessage());
				return;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//			finally {
//				try {
//					channel2.shutdown().awaitTermination(5, TimeUnit.SECONDS);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
		
	
		}
	
	private static void timer(ManagedChannel channel) {
		waitingRoomEntry entry = waitingRoomEntry.newBuilder().setHasEnteredWaitRoom(true).setPatientFirstName("Joe").setHasEnteredWaitRoom(true).build();
		StreamObserver<waitTimeReply> responseObserver = new StreamObserver<waitTimeReply>() {

			@Override
			public void onNext(waitTimeReply value) {
				if(value.getMinutes()==0) {
					System.out.println();
					System.out.println("Update! " + value.getTimeMsg());	
				} else {
					System.out.println("Update! " + value.getTimeMsg() + ". Waiting time approx.: " + value.getMinutes() + " minutes");
				}
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onCompleted() {
				System.out.println("Waiting times stream completed. Shutting down Waiting Room Service.");
			}
			
		};		
		
		try {
			Iterator<waitTimeReply> replies = stub2.waitingTimerStream(entry);
			while(replies.hasNext()) {
				waitTimeReply temp = replies.next();
				responseObserver.onNext(temp);
			}
		} catch(StatusRuntimeException e){
			logger2.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
			return;
		}
		finally {
			responseObserver.onCompleted();
			try {
				channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
