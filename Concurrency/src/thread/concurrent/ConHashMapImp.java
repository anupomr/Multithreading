package thread.concurrent;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class ConHashMapImp extends Thread{
	static HashMap<Integer, String> map = new HashMap<Integer, String>();
	public static void main(String[] args) {
		ConHashMapImp tChild =new ConHashMapImp();
		
		map.put(1, "Anupom");
		map.put(2, "Mo");
		map.put(3, "Himadri");
		map.put(4, "Apurba");
		
		tChild.start();
		Iterator<Entry<Integer, String>> itr = map.entrySet().iterator();
		while(itr.hasNext()) {
			Entry entry=itr.next();
			System.out.println("Key = " +entry.getKey()+
					"Value = "+entry.getValue());
			
			try {
				Thread.sleep(100);
			} catch (Exception e) {				
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
		map.put(5, "Salim");
	}

}

