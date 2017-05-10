package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pro on 16/11/19.
 */
public class BinaryWatch401 {
    static int r=0;

    public static void main(String[] args) {
        List<String> list=readBinaryWatch(0);
        for(String s:list)
            System.out.println(s);
    }

    public static List<String> readBinaryWatch(int num) {
        List<String> list=new ArrayList<String>();
        mark(0,num,list);
        return list;
    }

    public static void mark(int v,int num,List list){
        if(num==0){
            int rc=r;
            int hour=rc%16;
            int minute=rc>>4;
            if(hour<12&&minute<60){
                String s=String.valueOf(hour)+":";
                if(minute<10)
                    s+="0"+String.valueOf(minute);
                else
                    s+=String.valueOf(minute);
                list.add(s);
            }
            return ;
        }
        for (int i = v; i <10 ; i++) {
            r+=1<<i;
            mark(i+1,num-1,list);
            r-=1<<i;
        }
    }

}
