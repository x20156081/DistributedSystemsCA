//class for JmDNS service discovery

package dist.systems.ca.JmDNS;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

public class ServiceRegister {

	public void run(int port, String service_type, String service_name) {

		//JmDNS - creating instance
		try {
			JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
					
			int service_port = port;
			String service_desc = "JmDNS for Smart Medical Clinic";
							
			//create a serviceInfo, typ ServiceInfo			
			ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port, service_desc);
			
			//now register that service
			jmdns.registerService(serviceInfo);
			
			System.out.printf("registering service with type: %s and name: %s on port %d ", service_type, service_name, service_port);
			
			//short pause
			Thread.sleep(5000);
			System.out.println("\nService Registered");
			//unregister, if/when necessary
			//jmdns.unregisterAllServices();   
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}


}
