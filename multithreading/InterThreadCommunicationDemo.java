package multithreading;

public class InterThreadCommunicationDemo {

	public static void main(String[] args) {
	
		PrintEvenOddNumbers printNums = new PrintEvenOddNumbers();
		
		EvenThread et = new EvenThread(printNums);
		et.setName("Even");
		et.start();
		
		OddThread ot = new OddThread(printNums);
		ot.setName("Odd");
		ot.start();	
	}
}

class EvenThread extends Thread {
	
	PrintEvenOddNumbers prinNums;
	
	public EvenThread(PrintEvenOddNumbers prinNums) {
		this.prinNums = prinNums;
	}
	
	public void run() {
		prinNums.printEven();
	}
}

class OddThread extends Thread {
	
	PrintEvenOddNumbers prinNums;
	
	public OddThread(PrintEvenOddNumbers prinNums) {
		this.prinNums = prinNums;
	}
	
	public void run() {
		prinNums.printOdd();
	}
}

class PrintEvenOddNumbers {
	
	int num = 1;
	
	synchronized void printEven() {
		
		while(num < 20) {
			if(num %2 == 1) {
				try {
					wait();
				} catch (InterruptedException e) {			
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName()+": "+num);
			num++;
			notify();
		}		
	}
	
	synchronized void printOdd() {
		
		while(num <20) {
			if(num%2 == 0) {
				try {
					wait();
				} catch (InterruptedException e) {			
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName()+": "+num);
			num++;
			notify();
		}		
	}
	
}
