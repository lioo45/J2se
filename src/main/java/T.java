import java.util.Random;

/**
 * Created by pro on 16/12/20.
 */
public class T {
    public static void main(String[] args) {
        int a[]=new int[9999];
        //丢失的数x,1<x<10000
        int ran= (int) (Math.random()*10000);
        for (int i = 0; i <=ran-1 ; i++)
            a[i]=i+1;
        for (int i = ran-1; i <a.length; i++)
            a[i]=i+2;
        int result=0;
//        丢失10000
//        for (int i = 0; i <a.length ; i++)
//            a[i]=i+1;
        //丢失1
//        for (int i = 0; i <a.length ; i++)
//            a[i]=i+2;
//        for (int i = 0; i <a.length ; i++)
//            System.out.println(a[i]);
        for (int i = 0; i <a.length ; i++)
            result^=a[i];
        result^=a.length+1;

        System.out.println("丢失的数: "+ran);
        System.out.println("result:"+result);
    }
}
