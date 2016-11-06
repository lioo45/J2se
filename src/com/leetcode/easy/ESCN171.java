package com.leetcode.easy;

/**
 * Created by pro on 16/11/4.
 */

public class ESCN171 {
    public static void main(String[] args) {
        System.out.println(titleToNumber("BA"));

    }
    public static int titleToNumber(String s) {
        int sum=0;
        char c[]=s.toCharArray();
        for(int i=0;i<c.length;++i){
            int v=c[i]-'A'+1;
            v= (int) (v*Math.pow(26,c.length-i-1));
            sum+=v;
        }
        return  sum;
    }
}
