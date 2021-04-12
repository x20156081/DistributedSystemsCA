import java.io.IOException;

import calc.CalcService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class CalcServer {
	public static void main(String[] args) throws IOException, InterruptedException{
		Server server = ServerBuilder.forPort(9090).addService(new CalcService()).build();
		
		server.start();
		
		System.out.println("Server started at: " + server.getPort());
		
		server.awaitTermination();
	}
}
