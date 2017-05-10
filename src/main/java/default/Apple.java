
public class Apple implements Runnable{
	private int number;
	
	public Apple(){
		System.out.println("apple");
	}
	public Apple(int number){
		this.number=number;
	}
	public void add(){
		number++;
		number++;
	}
	public void tttt(){
		System.out.println(this);
	}
	public void run(){
		add();
	}
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
}
