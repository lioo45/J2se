package concurrency.TestonlyOneThreadMergeObject;

public class O {
	private volatile int i;
	
	public O(int i) {
		super();
		this.i = i;
	}

	public void increase(){
		++i;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
}
