package multithreading;

public class MyRun implements Runnable {

	@Override
	public void run() {		
		for(int i= 51;i<=70;i++) {
			System.out.println(Thread.currentThread().getName()+":"+i);
		}
	}
}
