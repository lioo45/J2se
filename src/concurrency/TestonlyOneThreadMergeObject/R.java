package concurrency.TestonlyOneThreadMergeObject;

public class R implements Runnable{
	private O o;
	private boolean haveRight=false;
	
	public R(O o, boolean haveRight) {
		this.o = o;
		this.haveRight = haveRight;
	}


	public R(O o) {
		this.o = o;
	}
	

	@Override
	public void run() {
		if(haveRight){
			for(int i=0;i<1000000;++i)
				o.setI(i);
		}
		else{
			if(o.getI()!=o.getI()){
				System.out.println("i!=i 存在问题!!!");
			}
		}
	}

}
