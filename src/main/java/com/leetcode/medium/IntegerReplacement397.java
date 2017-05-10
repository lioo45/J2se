package com.leetcode.medium;

/**
 * Created by pro on 16/12/6.
 */
public class IntegerReplacement397 {
    public static void main(String[] args) {
        System.out.println(integerReplacement(8));
        System.out.println(integerReplacement(7));
        System.out.println(integerReplacement(2147483647));
    }

    //n>0   报 内存溢出
//    public static int integerReplacement(int n) {
//        int a[]=new int[n+2];
//        a[0]=a[1]=0;
//        a[2]=1;
//        for (int i = 3; i <=n+1 ; i++) {
//            if(i%2==0) {
//                a[i] =1+ a[i / 2];
//                a[i-1]=1+Math.min(a[i-2],a[i]);
//            }
//        }
//        return a[n];
//    }
    public static int integerReplacement(int n){
        if(n==1)
            return 0;
        if(n%2==0)
            return 1+integerReplacement(n/2);
        else
            return 2+Math.min(integerReplacement(n/2),integerReplacement((n/2)+1));
    }
}
