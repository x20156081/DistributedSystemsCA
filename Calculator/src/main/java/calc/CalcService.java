package calc;

import com.dermot.calculator.CalculatorServiceGrpc.CalculatorServiceImplBase;
import com.dermot.calculator.Input;
import com.dermot.calculator.Output;

import io.grpc.stub.StreamObserver;

public class CalcService extends CalculatorServiceImplBase{

	@Override
	public void findFactorial(Input request, StreamObserver<Output> responseObserver) {
		System.out.println("Welcome to factorial calculator");
		
		int input = request.getNumber();
        long result = this.factorial(input);
        Output output = Output.newBuilder()
                .setResult(result)
                .build();
        responseObserver.onNext(output);
        responseObserver.onCompleted();
	}

	private long factorial(int number) {
		if(number == 0) {
            return 1;
		} else {
        return number * factorial(number - 1);
		}
	}
	
}
