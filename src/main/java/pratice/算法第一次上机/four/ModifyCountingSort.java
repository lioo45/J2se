package pratice.算法第一次上机.four;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by pro on 17/3/22.
 */
public class ModifyCountingSort {
    public static void main(String[] args) {
        int testNum=100;
        int i;
        Random random=new Random();
        int a[]=new int[testNum];
        for(i=testNum-1;i>=0;--i){
            int rand=random.nextInt(100000)+random.nextInt(1000)+random.nextInt(100)+random.nextInt(10);
            a[i]=rand;
        }
        int b[]=Arrays.copyOf(a,a.length*2);
        for (int j = a.length,l=0; j <b.length ; j++,l++) {
            b[j]=a[l];
        }

//        int b[]={3,5,3,5,4,6,4,6,5,4};

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
        for (int i = 0; i <a.length ; i++)
            nums[a[i]]+=1;

        for (int i = 1; i <=k ; i++)
            nums[i]+=nums[i-1];


        for (int i = a.length-1; i >=0; i--) {
            //每一次swap都能把一个数交换到正确的位置 并且会--nums数组里对应下标的值 作为相同元素在数组中的位置
            //如果i>nums[a[i]]-1说明这个数已经在正确的位置了
            while(i<=nums[a[i]]-1&&i>=0) {
                int index2 = nums[a[i]] - 1;
                nums[a[i]]--;
                swap(a, i, index2);
            }
        }

    }

    public static void swap(int[] a,int index1,int index2 ){
        int t=a[index1];
        a[index1]=a[index2];
        a[index2]=t;
    }



    public static boolean test(int[] a ){
        for (int i = 1; i <a.length ; i++) {
            if(a[i]<a[i-1])
                return false;
        }
        return true;
    }
}
