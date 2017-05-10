package com.leetcode.medium;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

/**
 * Created by pro on 17/3/10.
 */
public class LongestIncreasingSubsequence300 {
    public static void main(String[] args) {
        int a[]={10, 9, 2, 5, 3, 7, 101, 18};
        int b[]={1,2,3,4,5,6,7,8,9};
        int c[]={-1,4,234,345,3,5,6,54,7,4,76};
        System.out.println(lengthOfLIS(a));
        System.out.println(lengthOfLIS(b));
        System.out.println(lengthOfLIS(c));

    }

    public static int lengthOfLIS(int[] nums) {
        if(nums==null||nums.length<1)
            return 0;
        int max=nums[0],len=1,secondMax=Integer.MAX_VALUE;
        int bufferLen=0,bufferMax=Integer.MIN_VALUE,bufferSecondMax=Integer.MAX_VALUE;
        for (int i = 1; i <nums.length ; i++) {
            if(nums[i]>max){
                secondMax=max;
                max=nums[i];
                len++;
            }
            else{
                if(nums[i]>bufferMax){
                    bufferSecondMax=bufferMax;
                    bufferMax=nums[i];
                    bufferLen++;
                    if(bufferLen>len){
                        len=bufferLen;
                        max=bufferMax;
                        secondMax=bufferSecondMax;
                        bufferLen=0;
                        bufferMax=Integer.MIN_VALUE;
                        bufferSecondMax= Integer.MAX_VALUE;
                    }
                }
                else{
                    if(nums[i]>bufferSecondMax)
                        bufferMax=nums[i];
                }
                if(nums[i]>secondMax)
                    max=nums[i];
            }

        }
        return len;
    }
}
