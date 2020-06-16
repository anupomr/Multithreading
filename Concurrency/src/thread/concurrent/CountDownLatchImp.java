package thread.concurrent;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchImp {
	public static void main(String[] args) throws InterruptedException {
		final  CountDownLatch latch =new CountDownLatch(3) ;
		Thread fileProcessor1 = new Thread(new FileService(latch), "FileProcessor1");
		Thread fileProcessor2 = new Thread(new FileService(latch), "FileProcessor2");
		Thread fileProcessor3 = new Thread(new FileService(latch), "FileProcessor3");
		fileProcessor1.start();
		fileProcessor2.start();
		fileProcessor3.start();
		
		latch.await();
		System.out.println("Eatch File process has completed the task");
		
	}

}
class FileService implements Runnable{
	private final CountDownLatch latch;
	FileService (CountDownLatch latch){
		this.latch = latch;
	}
	@Override
	public void run() {
	System.out.println(Thread.currentThread()+
			" : My Files Processed");
	latch.countDown();
	}
	
}