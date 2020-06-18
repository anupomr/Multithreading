package parallel;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DivideAndConqure {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		int array[] = {154,26,84,258,44,28,63,05,87,52,69,66};
		int min = findMinimun(array, 0, array.length-1);
		System.out.println(min);
		
	}

	private static int findMinimun(int[] array, int i, int j) throws InterruptedException, ExecutionException {
		int mid, min1,min2;
		if(i<j) {
			mid =(i+j)/2;
			//Parallel 
			ExecutorService service=Executors.newFixedThreadPool(5);
			Future<Integer> future1 = service.submit(new Callable<Integer>() {

				@Override
				public Integer call() throws Exception {
					System.out.println(Thread.currentThread() +" for min index: "
							+i+ " and max index: "+mid);
					return findMinimun(array,i,mid);
				}
				
			});
			
			Future<Integer> future2=service.submit(new Callable<Integer>() {

				@Override
				public Integer call() throws Exception {
					System.out.println(Thread.currentThread() +" for min index: "
							+mid+1+ " and max index: "+j);
					return findMinimun(array,mid+1, j);
				}
				
			});
			
			min1=future1.get();
			min2=future2.get();
			
			service.shutdown();
			if(min1<min2)
				return min1;
			else
				return min2;
		}else {
			return array[i];
		}
		
		
	}

}
