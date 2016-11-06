import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class AtomicityTest implements Runnable{
	private int i;
	public int getValue(){
		return i;
	}
	public synchronized void increment(){
		++i;
		++i;
	}
	@Override
	public void run() {
		while(true)
			increment();
	}
	public static void main(String[] args) {
		ExecutorService es=Executors.newCachedThreadPool();
		AtomicityTest at=new AtomicityTest();
		es.execute(at);
		int value;
		while(true){
			value=at.getValue();
			if(value%2!=0)
				System.out.println("is qishu :"+value);
		}
	}

}
