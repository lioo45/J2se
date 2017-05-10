package com.leetcode.easy;

/**
 * Created by pro on 17/3/2.
 */
public class CountandSay38 {
    public static void main(String[] args) {
        for (int i = 1; i <10 ; i++) {
            System.out.println(countAndSay(i));
        }
    }
    public static String countAndSay(int n) {
        StringBuilder sb;
        String s="1";
        for (int q = 1; q <n ; q++) {
            sb=new StringBuilder();
            for (int i = 0; i < s.length();) {
                int num = 0;
                char first = s.charAt(i);
                while (i<s.length()&&s.charAt(i) == first) {
                    i++;
                    ++num;
                }
                char second = (char) (num + '0');
                sb.append(second);
                sb.append(first);
            }
            s=sb.toString();
        }
        return s;
    }
}
