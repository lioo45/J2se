package concurrency.testVolatile;

public class T1 implements Runnable{
	private TestObject o;
	@Override
	public void run() {
		System.out.println(o.getI());
	}
	public T1(TestObject o) {
		this.o = o;
	}
	public TestObject getO() {
		return o;
	}
	public void setO(TestObject o) {
		this.o = o;
	}
	
}
