package lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class PredicateImple {

	public static void main(String[] args) {
				
		// Predicate 
		int salary = 5000;
		Predicate<Integer> p= i-> i>4000;
		boolean result = p.test(salary);
		System.out.println(result);
		
		// Function
		Function<String, Integer> fun =str -> str.length();
		String s= "Anupom";
		int len =fun.apply(s);
		System.out.println(len);
		
		// Consumer
		Consumer<String> c = e -> System.out.println(e);
		c.accept("Anupom Roy");
		
		// Supplier
		Supplier<String> str =()->"Functional Interface";
		System.out.println(str.get());
	}

}
