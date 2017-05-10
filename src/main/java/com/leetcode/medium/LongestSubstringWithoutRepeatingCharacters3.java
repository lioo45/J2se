package com.leetcode.medium;

import javax.swing.plaf.metal.MetalIconFactory;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by pro on 17/3/5.
 */
public class LongestSubstringWithoutRepeatingCharacters3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("aab"));
        System.out.println(lengthOfLongestSubstring("cdd"));

    }

    public static int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()<=0)
            return 0;
        int max=1;
        int first=0;
        int len=0;
        Integer index=null;
        Map<Character,Integer> hash=new HashMap<Character, Integer>();
        for (int i = 0; i <s.length() ; i++) {
            char c=s.charAt(i);
            if(hash.containsKey(c)) {
                len=i-first;
                max=max>len?max:len;
                index=hash.get(c);
                first=index+1;
                for (int j = first; j <index ; j++)
                    hash.remove(j);
                hash.put(c, i);
            }
            else{
                hash.put(c, i);
            }
        }
        len=(s.length()-first);
        max=max>len?max:len;
        return max;
    }
}
