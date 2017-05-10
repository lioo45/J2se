package pratice.算法导论第二次上机;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Stack;

/**
 * Created by pro on 17/4/18.
 */
public class LCS {

    public static void main(String[] args) {
        String	x1= "xzyzzyx";
        String  y1= "zxyyzxz";

        String x2="ALLAAQANKESSSESFISRLLAIVAD";
        String y2="KLQKKLAETEKRCTLLAAQANKENSNESFISRLLAIVAG";

        System.out.println("串:"+x1+" 与串:"+y1+"的最长公共子序列为:");
        String result=getResult(x1,y1);
        System.out.println(result+"  长度: "+result.length());
        System.out.println();
        System.out.println("串:"+x2+" 与串:"+y2+"的最长公共子序列为:");
        String result2=getResult(x2,y2);
        System.out.println(result2+"长度: "+result2.length());
//        String X="ABCBDAB";
//        String Y="BDCABA";
//        System.out.println(getResult(X,Y));
    }

    public static String getResult(String x,String y){
        if(x==null||y==null||x.length()<=0||y.length()<=0)
            return null;
        int result[][]=new int[x.length()+1][y.length()+1];
        for (int i = 0; i <result.length ; i++) {
            result[i][0]=0;
        }
        for (int i = 0; i <result[0].length ; i++) {
            result[0][i]=0;
        }

        for (int i = 1; i <result.length ; i++) {
            for (int j = 1; j <result[0].length ; j++) {
                if(x.charAt(i-1)==y.charAt(j-1))
                    result[i][j]=result[i-1][j-1]+1;
                else
                    result[i][j]=result[i-1][j]>result[i][j-1]?result[i-1][j]:result[i][j-1];
            }
        }
//        return result[result.length-1][result[0].length-1];
        StringBuilder sb=new StringBuilder();
        for(int i=x.length(),j=y.length();i>=1&&j>=1;){
            if(x.charAt(i-1)==y.charAt(j-1)) {
                sb.append(x.charAt(i-1));
                i--;j--;
            }
            else{
                if(result[i-1][j]>result[i][j-1])
                    i--;
                else
                    j--;
            }
        }
        return sb.reverse().toString();
    }


}
