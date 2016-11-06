package com.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTowArray {
	public static void main(String[] args) {
		int a[]={};
		int b[]={};
		for(int i:intersection(a, b))
			System.out.println(i);
	}
	public static int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set=new HashSet<Integer>();
		for(int i:nums1)
			set.add(i);
		Set<Integer> rs=new HashSet<Integer>();
		for(int i:nums2){
			if(set.contains(i))
				rs.add(i);
		}
		int result[]=new int[rs.size()];
		int j=0;
		for(Integer i:rs){
			result[j++]=i;
		}
		return result;
    }
}
