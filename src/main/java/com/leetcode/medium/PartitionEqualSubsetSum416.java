package com.leetcode.medium;

/**
 * Created by pro on 16/11/18.
 */
//利用0-1背包 动态规划的思想..
public class PartitionEqualSubsetSum416 {
    public static void main(String[] args) {
        int a[]={1,5,11,5};
        int b[]={1,2,3,5};
        int c[]={2,2,3,5};
        System.out.println(canPartition2(b));
    }
    //据题意,子数组的和=原数组之和/2
    //且这个sum<=100*200/2=100000
    //这时,原问题就转化成,给定数组an,是否存在子数组和=sum
    //寻找最优子结构,设问题的解为:s(a[1~n],sum)
    //由子问题构造出原问题的解:(得到一个递归式子)
    // s(a[1~n],sum)=s(a[1~n-1],sum)||s(a[1~n-1],sum-an)
    //我们可以看到在递归的过程中,有大量的重叠子问题并且问题的规模在缩小
    //共有n*sum个子问题,并且s(a[1~n],1~sum)的解只依赖于下一层 s[a[1~n-1],1~sum]的解
    //所以我们可以自底向上构造出原问题的解
    //解法1 时间n*sum 空间sum
    //解法2 时间n*sum 空间n*sum  时间稍微优于解法1 不过还是处于同一数量级
    public static boolean canPartition(int[] nums) {
        if(nums.length<=0) {
            return false;
        }
        int sum=0;
        for(int i=0;i<nums.length;++i)
            sum+=nums[i];
        if(sum%2!=0) {
            return false;
        }
        sum=sum/2;
        boolean[] r1=new boolean[sum+1];
        boolean[] r2=new boolean[sum+1];
        boolean[] t;
        for (int i = 0; i <nums.length ; i++) {
            if(nums[i]<=sum)
                r2[nums[i]]=true;
            for (int j = 1; j <=sum ; j++) {
                if(r1[j]) {
                    if(j+nums[i]<=sum)
                        r2[j + nums[i]] = true;
                    r2[j]=true;
                }
            }
            t=r1;
            r1=r2;
            r2=t;
            for (int k = 0; k <=sum ; k++)
                r2[k]=false;
        }
        return r1[sum];
    }

    public static boolean canPartition2(int[] nums) {
        if(nums.length<=0) {
            return false;
        }
        int sum=0;
        for(int i=0;i<nums.length;++i)
            sum+=nums[i];
        if(sum%2!=0) {
            return false;
        }
        sum=sum/2;
        boolean r[][]=new boolean[nums.length][sum+1];
        //初始条件
        if(nums[0]<=sum)
         r[0][nums[0]]=true;
        for (int i = 1; i <nums.length ; i++) {
            if(nums[i]<=sum)
                r[i][nums[i]]=true;
            for (int j = 1; j <=sum ; j++) {
                if(r[i-1][j]) {
                    if(j+nums[i]<=sum)
                        r[i][j + nums[i]] = true;
                    r[i][j]=true;
                }
            }
        }
        return r[nums.length-1][sum];
    }
}