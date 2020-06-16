package thread.concurrent;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;

public class CopyOnWriteArraySetImp {

	public static void main(String[] args) {
		CopyOnWriteArraySet<String> set = new CopyOnWriteArraySet<>();
		ArrayList<String> list = new ArrayList<String>();
		list.add("Anupom");
		list.add("Anupom");
		list.add("Stephen");
		list.add("Stephen");
		
		// Make unique 
		CopyOnWriteArraySet<String> set1 = new CopyOnWriteArraySet<>(list);
		
		System.out.println(set1);
		}

}
