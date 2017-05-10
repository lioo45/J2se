package xiaozhao.qunaer;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by pro on 17/4/1.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String s=sc.nextLine();
            char ss[]=s.toCharArray();
            int y=s.length()-1;
            int origin=0;
            if(ss.length<=6) {
                for (int i = 0; i < s.length(); i++) {
                    int value = ss[i] - 'a';
                    origin += value * Math.pow(26, y);
                    y--;
                }
                System.out.println(origin);
            }else{
                BigInteger bigInteger=new BigInteger(String.valueOf(0));
                for (int i = 0; i < s.length(); i++) {
                    int value = ss[i] - 'a';
                    BigInteger b=new BigInteger(String.valueOf(value));
                    BigInteger pow26=new BigInteger("26");
                    pow26=pow26.pow(y);
                    b=b.multiply(pow26);
                    bigInteger=bigInteger.add(b);
                    y--;
                }
                System.out.println(bigInteger);
            }
        }
    }

}
