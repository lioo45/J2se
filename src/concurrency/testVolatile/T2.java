package concurrency.testVolatile;

public class T2 implements Runnable{
	private TestObject o;
	@Override
	public void run() {
		o.setI(1);
	}
	public T2(TestObject o) {
		super();
		this.o = o;
	}

	public TestObject getO() {
		return o;
	}
	public void setO(TestObject o) {
		this.o = o;
	}

}
