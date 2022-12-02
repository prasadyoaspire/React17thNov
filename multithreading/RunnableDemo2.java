package multithreading;

public class RunnableDemo2 {

	public static void main(String[] args) {
		
		System.out.println("Main starts....");
		
		Runnable myRun = () -> {
			for(int i= 101;i<=120;i++) {
				System.out.println(Thread.currentThread().getName()+":"+i);
			}
		};
		
		Thread t1 = new Thread(myRun,"M1");
		t1.start();
		
		System.out.println("Main ends....");

	}

}
