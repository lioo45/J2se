package com.leetcode.easy;

/**
 * Created by pro on 16/11/16.
 */
public class CountPrime {
    public static void main(String[] args) {
        System.out.println(countPrimes(10000));
    }
    public static int countPrimes(int n){
        if(n<=2)
            return 0;
        boolean r[]=new boolean[n];
        for (int i = 2; i <n ; i++)
            r[i]=true;

        for(int i=4;i<n;i+=2)
            r[i]=false;

        for(int i=3;i*i<n;i+=2){
            for(int j=i;j*i<n;j+=2)
                r[j*i]=false;
        }
        int count=0;
        for (int i = 1; i <n ; i++) {
            if(r[i])
               count++;
        }
        return count;
    }
}
