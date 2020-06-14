package thread;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo {

	public static void main(String[] args) {
		ExecutorService eService = Executors.newFixedThreadPool(20);
		ArrayList<MyTask> list = new ArrayList<>(100);
		for (int i = 0; i < 100; i++) {
			list.add(new MyTask());
		}
		for (MyTask task : list) {
			 System.out.println("Inside for loop");
			eService.submit(task);
		}
		eService.shutdown();
	}

}
class MyTask implements Runnable{
	@Override
	public void run() {
		System.out.println("Thread "+Thread.currentThread().getName()+
				"is executing the Task");
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
	}
}
