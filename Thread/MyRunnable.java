public class MyRunnable implements Runnable{
	public void run(){
		go();
	}
	
	public void go(){
		try{
			Thread.sleep(2000);
		}catch(Exception e){
			e.printStackTrace();
		}
		doMore();
	}
	
	public void doMore(){
			System.out.println("top o' the stack");
	}
	
	
	public static void main(String args[]) throws Exception{
		MyRunnable threadJob = new MyRunnable();
		Thread myThread = new Thread(threadJob);
		myThread.start();
		System.out.println("back in the main");
	}
	
	
}