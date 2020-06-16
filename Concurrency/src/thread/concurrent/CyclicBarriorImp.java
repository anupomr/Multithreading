package thread.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarriorImp {

	public static void main(String[] args) {
		CyclicBarrier barrier = new CyclicBarrier(3, new BarrierMaster());
		Thread t1 = new Thread(new Task(barrier), "Thread 1");
		Thread t2 = new Thread(new Task(barrier), "Thread 2");
		Thread t3 = new Thread(new Task(barrier), "Thread 3");
		
		t1.start();
		t2.start();
		t3.start();
	}

}
class BarrierMaster implements Runnable{
	@Override
	public void run() {
		System.out.println("Thank you every one");
	}
}

class Task implements Runnable{
	private CyclicBarrier barrier;
	Task(CyclicBarrier barrier){
		this.barrier = barrier;
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " I  am done with my task");
		try {
			barrier.await();
			System.out.println(Thread.currentThread().getName() + " I  am done with another task");
			barrier.await();
		} catch (InterruptedException e) {			
			e.printStackTrace();
		} catch (BrokenBarrierException e) {			
			e.printStackTrace();
		}
	}
	
}