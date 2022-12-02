package multithreading;

import java.util.ArrayList;
import java.util.List;

public class SynchronizationDemo {

	public static void main(String[] args) {
		
		MyResource myResource = new MyResource(); //shared by two threads
		
		ThreadA t1 = new ThreadA(myResource);
		t1.setName("A");
		t1.start();
		
		ThreadA t2 = new ThreadA(myResource);
		t2.setName("B");
		t2.start();
	}
}

class ThreadA extends Thread {
	
	private MyResource myResource;
	
	ThreadA(MyResource myResource) {
		this.myResource = myResource;
	}
	
	public void run() {		
		myResource.display();
	}
}

class MyResource {
	
	List<String> courses = new ArrayList<>();
	
	MyResource() {
		courses.add("java");
		courses.add("sql");
		courses.add("html");
		courses.add("css");
		courses.add("javascript");
		courses.add("jpa");
		courses.add("git");
		courses.add("spring");		
	}
	
	synchronized public void display() {		
		courses.forEach(c->System.out.println(Thread.currentThread().getName()+": "+c));
	}
}
