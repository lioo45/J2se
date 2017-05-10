package interview;

import java.util.*;

/**
 * Created by pro on 17/4/17.
 */
public class P68_9_4{


    public static void main(String[] args) {
        String s="XXN";
        System.out.println(sort(s));
        System.out.println(getPermutation(s));
    }

    public  static ArrayList<String> getPermutation(String A) {
        // write code here
        char s[]=sort(A);
        ArrayList list=help(s,0);
        Collections.sort(list);
        Collections.reverse(list);
        return list;
    }

    private static ArrayList<String> help(char[] A,int index){
        ArrayList<String> list=new ArrayList<>();
        if(index==A.length){
            list.add(String.valueOf(A));
            return list;
        }
        int len=A.length;
        for (int i = index; i <len ; i++) {
            swap(A,index,i);
            char[] buff = Arrays.copyOf(A,A.length);
            list.addAll(help(A,index+1));
            A=buff;
        }
        return list;
    }

    private static void swap(char[] origin,int first,int second){
        char c=origin[second];
        origin[second]=origin[first];
        origin[first]=c;
    }

    private static char[] sort(String s){
        if(s==null||s.length()<=0)
            return null;
        int hash[]=new int[26];
        for (int i = 0; i <s.length() ; i++)
            hash[(s.charAt(i)-'A')]++;

        char[] result=new char[s.length()];
        for (int i = 0,j=25; i <s.length()&&j>=0 ;) {
            if(hash[j]>0){
                result[i]= (char) (j+'A');
                hash[j]--;
                ++i;
            }
            else
                j--;
        }
        return result;
    }


}
