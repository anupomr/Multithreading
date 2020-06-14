package thread;

public class DemonThreadImplementation {

	public static void main(String[] args) {
		Thread demon = new Thread(new DemonThread(), "Demon thread");
		demon.setDaemon(true);
		demon.start();
		System.out.println("Main thread completd ");
	}

}
class DemonThread implements Runnable{

	@Override
	public void run() {
		try {
			while(true) {
			System.out.println("Demon Thread is Running ");
			}
		} finally {
			System.out.println("Demon thread execution completed ");
		}
		
	}
	
}
