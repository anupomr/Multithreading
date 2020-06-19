package lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortListAlgorithm {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();

		list.add(10);
		list.add(5);
		list.add(0);
		list.add(11);
		list.add(16);
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		
		//Without Lambda
		Collections.sort(list, new MyComparator());
		System.out.println(list);
		
		// Lambda
		Collections.sort(list, (arg0, arg1)->{
			if(arg0> arg1)
				return -1;
			else if(arg0<arg1)
				return 1;
			else
				return 0;
		});
		System.out.println(list);
		
	}

}
class MyComparator implements Comparator<Integer>{

	@Override
	public int compare(Integer arg0, Integer arg1) {
		if(arg0> arg1)
			return -1;
		else if(arg0<arg1)
			return 1;
		else
			return 0;					
		
	}
	
}