package multithreading;

public class ThreadDemo1 {

	public static void main(String[] args) {
		
		System.out.println("Main starts....");
		
		MyThread mt = new MyThread();	
		mt.setName("T1");
		mt.start(); // indirectly calls run method
		
		MyThread mt2 = new MyThread();	
		mt2.setName("T2");
		mt2.start(); // indirectly calls run method		
		
		for(int i=21; i<=30;i++) {
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
		
		System.out.println("Main ends....");
	}
}
