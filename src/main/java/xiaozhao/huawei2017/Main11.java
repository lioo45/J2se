package xiaozhao.huawei2017;

import java.util.Scanner;

/**
 * Created by pro on 17/3/24.
 */
public class Main11 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String s=sc.nextLine();
            String s1[]=s.split(",");
            int a=new Integer(s1[0]);
            int b=new Integer(s1[1]);
            System.out.println(reverseAdd(a,b));
        }
//        System.out.println(reverseAdd(10000,70000));
//        System.out.println(reverseAdd(-1,73242));
//        System.out.println(reverseAdd(12345,23456));
//        System.out.println(reverseAdd(123,456));
//        System.out.println(reverseAdd(1,23));
//        System.out.println(reverseAdd(1230,3210));


    }

    public static int reverseAdd(int a,int b) {
        if(a<1||a>70000||b<1||b>70000)
            return -1;
        int a1=0;
        while(a>0){
            a1*=10;
            a1+=(a%10);
            a/=10;
        }
        int b1=0;
        while(b>0){
            b1*=10;
            b1+=b%10;
            b/=10;
        }
        return a1+b1;
//        int s1 = new Integer(reverse(String.valueOf(a)));
//        int s2 = new Integer(reverse(String.valueOf(b)));
//        return s1+s2;
    }
    public static String reverse(String s){
        char c[]=s.toCharArray();
        int left=0;
        int right=s.length()-1;
        while(left<right){
            char t=c[left];
            c[left]=c[right];
            c[right]=t;
            left++;
            right--;
        }
        return new String(c);
    }
}
