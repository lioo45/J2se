package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
	public static void main(String[] args) {
		System.out.println(fizzBuzz(15));
	}
	public static  List<String> fizzBuzz(int n) {
        List<String> list=new ArrayList<String>();
        
        for(int i=1;i<=n;++i){
        	String s="";
        	if(i%3==0)
        		s+="Fizz";
        	if(i%5==0)
        		s+="Buzz";
        	if(s.isEmpty())
        		s=String.valueOf(i);
        	list.add(s);
        }
        return list;
    }
}
