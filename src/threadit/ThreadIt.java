package threadit;


public class ThreadIt implements Runnable {

	
	private String text;
	
	public ThreadIt(String text) {
		this.text = text;
	}
	
	@Override
	public void run() {
		while (true) {
			System.out.println(text);
		}
	}
	
	
	
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		ThreadIt ti1 = new ThreadIt("Hi");
		
		ThreadIt ti2 = new ThreadIt("Hello");
		
		Thread th1 = new Thread(ti1);
		th1.start();

		Thread th2 = new Thread(ti2);
		th2.start();
		
		
		int in = 5;
		
	
		if (in == 5) {
			th1.stop();
		}
		else 
			th2.stop();
	}

}
