package pratice.算法第一次上机.three;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by pro on 17/3/22.
 */
public class Main {
    public static void main(String[] args) {
        int testNum=100;
        Random random=new Random();
        int i;
        int a[]=new int[testNum];
        for(i=testNum-1;i>=0;--i){
            int rand=random.nextInt(10000000)+random.nextInt(100000)+random.nextInt(1000)+random.nextInt(100);
            a[i]=rand;
        }
        int[] b= Arrays.copyOf(a,a.length);

        for (int v:a)
            System.out.print(v+",");
        System.out.println();
        QuickSort.sort(b);

        for(int j:b)
            System.out.print(j+",");
        System.out.println();
        System.out.println("---------------------------");
        int[] c=Arrays.copyOf(a,a.length);
        //随机快排
        QuickSort.sortWithRand(c);
        for(int j:c)
            System.out.print(j+",");
        System.out.println();


    }
}
