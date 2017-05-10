package com.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pro on 17/3/1.
 */
public class WordPattern290 {
    public static void main(String[] args) {

        System.out.println(wordPattern("abba","dog cat cat dog"));
        System.out.println(wordPattern("abba","dog cat cat fish"));
        System.out.println(wordPattern("abba","dog dog dog dog"));

    }

    public static boolean wordPattern(String pattern, String str) {
        Map<String,String> map1=new HashMap<String, String>();
        Map<String,String> map2=new HashMap<String, String>();
        String strs[]=str.split(" ");
        if(strs.length!=pattern.length())
            return false;
        for (int i = 0,j=0; i <pattern.length() ; i++,j++) {
            String s=String.valueOf(pattern.charAt(i));
            String c1=map1.get(s);
            String c2=map2.get(strs[j]);
            if(c1==null&&c2==null) {
                    map1.put(s, strs[j]);
                    map2.put(strs[j], s);
            }
            else if(c1!=null&&!c1.equals(strs[j])||c2!=null&&!c2.equals(s)) {
                    return false;
            }
        }
        return true;
    }
}
