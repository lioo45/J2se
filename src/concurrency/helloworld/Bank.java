package concurrency.helloworld;

public class Bank {
	private double[] account;
	
	public Bank(int n,int initBalance){
		account=new double[n];
		for(int i=0;i<account.length;++i)
			account[i]=initBalance;
	}
	
	public double getTotal(){
		double sum=0;
		for(int i=0;i<account.length;++i)
			sum+=account[i];
		return sum;
	}
	public void transfer(int from,int to,double amount){
		
//		synchronized(this){
			account[from]-=amount;
			account[to]+=amount;
			if(Double.compare((double)getTotal(), 100000.0)!=0){
				System.out.print(Thread.currentThread()+":");
				System.out.println("false:"+getTotal());
//			}
		}
	}
	
	public int getAccountNumber(){
		return account.length;
	}
	
}
