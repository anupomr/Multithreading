package thread.concurrent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArraylistImp {
	 //static ArrayList<String> list= new ArrayList<String>();
	 static CopyOnWriteArrayList<String> list= new CopyOnWriteArrayList<String>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		list.add("Anupom");
		list.add("Roy");
		list.add("Stephen");
		list.add("Prash");
		
		Iterator itr =list.iterator();
		while(itr.hasNext()) {
			String name = (String) itr.next();
			if(name.equals("Roy")) {
				itr.remove();
			}
		}
		System.out.println(list);
	}

}
