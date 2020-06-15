package thread.concurrent;

import java.util.ArrayList;
import java.util.Iterator;

public class ConcurrentModiDemo extends Thread{
	private static ArrayList<String> list= new ArrayList<String>();
	public static void main(String[] args) {
		ConcurrentModiDemo tchild = new ConcurrentModiDemo();
		list.add("Anupom");
		list.add("Roy");
		list.add("Stephen");
		list.add("Prash");
		
		Iterator itr= list.iterator();
		tchild.start(); // will generate error 4 Concurrent Modification 
		while(itr.hasNext()) {
			String name = (String) itr.next();
			System.out.println("Main Thread is itrating -> " + name);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}
	}
	public void run() {
		try {
			Thread.sleep(100);
		} catch (Exception e) {
			e.printStackTrace();
		}
		list.add("Gonesh");
	}

}
