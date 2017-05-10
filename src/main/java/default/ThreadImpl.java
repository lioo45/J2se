
public class ThreadImpl implements Runnable{

	public ThreadImpl(){
		System.out.println("Thread is starting!!!");
	}
	@Override
	public void run() {
		int i=3;
		while(i-->0)
			System.out.println("Thread is running!!!");
		System.out.println("over!!!");
	}

}
