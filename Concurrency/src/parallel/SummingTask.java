package parallel;

import java.util.List;
import java.util.concurrent.RecursiveTask;

public class SummingTask extends RecursiveTask<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final List<Integer> numbers;
	private final int min, max;
	private final int maxBatchSize = 10;

	public SummingTask(List<Integer> numbers, int min, int max) {
		this.numbers = numbers;
		this.min = min;
		this.max = max;
	}

	

	@Override
	protected Integer compute() {
		if (max - min > maxBatchSize) {
			System.out.println("This is too big for a single batch, " + "So we divide this task into two task");
			System.out.println("Min " + min);
			System.out.println("Max " + max);
			int mid = (min + max) / 2;
			System.out.println("Mid " + mid);

			SummingTask rightTask = new SummingTask(numbers, min, mid);
			System.out.println("Right task with: " + min + ", " + mid);
			SummingTask leftTask = new SummingTask(numbers, mid, max);
			System.out.println("Left task with: " + mid + ", " + max);

			leftTask.fork();

			int rightResult = rightTask.compute();

			int leftResult = leftTask.join();

			return leftResult + rightResult;
		} else {
			int sum = 0;
			for (int i = min; i < max; i++) {
				sum += numbers.get(i);
			}
			return sum;
		}

	}

}
