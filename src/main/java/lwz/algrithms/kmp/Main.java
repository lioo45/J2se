package lwz.algrithms.kmp;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.sql.DriverManager;

/**
 * Created by pro on 17/3/28.
 */
public class Main {
    public static void main(String[] args) {
//        String s="123123aa1231231b";
        String s="ababaca";
        String s1="cde";
        System.out.println(match(s,s1));

    }

    public static  boolean match(String s,String s1){
        char[] c=s.toCharArray();
        char[] c1=s1.toCharArray();
        int[] indexArray=buildIndexArray(s);
        int index=0;
        for (int i = 0; i <c.length ;) {
            if(index<0) {
                ++i;
                continue;
            }
            if(c[i]==c1[index]) {
                ++i;
                ++index;
                if(index>=c1.length)
                    return true;
            }
            else{
                index=indexArray[index];
            }
        }
        return false;
    }


    public static int[] buildIndexArray(String s){
        if(s==null||"".equals(s))
            return null;

        int[] indexArray=new int[s.length()];
        char c[]=s.toCharArray();
        indexArray[0]=-1;
        int index=indexArray[0];
        int len=s.length();
        int i=1;
        while (i<len){
            if(index<0){
                indexArray[i]=0;
                index=indexArray[i];
                ++i;
                continue;
            }
            if(index>=0&&c[index]==c[i-1]){
                if(c[i]!=c[index]) {
                    indexArray[i] =index + 1;
                    index=indexArray[i];
                    ++i;
                    continue;
                }
            }
            index=indexArray[index];


        }
        return indexArray;
    }
}
