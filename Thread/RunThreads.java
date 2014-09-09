public class RunThreads implements Runnable{
	public void run(){
		for(int x=0;x<25;x++){
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName + "is running");
		}
	}
	
	public static final void main(String args[]){
		RunThreads runner = new RunThreads();
		Thread alpha = new Thread(runner);
		Thread beta = new Thread(runner);
		alpha.setName("ALPHA");
		beta.setName("BETA");
		alpha.start();
		beta.start();
	}
	
}