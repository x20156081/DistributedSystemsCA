import java.util.Scanner;

import com.dermot.calculator.CalculatorServiceGrpc;
import com.dermot.calculator.CalculatorServiceGrpc.CalculatorServiceBlockingStub;
import com.dermot.calculator.Input;
import com.dermot.calculator.Output;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class CalculatorClient {

	public static void main(String[] args) {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();
		
		//generate stubs from proto
		CalculatorServiceBlockingStub calcStub = CalculatorServiceGrpc.newBlockingStub(channel);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number to be factorialised");
		int num = sc.nextInt();
		Input input = Input.newBuilder().setNumber(num).build();
		
		Output output = calcStub.findFactorial(input);
		System.out.println(output);
	}

}
