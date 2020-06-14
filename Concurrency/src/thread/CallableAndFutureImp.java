package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableAndFutureImp {	

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService s = Executors.newSingleThreadExecutor();
		System.out.println("Submitting task to cal factorial of 10 ");
		Future resultOffFact= s.submit(new FactorialCal(10));
		System.out.println("Submitted task to cal factorial of 10 ");
		long resultofFact10 = (long)resultOffFact.get();
		System.out.println("Factorial of 10 is : " +resultofFact10);
		s.shutdown();
	}

}
class FactorialCal implements Callable{

	private int num;
	FactorialCal(int num){
		this.num = num;
	}
	@Override
	public Long call() throws Exception {
		long result = 1;
		while(num != 0) {
			result =result * num;
			num =num-1;
			Thread.sleep(100);
		}
		return result;
	}
	
}