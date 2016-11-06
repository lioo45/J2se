
public class ThreadTest {
	public static void main(String[] args) {
		int i=1;
		Thread t=null;
		while(i-->0){
			t=new Thread(new ThreadImpl());
			t.start();
		}
		System.out.println(Thread.NORM_PRIORITY);
	}
}
