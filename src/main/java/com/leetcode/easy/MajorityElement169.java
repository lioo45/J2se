package com.leetcode.easy;

public class MajorityElement169 {
    public static void main(String[] args) {
        int[] a={6,4,4,4,6};
        System.out.println(majorityElement(a));

    }
    //进行一趟快排即可
    public static int majorityElement(int[] nums) {
        int buffer=nums[0];
        int left=0,right=nums.length-1;
        int times=1;
        while(left<right){
            while(nums[right]>buffer&&left<right) right--;
            if(left<right) {
                if(nums[right]==buffer)
                    times++;
                nums[left] = nums[right];
                left++;

            }
            while(nums[left]<=buffer&&left<right){
                if(buffer==nums[left])
                    times++;
                left++;
            }
            if(left<right) {
                nums[right] = nums[left];
                right--;
            }
        }
        nums[left]=buffer;
        if(times>=nums.length/2+1)
            return buffer;
        return nums[nums.length/2];
    }
}
