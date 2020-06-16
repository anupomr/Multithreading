package thread.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueImp {
	static BlockingQueue<Obj> bq= new LinkedBlockingQueue<Obj>(100);
	public static void main(String[] args) {
		Thread p1= new Thread(new Producers(bq));
		Thread p2= new Thread(new Producers(bq));
		
		Thread c1= new Thread(new Consumers(bq));
		Thread c2= new Thread(new Consumers(bq));
		p1.start();
		p2.start();
		c1.start();
		c2.start();
		
	}

}


class Producers implements Runnable{
	BlockingQueue bq;
	
	public Producers(BlockingQueue bq) {
		this.bq =bq;
	}
	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			Obj o=new Obj(" "+i);
			System.out.println("Producing items : " +o);
			try {
				bq.put(o);				
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}

		
	}
}

class Consumers implements Runnable{
	BlockingQueue bq;
	
	public Consumers(BlockingQueue bq) {
		this.bq =bq;
	}
	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			
			try {
				Obj o=(Obj) bq.take();
				System.out.println("Consuming items : " +o);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}

		
	}
}

class Obj{
	private String name;
	public Obj(String name) {
		this.name = name;
	}
}