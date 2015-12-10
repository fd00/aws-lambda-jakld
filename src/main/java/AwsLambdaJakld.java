import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class AwsLambdaJakld implements RequestHandler<String, String> {
	@Override
	public String handleRequest(String input, Context context) {
		Eval.initializeSystem();
		Eval.runProgram("(define (fib n) (if (< n 2) n (+ (fib (- n 2)) (fib (- n 1)))))");
		return Eval.runProgram(input).toString();
	}
}
