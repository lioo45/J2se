package interview;

import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by pro on 17/3/4.
 */
public class OfferP234 {

    private static int result=1;

    public static void main(String[] args) {
        test(5,new int[5]);
        System.out.println(result+"-----ok");
    }

    public static void test(int n,int a[]){
        result*=n;
        try {
            int i = a[n - 2];
        }catch (Exception e){
            return ;
        }
        test(--n,a);
    }
}
