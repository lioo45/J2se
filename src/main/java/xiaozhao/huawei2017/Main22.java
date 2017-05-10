package xiaozhao.huawei2017;


import java.util.Scanner;

/**
 * Created by pro on 17/3/24.
 */
public class Main22 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String s=sc.nextLine();
            char a[]="123456".toCharArray();
            char c[]=s.toCharArray();
            for (int i = 0; i <c.length ; i++)
                switch (c[i]) {
                    case 'L':
                        L(a);
                     break;
                    case 'R':
                        R(a);
                        break;
                    case 'F':
                        F(a);
                        break;
                    case 'B':
                        B(a);
                        break;
                    case 'A':
                        A(a);
                        break;
                    case 'C':
                        C(a);
                        break;
                }
            System.out.println(new String(a));
        }

    }
    //123456 563421
    public static String L(char[] s){
        char first=s[0];
        char second=s[1];
        s[0]=s[4];
        s[1]=s[5];
        s[4]=second;
        s[5]=first;
        return new String(s);
    }

    //123456 653412
    public static String R(char[] s){
        char first=s[0];
        char second=s[1];
        s[0]=s[5];
        s[1]=s[4];
        s[4]=first;
        s[5]=second;
        return new String(s);

    }

    //123456 125643
    public static String F(char[] s){
        char c3=s[2];
        char c4=s[3];
        s[2]=s[4];
        s[3]=s[5];
        s[4]=c4;
        s[5]=c3;
        return new String(s);
    }

    //123456 126534
    public static String B(char[] s){
        char c3=s[2];
        char c4=s[3];
        s[2]=s[5];
        s[3]=s[4];
        s[4]=c3;
        s[5]=c4;
        return new String(s);
    }

    //123456 431256
    public static String A(char[] s){
        char c1=s[0];
        char c2=s[1];
        s[0]=s[3];
        s[1]=s[2];
        s[2]=c1;
        s[3]=c2;
        return new String(s);
    }
    //123456 342156
    public static String C(char[] s){
        char c1=s[0];
        char c2=s[1];
        s[0]=s[2];
        s[1]=s[3];
        s[2]=c2;
        s[3]=c1;
        return new String(s);
    }


}
