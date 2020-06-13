package thread;

import java.util.Queue;
import java.util.Random;

public class InterThreadCommunication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class ProducerThread extends Thread {
	Queue<Integer> q;

	public ProducerThread(Queue<Integer> q, String name) {
		super(name);
		this.q = q;
	}

	public void run() {

		while (true) {
			synchronized (q) {
				while (q.size() == 3) {
					try {
						System.out.println(Thread.currentThread().getName() +
								" :q is full waiting consumer to consume");
						q.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				Random r = new Random();
				int i = r.nextInt();
				q.add(i);
				System.out.println(" Item Produce :  "+i);
				q.notifyAll();
			}
		}
	}
}

class ConsumerThread extends Thread {
	Queue<Integer> q;

	public ConsumerThread(Queue<Integer> q) {
		// TODO Auto-generated constructor stub
		this.q = q;
	}

	public void run() {
		while (true) {
			synchronized (q) {
				while (q.isEmpty()) {
					try {
						System.out.println(Thread.currentThread().getName() +
								" q is empty waiting Producer to produce");
						q.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(" Item consumed :  "+q.remove());				
				q.notifyAll();
			}
		}
	}

}