import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by pro on 17/1/16.
 */
public class T1 {
    public static void main(String[] args) {
        System.out.println(test());


    }

    static class AB{
        int x;
    }



    public static int test(){
        AB a=new AB();
        try{
            a.x=6;
            int b=7/0;
            return a.x;
        }catch (Exception e){
            a.x=7;
            return a.x;
        }finally {
            a.x=8;
        }
    }

}
