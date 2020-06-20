package lambda;

public  class DoubleColonMethodRef {

	public static void main(String[] args) {
		FunctionalInterface fi = (i) -> System.out.println("I am Lembda "+i);
		fi.method1(15);
		
		
		FunctionalInterface i = newCallerClass :: method2;
		i.method1(25);
	}
	
	// Instance method 
	public  void method3(int num) {
		System.out.println("I m here to refer me: "+num);

	}
}	
// Functional Interface
interface FunctionalInterface{
	// Abstract method
	public void method1(int i);
}

 class newCallerClass{
	
	public static void method2(int i) {
		System.out.println(" I am not a Lambda " +i);
	}
	public static void main(String[] args) {
		FunctionalInterface i = newCallerClass :: method2;
		i.method1(25);
		DoubleColonMethodRef obj = new DoubleColonMethodRef();
		FunctionalInterface i2 = new DoubleColonMethodRef() :: method3;
		i2.method1(1);
	}
}