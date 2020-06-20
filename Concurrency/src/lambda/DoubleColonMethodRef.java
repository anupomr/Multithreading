package lambda;

// Double Colon Method need to same argument
public class DoubleColonMethodRef {

	public static void main(String[] args) {
		FunctionalInterface fi = (i) -> System.out.println("I am Lembda " + i);
		fi.method1(15);

		FunctionalInterface i = newCallerClass::method2;
		i.method1(25);

		// Object reference
		newCallerClass obj = new newCallerClass();
		FunctionalInterface i2 = obj::method3;
		i2.method1(1);

		// Constructor Reference
		Details d = Student::new;
		d.getStudent("Anupom");
	}

}

// Functional Interface
interface FunctionalInterface {
	// Abstract method
	public void method1(int i);
}

class newCallerClass {
	// Instance method
	public void method3(int num) {
		System.out.println("I m here to refer me: " + num);

	}
	// static Method
	public static void method2(int i) {
		System.out.println(" I am not a Lambda " + i);
	}

	public static void main(String[] args) {
		FunctionalInterface i = newCallerClass::method2;
		i.method1(25);

	}
}

// Constructor Reference
class Student {
	public Student(String name) {
		System.out.println(name + " is successfully enrolled !");
	}
}

interface Details {
	public Student getStudent(String name);
}