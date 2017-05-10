package com.leetcode.medium;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.SimpleRestriction;
import com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets;

/**
 * Created by pro on 16/12/14.
 */
public class MultiplyStrings43 {

    public static void main(String[] args) {
        System.out.println(multiply("25","25"));
        System.out.println(multiply("10","10"));
        System.out.println(multiply("9","9"));
        System.out.println(multiply("1111","111"));
        System.out.println(multiply("2","2"));
        System.out.println(multiply("1324","0"));


    }
    public static String multiply(String num1, String num2) {
        //取num2的每一个字符去*num1,等到的数移位后与上一个数相加
        int i=num1.length()-1;
        int j=num2.length()-1;
        int sumLen=num1.length()*num2.length()+1;
        char[] sum=new char[sumLen];
        char[] buffer=new char[num1.length()>num2.length()?num1.length():num2.length()];
        String result=null;
        for (int k = 0; k <buffer.length ; k++)
            buffer[k]='0';
        for(int m=0;j>=0;--j,++m){
            int carryBit=0;
            int c2=num2.charAt(j)-'0';
            int len=num1.length()+1;
            int z=len-1;
            char str[]=new char[len];
            for(int k=i;k>=0;k--,--z){
                int c1=num1.charAt(k)-'0';
                int value=c1*c2+carryBit;
                carryBit=value/10;
                str[z]= (char) (value%10+'0');
            }
            str[z]=carryBit!=0? (char) (carryBit+'0'):'0';
            buffer=addStrings(str,buffer).toCharArray();
            sum[sumLen-1-m]=buffer[buffer.length-1];
            buffer=String.valueOf(buffer).substring(0,buffer.length-1).toCharArray();
            if(j==0){
                int k=sumLen-m-2;
                int p=buffer.length-1;
                for (; p>=0 ; k--,p--)
                    sum[k]=buffer[p];
                result=new String(String.valueOf(sum).substring(k+1));
            }
        }
        result=result.substring(findFirstNZ(result));
        return result.length()>0?result:"0";
    }


    private static int findFirstNZ(String s) {
        int i = 0;
        for (; i <s.length() ; i++) {
            if(s.charAt(i)!='0')
                break;
        }
        return i;
    }

    public static String addStrings(char[] num1, char[] num2) {
        int newlen=(num1.length>num2.length?num1.length:num2.length)+1;
        char str[]=new char[newlen];
        int z=newlen-1;
        boolean carryBit=false;
        int i = num1.length-1,j=num2.length-1;
        for (; i>=0&&j>=0 ; i--,j--,z--) {
            int value=num1[i]+num2[j]-'0'-'0';
            if(carryBit){
                value++;
                carryBit=false;
            }
            carryBit=value>9?true:false;
            str[z]= (char) (value>9?value-10+'0':value+'0');
        }
        if(i>=0||j>=0){
            int index=i>=0?i:j;
            char[] s=i>=0?num1:num2;
            for (; index>=0 ; index--,z--) {
                int value=s[index]-'0';
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
