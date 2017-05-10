package concurrency.publishErrorObject;

public class Holder {
	private volatile int i;

	public Holder(int i) {
		this.i = i;
	}
	
	public void test(){
		while(true){
			if(i!=i){
				System.out.println("测试成功!!!");
				break;
			}
		}
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

}
