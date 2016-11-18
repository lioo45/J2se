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
		List<T> list=new ArrayList<T>();
		list.add(new T(5));
        list.add(new T(10));
//        for(T t:list){
//            t.val=20;
//        }
		System.out.println(list.get(0).val);
	}
}