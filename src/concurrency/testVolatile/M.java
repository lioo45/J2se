package concurrency.testVolatile;

public class M {
	public static void main(String[] args) {
		
		for(int i=0;i<1000;++i){
			TestObject o=new TestObject();
			T1 t1=new T1(o);
			T2 t2=new T2(o);
			Thread th=new Thread(t1);
			Thread th2=new Thread(t2);
			th.start();
			th2.start();
			
		}	
	}
}
