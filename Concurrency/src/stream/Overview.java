package stream;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class Overview {

	public static void main(String[] args) {
	
		// Stream is an iterator 
		List<Integer> l = Arrays.asList(1,2,6,3,4,5,3,7,8,9);
		
		for (int i = 0; i < l.size(); i++) {
			System.out.println(l.get(i));
		}
		
		//Function Style 
		System.out.println(" Function Style ");
		l.stream().forEach(e -> System.out.println(e));
		System.out.println("-----------------------");
		System.out.println(l.stream().map(e -> e+1).findFirst().get().intValue());
		System.out.println("-----------------------");
		l.parallelStream().forEach(e -> System.out.println(e));
		
		// Fork Join Pool
		ForkJoinPool pool = new ForkJoinPool(5);
		System.out.println("-----------------------");
		System.out.println(pool.commonPool());
		
		// Computer Processor (How many core the system have)
		
		System.out.println("-----------------------");
		System.out.println(" Computer Processor = "+Runtime.getRuntime().availableProcessors());
	}

}
