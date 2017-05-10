package pratice.算法第一次上机.three;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by pro on 17/3/22.
 */
public class QuickSort {

    private static Random random=new Random();

    public static void main(String[] args) {
        int testNum=100;
        int i;
        int a[]=new int[testNum];
        for(i=testNum-1;i>=0;--i){
            int rand=random.nextInt(10000000)+random.nextInt(100000)+random.nextInt(1000)+random.nextInt(100);
            a[i]=rand;
        }

        int[] b= Arrays.copyOf(a,a.length);
        // 普通快排
        QuickSort.sort(b);

        for(int j:b)
            System.out.print(j+",");

        System.out.println();
        //test()这个方法测试一个数组是否有序
        System.out.println(test(b));

        System.out.println("---------------------------");
        int[] c=Arrays.copyOf(a,a.length);
        //随机快排
        QuickSort.sortWithRand(c);
        for(int j:c)
            System.out.print(j+",");
        System.out.println();
        //test()这个方法测试一个数组是否有序
        System.out.println(test(c));


    }

    public static void sort(int[] a){
        sortCore(a,0,a.length-1,false);
    }

    public static void sortWithRand(int[] a){

        sortCore(a,0,a.length-1,true);
    }

    private static void sortCore(int[] a,int left,int right,boolean randomized){
        if(a==null||a.length<=0||left>=right)
            return ;
        int index=patition(a,left,right,randomized);
        sortCore(a,left,index-1,randomized);
        sortCore(a,index+1,right,randomized);
    }

    //划分
    private static int patition(int[] a,int left,int right,boolean randomized){
        if(a==null||a.length<=0)
            return -1;
        randomized(randomized,a,left,right);
        int value=a[left];
        while(left<right){
            //把右边小于value的搬到左边
            while(a[right]>value&&left<right)
                right--;
            if(left<right) {
                a[left] = a[right];
                left++;
            }
            //把左边大于value的搬到右边
            while(a[left]<value&&left<right)
                left++;
            if(left<right) {
                a[right] = a[left];
                right--;
            }
        }
        a[left]=value;
        return left;
    }

    private static void randomized(boolean randomized, int[] a, int left, int right) {
        if(!randomized)
            return ;
        int rand= random.nextInt(right-left);
        int newLeft=left+rand;

        int t=a[left];
        a[left]=a[newLeft];
        a[newLeft]=t;

    }

    public static boolean test(int[] a ){
        for (int i = 1; i <a.length ; i++) {
            if(a[i]<a[i-1])
                return false;
        }
        return true;
    }

}
