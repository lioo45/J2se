package com.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int length=0;
        Map<Character,Integer> map=new HashMap<Character, Integer>();
        char str[]=s.toCharArray();
        for(char c:str){
            Integer i=map.get(c);
            if(i==null)
                map.put(c,1);
            else
                map.put(c,++i);
        }
        for(Integer times:map.values()){
            if(times>=2)
                length+=times%2==0?times:times-1;
        }
        return length<s.length()?length+1:length;
    }
}
