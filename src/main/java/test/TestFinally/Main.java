package test.TestFinally;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pro on 17/3/12.
 */
public class Main {

    static class Holder{
        int i;
        public  Holder(int i){
            this.i=i;
        }
    }
    static Integer i;
    public static void main(String[] args) {

        Map<String,Holder> map=new HashMap<String, Holder>();
        Holder origin;
        map.put("1",origin=new Holder(1));
        Holder k=map.get("1");
        k.i=5;
        Holder j=map.get("1");
        System.out.println(j.i);
        System.out.println(k==origin);
        System.out.println(j==origin);

        Map<String,Integer> map2=new HashMap<String, Integer>();
        Integer intOrigin;
        map2.put("2",intOrigin=new Integer(2));
        Integer i1=map2.get("2");
        i1=new Integer("6");
        Integer i2=map2.get("2");
        System.out.println(i2);
        System.out.println(intOrigin==i1);
        System.out.println(intOrigin.equals(i1));
        System.out.println(intOrigin.equals(i2));

//        System.out.println(test());
    }

    public static int test(){
        i=5;
        try{
            return i;
        }finally {
            i=3;
        }
    }
}
