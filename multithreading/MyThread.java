package multithreading;

public class MyThread extends Thread {
	
	public void run() {		
		for(int i = 1; i<=10; i++) {
			System.out.println(Thread.currentThread().getName()+":"+i);
		}		
	}
	
	public void m1() {
		System.out.println("m1 implementation");
	}
}
