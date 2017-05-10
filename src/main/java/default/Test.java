import java.util.ArrayList;
import java.util.List;

public class Test {
	static class T{
		int val;
		T(int t){
			val=t;
		}
	}
	public static void main(String[] args) {
		List<Integer> list=new ArrayList<Integer>();
		list.add(0);
		list.add(2);
		list.add(1);
		list.remove(2);
		for (int i:list)
			System.out.println(i);
	}
}