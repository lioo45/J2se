import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class DualSync implements Runnable{
	public Object synObj=new Object();
	
	public synchronized void f(){
		for(int i=0;i<5;++i){
			System.out.println("f()");
			Thread.yield();
		}
	}
	
	public void g(){
		synchronized(synObj){
			for(int i=0;i<5;++i){
				System.out.println("g()");
				Thread.yield();
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		ExecutorService es=Executors.newCachedThreadPool();
		DualSync d=new DualSync();
		es.execute(d);
		d.g();
	}

	@Override
	public void run() {
		f();
	}
}
