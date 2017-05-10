package test.generic.extendsAndSuper;

import java.util.Iterator;
import java.util.List;

/**
 * Created by pro on 16/12/13.
 */
public class Generic<T> {

    //这个要求T必须是实现了Comparable接口的类
    public static <T extends Comparable<T>> T max(List<T> list){
        Iterator<T> i=list.iterator();
        T result=i.next();
        while(i.hasNext()){
            T t=i.next();
            if(result.compareTo(t)<0)
                result=t;
        }
        return result;
    }
    //T可以是任何实现了Comparable类的子类
    //与max的不同之处在于多了 super 以及List的参数
    public static <T extends Comparable<? super T>> T max1(List<? extends T> list){
        Iterator<? extends T> i=list.iterator();
        T result=i.next();
        while(i.hasNext()){
            T t=i.next();
            if(result.compareTo(t)<0)
                result=t;
        }
        return result;
    }
}
