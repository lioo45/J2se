package com.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pro on 16/11/8.
 */
public class ValidAnagram242 {
    public static void main(String[] args) {
        System.out.println(isAnagram("ab","a"));
    }
    public static boolean isAnagram(String s, String t) {
        Map<Character,Integer> hash=new HashMap<Character, Integer>();
        char ss[]=s.toCharArray();
        for (int i1 = 0; i1 < ss.length; i1++) {
            char c = ss[i1];
            Integer i = hash.get(c);
            if (i == null)
                hash.put(c, 1);
            else {
                ++i;
                hash.put(c, i);
            }
        }
        char[] tt=t.toCharArray();
        for (int i = 0; i <tt.length; i++) {
            Integer v=hash.get(tt[i]);
            if(v==null)
                return false;
            else{
                v--;
                if(v!=0)
                    hash.put(tt[i],v);
                else
                    hash.remove(tt[i]);
            }
        }
        if(hash.size()==0)
            return true;
        return false;
    }


}
