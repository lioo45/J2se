package com.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by pro on 16/11/5.
 */
public class FUC387 {
    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode"));
    }
    public static int firstUniqChar(String s) {
        Map<Character,Integer> hash=new HashMap<Character, Integer>();
        char c[]=s.toCharArray();
        for(char cc:c){
            Integer i=hash.get(cc);
            if(i==null)
                hash.put(cc,1);
            else{
                ++i;
                hash.put(cc,i);
            }
        }
        for (int i = 0; i < c.length; i++) {
            if(hash.get(c[i])<2)
                return i;
        }

        return -1;
    }
}
