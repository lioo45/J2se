package myDataStructure.SkipList;

import java.util.Random;

/**
 * Created by pro on 17/3/13.
 */
public class Main {
    static final int test=1000000;
    public static void main(String[] args) {
        SkipList sl=new SkipList();
        Random random=new Random();
        int[] a=new int[test];
        for (int i = 0; i <test ; i++)
            a[i]=random.nextInt(100000000)+random.nextInt(1000000)+random.nextInt(10000)+random.nextInt(100);
        for (int i = 0; i <a.length ; i++) {
            sl.add(a[i]);
//            sl.add(i);
        }
        for (int i = 0; i <a.length ; i++) {
            if(!sl.contains(a[i]))
                System.out.println(a[i]);
//            if(!sl.contains(i))
//                System.out.println(i);
        }

        System.out.println("测试:"+sl.testAll());
        sl.printHeadsIndex(0);
        System.out.println("=================");
        sl.printAllLen();
        System.out.println();
    }

}
