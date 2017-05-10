package interview;

import java.math.BigInteger;

/**
 * Created by pro on 17/4/15.
 */
public class P68_9_1 {

    public static void main(String[] args) {
        System.out.println(countWays(99999));
    }
    public static int countWays(int n) {
        // write code here
        if(n<=0)
            return 0;
        if(n<=2)
            return n;
        if(n==3)
            return 4;
//        int len=n>110?n+1:110;
        int result[]=new int[n+1];
        result[0]=0;
        result[1]=1;
        result[2]=2;
        result[3]=4;
//        if(n>110) {
        for (int i = 4; i <= n; i++) {
            result[i] = ((result[i - 1] + result[i - 2])%1000000007 + result[i - 3])%1000000007;
        }
        return result[n];
//        }
//
//        if(n<=110) {
//            return result[n]%1000000007;
//        }
//        else{
//            int num=111;
//            BigInteger bResult=null;
//            final BigInteger bf=new BigInteger("1000000007");
//            BigInteger b1 = new BigInteger(String.valueOf(result[108]));
//            BigInteger b2 = new BigInteger(String.valueOf(result[109]));
//            BigInteger b3 = new BigInteger(String.valueOf(result[110]));
//            while(num<=n) {
//                bResult=b1.add(b2).add(b3);
//                bResult=bResult.mod(bf);
//                ++num;
//                b1=b2;
//                b2=b3;
//                b3=bResult;
//            }
//
//            return new Integer(bResult.toString());
//        }
    }
}
