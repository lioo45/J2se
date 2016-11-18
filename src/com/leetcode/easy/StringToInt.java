package com.leetcode.easy;

/**
 * Created by pro on 16/11/9.
 */
public class StringToInt {

    public static void main(String[] args) {
        System.out.println(myAtoi("1"));
    }

    public static int myAtoi(String str) {
        //去除首部的空格
        int result = 0;
        int flag = 1;
        char[] s = str.trim().toCharArray();
        if(s.length==0)
            return 0;
        //判断首字母的+-
        int i = 0;
        if (s[0] == '-' || s[0] == '+') {
            ++i;
            if (s[0] == '-')
                flag = -1;
        }
        if (i>=s.length)
            return 0;
        //如果第一个数字是0则过滤掉
        while(i<s.length&&s[i]=='0') ++i;
        //要考虑的一点的如果判读溢出
        while (s[i] >='0' && s[i] <= '9') {
            if (result > Integer.MAX_VALUE / 10 || result == Integer.MAX_VALUE / 10 && s[i] > '7')
                return flag==1?Integer.MAX_VALUE:Integer.MIN_VALUE;

            int v = s[i] - '0';
            result = result * 10 + v;
            ++i;
            if (i >= s.length)
                break;
        }

        return result *= flag;

    }

}
