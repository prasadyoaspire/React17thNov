package multithreading;

public class RunnableDemo {

	public static void main(String[] args) {
		
		System.out.println("Main starts....");
		
		MyRun mr = new MyRun();
				
		Thread t1 = new Thread(mr,"M1");	
		t1.start();
		
		Thread t2 = new Thread(mr,"M2");	
		t2.start();
		
		
		for(int i= 91;i<=100;i++) {
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
		
		System.out.println("Main ends....");	

	}

}
