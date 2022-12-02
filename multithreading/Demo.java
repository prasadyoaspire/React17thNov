package multithreading;

public class Demo {

	public static void main(String[] args) {
		
		System.out.println("main starts...");		
		m1();			
		System.out.println("main ends");
	}
	
	static void m1() {
		System.out.println("m1 method");
		m2();
	}
	
	static void m2() {
		System.out.println("m2 method");
	}
}
