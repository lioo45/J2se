package concurrency.publishErrorObject;

public class R implements Runnable {
	private volatile Holder holder;
	public R(Holder holder) {
		this.holder = holder;
	}
	@Override
	public void run() {
		for(int i=0;i<10;++i)
			holder.setI(i);
		holder.test();
	}

}
