package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pro on 16/11/20.
 */
public class Combinations77 {

    public static void main(String[] args) {
        List<List<Integer>> lists=combine(4,1);
        for (List<Integer> list:lists){
            for(int i:list){
                System.out.print(i+" ");
            }
            System.out.println();

        }
    }
    public static  List<List<Integer>> combine(int n, int k) {
        List<Integer> list=new ArrayList<Integer>(k);
        List<List<Integer>> lists=new ArrayList<List<Integer>>();
        if(k>n)
            return lists;
        formatList(n,k,lists,list);
        return lists;
    }

    public static void formatList(int n, int k, List<List<Integer>> lists, List<Integer> list) {
        if(n<0)
            return ;
        if(k==0&&n>=0){
            List<Integer> copy=new ArrayList<Integer>(list);
            lists.add(copy);
            return ;
        }
        for (int i = n; i >0 ; --i) {
            list.add(i);
            formatList(i-1,k-1,lists,list);
            list.remove(new Integer(i));
        }
    }
}
