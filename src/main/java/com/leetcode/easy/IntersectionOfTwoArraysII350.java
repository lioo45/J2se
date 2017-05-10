package com.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pro on 16/11/19.
 * Given two arrays, write a function to compute their intersection.

 Example:
 Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

 Note:
 Each element in the result should appear as many times as it shows in both arrays.
 The result can be in any order.
 Follow up:
 What if the given array is already sorted? How would you optimize your algorithm?
 What if nums1's size is small compared to nums2's size? Which algorithm is better?
 What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

 solutions:
    one: 在左右两个数组各自设置一个指针,那么可在O(n+m)完成
    two:直接暴力 n*m就好
    finally:hashmap contains every element and it's times of appearance
 */
public class IntersectionOfTwoArraysII350 {
    public static void main(String[] args) {
        int a[]={1,2,2,3,4,5};
        int b[]={1,2,2,3,4};
        for(int i:intersect(a,b))
          System.out.println(i);
    }
    public static int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length<=0||nums2.length<=0)
            return new int[0];
        Map<Integer,Integer> hash=new HashMap<Integer, Integer>();
        for (int i = 0; i <nums1.length ; i++) {
            Integer times=hash.get(nums1[i]);
            if (times==null)
                hash.put(nums1[i],1);
            else
                hash.put(nums1[i],++times);
        }
        List<Integer> list=new ArrayList<Integer>();
        for (int i = 0; i <nums2.length ; i++) {
            Integer times=hash.get(nums2[i]);
            if(times!=null&&times>0){
                list.add(nums2[i]);
                times--;
                hash.put(nums2[i],times);
            }

        }
        int r[]=new int[list.size()];
        int j=0;
        for(Integer i:list)
            r[j++]=i;
        return r;
    }
}
