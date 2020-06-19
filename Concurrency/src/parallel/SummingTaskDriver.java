package parallel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class SummingTaskDriver {

	public static void main(String[] args) {
		
		ForkJoinPool pool= new ForkJoinPool(5);
		
		List<Integer> numbers = new ArrayList<>();
		numbers.add(10);
		numbers.add(10);
		numbers.add(10);
		numbers.add(10);
		numbers.add(10);
		numbers.add(10);
		numbers.add(10);
		numbers.add(10);
		numbers.add(10);
		numbers.add(10);
		numbers.add(10);
		numbers.add(10);
		numbers.add(10);
		numbers.add(10);
		numbers.add(10);
		numbers.add(10);
		numbers.add(10);
		numbers.add(10);
		numbers.add(10);
		numbers.add(10);
		numbers.add(10);
		numbers.add(10);
		numbers.add(10);
		numbers.add(10);
		numbers.add(10);
		numbers.add(10);
		numbers.add(10);
		numbers.add(10);
		numbers.add(10);
		numbers.add(10);
		numbers.add(10);
		numbers.add(10);
		numbers.add(10);
		numbers.add(10);
		numbers.add(10);
		numbers.add(10);
		numbers.add(10);
		numbers.add(10);
		numbers.add(10);
		numbers.add(10);
		
		ForkJoinTask<Integer> task= pool.submit(new SummingTask(numbers, 0, numbers.size()));
		int result = task.join();
		System.out.println(result);
		
	}

}
