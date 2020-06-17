package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsIntroduction {

	public static void main(String[] args) {
		ArrayList<Integer> list= new ArrayList<Integer>();
		list.add(30);
		list.add(10);
		list.add(40);
		list.add(20);
		
		System.out.println(list);
		
		ArrayList<Integer> newList= new ArrayList<Integer>();
			for(Integer i : list) {
				if(i>=30) {
					newList.add(i);
				}
			}
		System.out.println(newList);
		
		// Streams		
		List<Integer> l1= list.stream().filter(i -> i>=30)
				.collect(Collectors.toList());
		System.out.println(l1);		
		
		// Map
		List<Integer> l2 = list.stream().map(i -> i*2).collect(Collectors.toList());
		System.out.println(l2);
		
		// Count
		long count= list.stream().filter(i -> i>=30).count();
		System.out.println(count);
		
		// Default Natural sorting : Sorted ()
		List l3 = list.stream().sorted().collect(Collectors.toList());
		System.out.println(l3);
		
		// Custom Sorting : sorted(Comparator c)
		List l4 = list.stream().sorted((i1,i2) -> i2.compareTo(i1)).collect(Collectors.toList());
		System.out.println(l4);
		
		
	}

}
