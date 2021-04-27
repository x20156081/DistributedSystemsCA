//JmDNS discovery class and service discovery implementation

package dist.systems.ca.JmDNS;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;

public class ServiceDiscover {
	
	private int port;
	private String host;	
	
	//option 1
	private static class MyServiceListener implements ServiceListener{

		private int port;
		private String host;
		private ServiceInfo serviceInfo;
		
		public void serviceAdded(ServiceEvent event) {
			// TODO Auto-generated method stub
			System.out.println("\nService Added " + event.getInfo());
			
		}

		public void serviceRemoved(ServiceEvent event) {
			// TODO Auto-generated method stub
			System.out.println("Service Removed " + event.getInfo());
			
		}

		public void serviceResolved(ServiceEvent event) {
			// TODO Auto-generated method stub
			System.out.println("Service Resolved " + event.getInfo());
			
			ServiceInfo serviceInfo = event.getInfo();
			this.setServiceInfo(serviceInfo);
			System.out.println("Host: " + serviceInfo.getHostAddress() + " and port: " + serviceInfo.getPort());
			System.out.println("Type: " + serviceInfo.getType() + " and name: " +serviceInfo.getName());
			//System.out.println("Computername " + serviceInfo.getServer());
			System.out.println("desc/properties " + serviceInfo.getNiceTextString());
			
		}

		public int getPort() {
			return port;
		}

		public void setPort(int port) {
			this.port = port;
		}


		public ServiceInfo getServiceInfo() {
			return serviceInfo;
		}

		public void setServiceInfo(ServiceInfo serviceInfo) {
			this.serviceInfo = serviceInfo;
		}
		
	}

	public static ServiceInfo run(String service_type) {
		
		int port = 0;
		ServiceInfo serviceInfo = null;
		
		//create JmDNS instance
		try {
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
			
			//now listen for the appropriate service type
			MyServiceListener msl = new MyServiceListener();		
			jmdns.addServiceListener(service_type, msl);
			
			//pause
			Thread.sleep(10000);
			
			serviceInfo = msl.getServiceInfo();
			port = msl.getPort();			
			jmdns.close();			
			
		} catch (UnknownHostException e) {			
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		return serviceInfo;

	}
}

