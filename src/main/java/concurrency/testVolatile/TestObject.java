package concurrency.testVolatile;

public class TestObject {
	private  volatile int i=0;

	public void increment(){
		i++;
	}
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
}
