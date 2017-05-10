package huawei;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main1 {
    static Map<Integer,Integer> map=new HashMap<Integer, Integer>();
    public static void main(String[] args) {
        int testNum=1000;
        int[] b=new int[testNum];

        for (int i = testNum-1,j=0; i>=0 ; i--,j++) {
            b[j]=i;
        }
        for (int j = 0; j <b.length ; j++) {
            System.out.print(b[j] + ",");
            map.put(b[j],j);
        }

        for(int j:b)
            System.out.print(j+",");
        new Main1().sort(b,b.length);

        System.out.println(test(b));

//        int a[]={0,4,5,6,7,8,9};
//        Main1 m=new Main1();
//        m.swap(a,0,0);
//        for(int v:a)
//            System.out.println(v);


    }

    private static Random random=new Random();
    /**
     * 交换数组里n和0的位置
     *
     * @param array
     *            数组
     * @param len
     *            数组长度
     * @param n
     *            和0交换的数
     */
    // 不要修改以下函数内容
    public void swapWithZero(int[] array, int len, int n) {
        int zeroIndex=map.get(0);
        int targetIndex=map.get(n);
        map.put(0,targetIndex);
        map.put(n,zeroIndex);
        int t=array[zeroIndex];
        array[zeroIndex]=n;
        array[targetIndex]=t;
    }
    // 不要修改以上函数内容


    /**
     * 通过调用swapWithZero方法来排
     *
     * @param array
     *            存储有[0,n)的数组
     * @param len
     *            数组长度
     */
    public void sort(int[] array, int len) {
        // 完成这个函数
        for(int i=0;i<array.length;++i){
            int index=array[i];
            swap(array,array[i],array[index]);
        }
    }

    private void swap(int[] array,int value1,int value2){
        if(value1==0||value2==0){
            if(value1==0)
                swapWithZero(array,value2,0);
            if(value2==0)
                swapWithZero(array,value1,0);
        }else {
            swapWithZero(array, array.length, value1);
            swapWithZero(array, array.length, value2);
            swapWithZero(array, array.length, value1);
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