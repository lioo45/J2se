package concurrency.TestonlyOneThreadMergeObject;

public class M {
	public static void main(String[] args) {
		O o=new O(0);
		R r;
		for(int i=0;i<1000;++i){
		if(i==300)
				r=new R(o,true);
		else
			r=new R(o);
			Thread t=new Thread(r);
			t.start();
		}
		System.out.println(o.getI());
	}
}
