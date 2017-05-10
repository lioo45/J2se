package com.leetcode.easy;

/**
 * Created by pro on 16/12/13.
 */
public class AddStrings415 {
    public static void main(String[] args) {
        System.out.println(addStrings("","99"));
    }

    public static String addStrings(String num1, String num2) {
        int newlen=(num1.length()>num2.length()?num1.length():num2.length())+1;
        char str[]=new char[newlen];
        int z=newlen-1;
        boolean carryBit=false;
        int i = num1.length()-1,j=num2.length()-1;
        for (; i>=0&&j>=0 ; i--,j--,z--) {
            int value=num1.charAt(i)+num2.charAt(j)-'0'-'0';
            if(carryBit){
                value++;
                carryBit=false;
            }
            carryBit=value>9?true:false;
            str[z]= (char) (value>9?value-10+'0':value+'0');
        }
        if(i>=0||j>=0){
            int index=i>=0?i:j;
            String s=i>=0?num1:num2;
            for (; index>=0 ; index--,z--) {
                int value=s.charAt(index)-'0';
                if(carryBit){
                    value++;
                    carryBit=false;
                }
                carryBit=value>9?true:false;
                str[z]= (char) (value>9?value-10+'0':value+'0');
            }
        }
        if(carryBit)
            str[0]='1';
        return carryBit?new String(str):new String(str).substring(1);
    }
}
