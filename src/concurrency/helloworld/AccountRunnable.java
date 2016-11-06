package concurrency.helloworld;

public class AccountRunnable implements Runnable{

	private Bank bank;
	
	public AccountRunnable(Bank bank) {
		this.bank=bank;
	}
	
	@Override
	public void run() {
		while(true){
			int from=(int) (bank.getAccountNumber()*Math.random());
			int to=(int) (bank.getAccountNumber()*Math.random());
			int amount=(int) (100*Math.random());
			bank.transfer(from, to, amount);
			long millis=(int) (Math.random()*10);
			try {
				Thread.sleep(millis);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
