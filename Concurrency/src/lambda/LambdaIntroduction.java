package lambda;

public class LambdaIntroduction {

	public static void main(String[] args) {

		MyFunctionalInterface funInterLamda =(a, b) -> System.out.println("The sum of a and b : "+(a+b));
		funInterLamda.funMethodAdd(10,20);
		
		ValidFunctionalInterface i = s-> s.length();
		int len = i.funMethodLength("Lembda");
		System.out.println("Length of the given string : "+len);
		
		// Multi-lines Lambda
		FunctionalInterfaceCal i3 = a-> {
			int x =a +10;
			x=x/2;
			return x;
		};
		 
		System.out.println(i3.funMethodCal(100));

	}
	
}

interface MyFunctionalInterface{
	public void funMethodAdd(int a, int b);
}

@FunctionalInterface
interface ValidFunctionalInterface{
	public int funMethodLength(String s);
}

interface FunctionalInterfaceCal{
	public int funMethodCal(int a);
}
