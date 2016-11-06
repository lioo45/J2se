package concurrency.publishErrorObject;

public class M {
	public static void main(String[] args) {
		Holder h=new Holder(10);
		for(int i=0;i<100;++i){
			R r=new R(h);
			Thread t=new Thread(r);
			t.start();
		}
		for(int i=0;i<10000;++i){
			h.setI(i);
		}
	}
}
