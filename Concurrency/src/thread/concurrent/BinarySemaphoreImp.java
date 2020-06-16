package thread.concurrent;

import java.util.concurrent.Semaphore;

public class BinarySemaphoreImp {
	Semaphore binary = new Semaphore(1);
	public static void main(String[] args) {
		final BinarySemaphoreImp test = new BinarySemaphoreImp();
		
		 new Thread() {
			 public void run() {
				 test.mutualExecusion();
			 }
		 }.start();
		 new Thread() {
			 public void run() {
				 test.mutualExecusion();
			 }
		 }.start();
		
	}
	
	private void mutualExecusion() {
		try {
			binary.acquire();
			System.out.println(Thread.currentThread().getName()+
					"  : inside mutual Exclusive region");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			binary.release();
			System.out.println(Thread.currentThread().getName()+
					"  : outside mutual Exclusive region");
		}
	}

}
