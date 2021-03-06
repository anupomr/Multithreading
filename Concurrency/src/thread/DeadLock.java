package thread;

public class DeadLock {
	Resource resource1 = new Resource();
	Resource resource2 = new Resource();

	public void method1() {
		synchronized (resource2) {
			System.out.println("Aquired lock on resource2 by :" +
					Thread.currentThread());
			synchronized (resource1) {
				System.out.println("Aquired lock on resource1 by :" +
						Thread.currentThread());
			}
		}
	}

	public void method2() {
		synchronized (resource1) {
			System.out.println("Aquired lock on resource1 by :" +
					Thread.currentThread());
			synchronized (resource2) {
				System.out.println("Aquired lock on resource2 by :" +
						Thread.currentThread());
			}
		}
	}
	public static void main(String[] args) {
		DeadLock d = new DeadLock();
		Thread thread1 = new Thread(new T1(d));
		Thread thread2 = new Thread(new T2(d));
		thread1.start();
		thread2.start();
	}

}

class Resource {
}

class T1 implements Runnable {
	DeadLock d;

	T1(DeadLock d) {
		this.d = d;
	}

	@Override
	public void run() {
		d.method1();
	}
}

class T2 implements Runnable {
	DeadLock d;

	T2(DeadLock d) {
		this.d = d;
	}

	@Override
	public void run() {
		d.method2();
	}
}