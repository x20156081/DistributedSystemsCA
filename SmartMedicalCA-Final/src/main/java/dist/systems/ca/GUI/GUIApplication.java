//GUI application to discover three services, on 3 different servers, and invoke rpc methods

package dist.systems.ca.GUI;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jmdns.ServiceInfo;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import dist.systems.ca.JmDNS.ServiceDiscover;
import dist.systems.ca.service1.AuthenticateGrpc;
import dist.systems.ca.service1.AuthenticateGrpc.AuthenticateBlockingStub;
import dist.systems.ca.service1.CheckInReply;
import dist.systems.ca.service1.CheckInRequest;
import dist.systems.ca.service2.MedWaitRoomGrpc;
import dist.systems.ca.service2.MedWaitRoomGrpc.MedWaitRoomBlockingStub;
import dist.systems.ca.service2.MedWaitRoomGrpc.MedWaitRoomStub;
import dist.systems.ca.service2.acceptance;
import dist.systems.ca.service2.answer;
import dist.systems.ca.service2.waitTimeReply;
import dist.systems.ca.service2.waitingRoomEntry;
import dist.systems.ca.service3.ChatGrpc;
import dist.systems.ca.service3.ChatGrpc.ChatStub;
import dist.systems.ca.service3.chatMsg;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;


public class GUIApplication {
		
	//stubs/logs for Service No.1... Authenticate....Unary rpc
	private static final Logger logger = Logger.getLogger(GUIApplication.class.getName());
	private static AuthenticateBlockingStub stub;
	
	//stubs/logs for Service No. 2...WaitRoom.... Client Stream & Server Streaming rpc
	private static final Logger logger2 = Logger.getLogger(GUIApplication.class.getName());
	private static MedWaitRoomStub asyncStub2;
	private static MedWaitRoomBlockingStub stub2;
	
	//stubs/log for Service No. 3...Chat... Bi-Directional rpc
	private static final Logger logger3 = Logger.getLogger(GUIApplication.class.getName());	
	private static ChatStub asyncStub3;
	
	//declare field and area names for gui display
	private JFrame frame;
	private JTextField userName;
	private JTextField userNo;
	private JTextField ans1;
	private JTextField ans2;
	private JTextField ans3;
	private JTextField chatMsg1;
	private JTextArea textResponse;
	private JTextArea textResponse2;
	private JTextArea textResponse3;
	private JTextArea textResponse4;
	
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
		frame.setBounds(100, 100, 1000, 600);
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
		
		//button to trigger unary rpc call to server
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

		loginPanel.add(scrollPane);
		
		
		
		//Panel 2 - Liabiltiy Q1		
		JPanel liabilityPanel1 = new JPanel();
		frame.getContentPane().add(liabilityPanel1);
		liabilityPanel1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_3 = new JLabel("Q1. Do you consent to Smart Med Clinic's official terms of service? (Y/N)");
		liabilityPanel1.add(lblNewLabel_3);
		
		ans1 = new JTextField();
		liabilityPanel1.add(ans1);
		ans1.setColumns(4);		
		
		//
		//Liability Panel 2 - Q2
		JPanel liabilityPanel2 = new JPanel();
		frame.getContentPane().add(liabilityPanel2);
		liabilityPanel2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_4 = new JLabel("Q2. Enter your height in metres here (e.g. 1.66) : ");
		liabilityPanel2.add(lblNewLabel_4);
		
		ans2 = new JTextField();
		liabilityPanel2.add(ans2);
		ans2.setColumns(4);		
		
		
		//Liability Panel 3 - Q3
		
		JPanel liabilityPanel3 = new JPanel();
		frame.getContentPane().add(liabilityPanel3);
		liabilityPanel3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_5 = new JLabel("Q3. Enter your weight in kgs here (e.g. 70.5) : ");
		liabilityPanel3.add(lblNewLabel_5);
		
		ans3 = new JTextField();
		liabilityPanel3.add(ans3);
		ans3.setColumns(4);
		
		//answer button will begin stream of message to server - client side streaming
		JButton btnAnswers = new JButton("Stream answers");
		liabilityPanel3.add(btnAnswers);
		btnAnswers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					StreamObserver<acceptance> responseObserver = new StreamObserver<acceptance>() {

					@Override
					public void onNext(acceptance value) {
						//display client side streaming response
						System.out.println();
						System.out.println("Response message from server: Liability responses received by clinic.");
						System.out.println("Response from server: " + value.getServerReply());
						if(value.getAccepted()) {
							System.out.println("Thank you for your consent. Please continue waiting. Your BMI is " + value.getBmiRes());
							textResponse2.append("Thank you for your consent. Please continue waiting. Your BMI is " + value.getBmiRes());
						} else {
							System.out.println("Please contact reception to determine consent.");
						}
					}

					@Override
					public void onError(Throwable t) {
						logger2.log(Level.WARNING, "RPC failed: {0}", t.getCause());			    
					    return;	
					}

					@Override
					public void onCompleted() {
						System.out.println();
					}
					};
					
					//Take user input. Stream consecutive answers from the client to the server
					StreamObserver<answer> requestObserver = asyncStub2.streamClientDetails(responseObserver);
					requestObserver.onNext(answer.newBuilder().setAnswerNo(1).setRetort(ans1.getText().toLowerCase()).build());
					Thread.sleep(1000);					
					
					requestObserver.onNext(answer.newBuilder().setAnswerNo(2).setMetrics(Double.parseDouble(ans2.getText())).build());
					Thread.sleep(1000);
					
					requestObserver.onNext(answer.newBuilder().setAnswerNo(3).setMetrics(Double.parseDouble(ans3.getText())).build());
					Thread.sleep(1000);
					
					requestObserver.onCompleted();		
					}
					catch (StatusRuntimeException e1) {
						System.out.println(e1.getMessage());
						return;
					} catch (InterruptedException e2) {
						e2.printStackTrace();
					}
			}
			
		});
		
		//Liability response Panel 
		
		JPanel liabilityResponsePanel = new JPanel();
		frame.getContentPane().add(liabilityResponsePanel);
		liabilityResponsePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_6 = new JLabel("Liability client stream response");
		liabilityResponsePanel.add(lblNewLabel_6);
		
		textResponse2 = new JTextArea(3, 30);
		textResponse2 .setLineWrap(true);
		textResponse2.setWrapStyleWord(true);
		
		JScrollPane scrollPane2 = new JScrollPane(textResponse2);

		liabilityResponsePanel.add(scrollPane2);
		
		
		
		//Timer start Panel
		JPanel timerPanel = new JPanel();
		frame.getContentPane().add(timerPanel);
		timerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		//waitRoomBtn - will trigger server side streaming rpc 
		JButton waitRoomBtn = new JButton("Wait Room - click here");
		liabilityPanel3.add(waitRoomBtn);
		
		JLabel lblNewLabel_7 = new JLabel("Waiting times - server stream");
		timerPanel.add(lblNewLabel_7);
		timerPanel.add(waitRoomBtn);
		
		waitRoomBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				waitingRoomEntry entry = waitingRoomEntry.newBuilder().setHasEnteredWaitRoom(true).setPatientFirstName("Joe").setHasEnteredWaitRoom(true).build();
				StreamObserver<waitTimeReply> responseObserver = new StreamObserver<waitTimeReply>() {

					@Override
					public void onNext(waitTimeReply value) {
						//set the response message and minutes value from server, dependent on the time remaining
						//display stream of message updates to client
						if(value.getMinutes()==0) {
							System.out.println();
							System.out.println("Update! " + value.getTimeMsg());
							textResponse3.append("Update! " + value.getTimeMsg());
							
							
						} else {
							System.out.println("Update! " + value.getTimeMsg() + ". Waiting time approx.: " + value.getMinutes() + " minutes. ");
							textResponse3.append("Update! " + value.getTimeMsg() + ". Waiting time approx.: " + value.getMinutes() + " minutes. ");

						}
					}

					@Override
					public void onError(Throwable t) {
						logger2.log(Level.WARNING, "RPC failed: {0}", t.getCause());			    
					    return;	
					}

					@Override
					public void onCompleted() {
						System.out.println("Waiting times stream completed. Shutting down Waiting Room Service.");
						System.out.println();
					}
					
				};		
				
				try {
					Iterator<waitTimeReply> replies = stub2.waitingTimerStream(entry);
					//monitoring response observer and output server stream responses via onNext
					while(replies.hasNext()) {
						waitTimeReply temp = replies.next();
						responseObserver.onNext(temp);
					}
				} catch(StatusRuntimeException e1){
					logger2.log(Level.WARNING, "RPC failed: {0}", e1.getStatus());
					return;
				}
			}
			
		});
		
		//Timer display Panel
		JPanel timerPanelOut = new JPanel();
		frame.getContentPane().add(timerPanelOut);
		timerPanelOut.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		textResponse3 = new JTextArea(3, 40);
		textResponse3.setLineWrap(true);
		textResponse3.setWrapStyleWord(true);
		
		JScrollPane scrollPane3 = new JScrollPane(textResponse3);
		timerPanelOut.add(scrollPane3);
		
		
		//Chat service panel - bidirectional
		JPanel chat1Panel = new JPanel();
		frame.getContentPane().add(chat1Panel);
		chat1Panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_8 = new JLabel("Next chat msg:");
		chat1Panel.add(lblNewLabel_8);
		
		chatMsg1 = new JTextField();
		chat1Panel.add(chatMsg1);
		chatMsg1.setColumns(12);
		
		//'btnSend' to invoke bi-directional streaming Chat service
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StreamObserver<chatMsg> responseObserver = new StreamObserver<chatMsg>() {

					@Override
					public void onNext(chatMsg value) {
						System.out.println(value.getMessage());
						textResponse4.append("Reply from SmartMed: " + value.getMessage());
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
				
				clientObserver.onNext(chatMsg.newBuilder().setMessage("Open Chat Request").setMessageNo(1).build());

				clientObserver.onNext(chatMsg.newBuilder().setMessage(chatMsg1.getText().toLowerCase()).setMessageNo(2).build());

				try {
					Thread.sleep(3000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}	
				System.out.println("Chat service closing");
			}
		});
		chat1Panel.add(btnSend);
		
		//arrange chat response message display
		textResponse4 = new JTextArea(3, 30);
		textResponse4 .setLineWrap(true);
		textResponse4.setWrapStyleWord(true);
		
		JScrollPane scrollPane4 = new JScrollPane(textResponse4);

		chat1Panel.add(scrollPane4);
		
	}
}
