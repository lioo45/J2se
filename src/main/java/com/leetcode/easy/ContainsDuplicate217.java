package com.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pro on 16/11/19.
 */
//hash
public class ContainsDuplicate217 {
    public static void main(String[] args) {
        int a[]={1,1};
        System.out.println(containsDuplicate(a));
    }
    public static boolean containsDuplicate(int[] nums) {

        Map<Integer,Integer> hash=new HashMap<Integer, Integer>();
        for (int i = 0; i <nums.length ; i++) {
            Integer times=hash.get(nums[i]);
            if (times==null)
                hash.put(nums[i],1);
            else
                return true;
        }
        return false;
    }
}
