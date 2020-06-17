package stream;

import java.util.ArrayList;
import java.util.List;

public class ParallelStreamsImp {

	public static void main(String[] args) {
		long time1, time2;
		List<Employee> eList = new ArrayList<Employee>();
		for (int i = 0; i < 100; i++) {
			eList.add(new Employee("Anupom",160000));
			eList.add(new Employee("Roy",120000));
			eList.add(new Employee("Tuhin",3000));
			eList.add(new Employee("Jacob",1000));
			eList.add(new Employee("Sima",200));
			eList.add(new Employee("Dipa",8000));
		}
		//Sequential processing 
		time1= System.currentTimeMillis();
		System.out.println("Sequential Stream Count = "
							+eList.stream().filter(e -> e.getSalary()>1000).count());
		time2= System.currentTimeMillis();
		System.out.println("Sequential Stream time taken : "+ (time2-time1));
		
		// Parallel Processing 
		time1= System.currentTimeMillis();
		System.out.println("Parallel Stream Count = "
							+eList.parallelStream().filter(e -> e.getSalary()>1000).count());
		time2= System.currentTimeMillis();
		System.out.println("Parallel Stream time taken : "+ (time2-time1));
	}

}
