package com.leetcode.medium;

/**
 * Created by pro on 16/12/7.
 */
public class Pow50 {
    public static void main(String[] args) {
        System.out.println(myPow(2,2));
        System.out.println(myPow(2,1));
        System.out.println(myPow(2,-1));
        System.out.println(myPow(2,-2));
        System.out.println(myPow(2,-3));
        System.out.println(myPow(2,-4));
        System.out.println(myPow(2,-5));
    }

    public static double myPow(double x,int n){
        return n>0?myPow1(x,n):1/myPow1(x,n);
    }
    public static double myPow1(double x, int n) {
        if(n==0)
            return 1;
        double value;
        double result;
        if(n%2==0){
            value=myPow1(x,n/2);
            result=value*value;
        }
        else{
            value=myPow1(x,n/2);
            result=x*value*value;
        }
        return result;
    }
}
