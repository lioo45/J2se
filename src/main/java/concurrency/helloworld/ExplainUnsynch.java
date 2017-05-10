package concurrency.helloworld;

public class ExplainUnsynch {
	public static void main(String[] args) {
		int accountNumber=100;
		int initBalance=1000;
		Bank bank=new Bank(100,1000);
		
		for(int i=0;i<100;++i){
			Runnable r=new AccountRunnable(bank);
			Thread t=new Thread(r);
			t.start();
		}

	}
}
