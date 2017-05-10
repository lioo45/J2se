package pratice.算法第一次上机.two;

import java.util.Random;

/**
 * Created by pro on 17/3/22.
 */
public class Main {

    public static void main(String[] args) {
//        int[] a={10,5,7,3,2,65,8,9,4,22,43,60};
        int testNum=10000;
        Random random=new Random();
        int i;
        int a[]=new int[testNum];
        for(i=testNum-1;i>=0;--i){
            int rand=random.nextInt(10000000)+random.nextInt(100000)+random.nextInt(1000)+random.nextInt(100);
            a[i]=rand;
        }
        PriorityQueue queue=new PriorityQueue();
        for(int v:a){
            queue.push(v);
        }
        for (i = 0; i <queue.getSize() ;) {
            System.out.print(queue.pop()+",");
        }
        System.out.println();

    }

    public static boolean test(int[] a ){
        for (int i = 1; i <a.length ; i++) {
            if(a[i]<a[i-1])
                return false;
        }
        return true;
    }


}
