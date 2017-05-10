package interview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pro on 17/4/17.
 */
public class P68_9_6 {
    public static void main(String[] args) {
        int a[]={123,456,789};

        System.out.println(getSubsets(a,3));
    }

    public static  ArrayList<ArrayList<Integer>> getSubsets(int[] A, int n) {
        // write code here
        if(A==null||A.length<=0)
            return null;
        ArrayList<ArrayList<Integer>> subset=new ArrayList<ArrayList<Integer>>();

        ArrayList<ArrayList<Integer>> nowSet=null;
        for (int i = 0; i <n ; i++) {
            nowSet=new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> aList : subset) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(A[i]);
                list.addAll(aList);
                nowSet.add(list);
            }
            ArrayList<Integer> list=new ArrayList<>();
            list.add(A[i]);
            nowSet.add(list);
            nowSet.addAll(subset);
            subset = nowSet;
        }
        return nowSet;
    }



}
