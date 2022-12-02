package multithreading;

public class JoinDemo {

	public static void main(String[] args) {

		System.out.println("Main Starts....");
		DemoThread2 t1 = new DemoThread2();
		t1.setName("T1");
		t1.start();
				
		try {
			t1.join();
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		
		for(int i= 21;i<=30;i++) {
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
		System.out.println("Main Ends....");
	}
}

class DemoThread2 extends Thread {
	public void run() {	
		MyClass mc = new MyClass();
		mc.printNumbers();
	}
}
class MyClass  {
	
	public void printNumbers() {
		for (int i = 1; i <= 10; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + i);		
		}
	}
}

