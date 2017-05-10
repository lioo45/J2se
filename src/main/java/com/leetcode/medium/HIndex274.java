package com.leetcode.medium;

/**
 * Created by pro on 16/11/26.
 */
public class HIndex274 {

    public static void main(String[] args) {
        int a[]={
            5,4,2,3,1
        };
        System.out.println(hIndex(a));
    }
    public static int hIndex(int[] citations) {
        if(citations.length<=0)
            return 0;
        int hindex=0;
        int index=0;
        int left=0;
        int right=citations.length-1;
        while(left<=right) {
            index=partition(left,right,citations);
            if(citations[index]>index+1){
                hindex=index+1;
                left++;
            }
            else if(citations[index]<index+1)
                right=index-1;
            else
                return index+1;

        }
        return hindex;
    }

    public static int partition(int left,int right,int[] a){
        if(left>=right)
            return left;
        int base=a[left];
        while(left<right){
            //从右边找到第一个>=base的数
            while (right>left&&a[right]<base)
                right--;
            a[left]=a[right];
            //从左边找到第一个<base
            while(right>left&&a[left]>=base)
                left++;
            a[right]=a[left];
        }
        a[left]=base;
        return left;
    }
}
