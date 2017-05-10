package huawei;

import java.util.Random;

/**
 * Created by pro on 17/3/22.
 */
public class CountingSort_e {
    public static void main(String[] args) {
        int testNum=100;
        int i;
        Random random=new Random();
        int a[]=new int[testNum];
        for(i=testNum-1;i>=0;--i){
            int rand=random.nextInt(100000)+random.nextInt(1000)+random.nextInt(100)+random.nextInt(10);
            a[i]=rand;
        }
//        int b[]=Arrays.copyOf(a,a.length*2);
//        for (int j = a.length,l=0; j <b.length ; j++,l++) {
//            b[j]=a[l];
//
//        }

        int b[]={3,3,5,5,64,56,54,64,56,4};

        sort(b,200000);


        for (int v:b)
            System.out.print(v+",");
        System.out.println();
        System.out.println(test(b));
    }

    public static  void sort(int[] a,int k){
        if(a==null||a.length<0)
            return;

        int nums[]=new int[k+1];
        for (int i = 0; i <a.length ; i++) {
            nums[a[i]]+=1;
        }
        for (int i = 1; i <=nums.length-1 ; i++) {
            nums[i]+=nums[i-1];
        }

    }

    public static boolean test(int[] a ){
        for (int i = 1; i <a.length ; i++) {
            if(a[i]<a[i-1])
                return false;
        }
        return true;
    }
}
