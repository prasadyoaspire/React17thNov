package multithreading;

public class SleepDemo {

	public static void main(String[] args) {
		
		System.out.println("Main Starts....");
		
		DemoThread t1 = new DemoThread();
		t1.setName("T1");
		t1.start();		
		
		System.out.println("Main Ends....");
	}
}

class DemoThread extends Thread {
	public void run() {
		for(int i=1;i<=10;i++) {
			System.out.println(Thread.currentThread().getName()+":"+i);			
			try {
				Thread.sleep(5*1000);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}
	}
}
