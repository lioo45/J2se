package pratice.算法导论第二次上机;


/**
 * Created by pro on 17/4/18.
 */
public class LongestCommonSubstring {

    public static void main(String[] args) {
        String x1= "xzyzzyx";
        String y1="zxyyzxz";

        String x2="MAEEEVAKLEKHLMLLRQEYVKLQKKLAETEKRCALLAAQANKESSSESFISRLLAIVAD";
        String y2="MAEEEVAKLEKHLMLLRQEYVKLQKKLAETEKRCTLLAAQANKENSNESFISRLLAIVAG";

        System.out.println("串:"+x1+" 与串:"+y1+"的最长公共子串为:");
        String result=getStr(x1,y1);
        System.out.println(result+"  长度: "+result.length());
        System.out.println();

        System.out.println("串:"+x2+" 与串:"+y2+"的最长公共子串为:");
        String result2=getStr(x2,y2);
        System.out.println(result2+"  长度: "+result2.length());

    }

    public static String getStr(String x,String y){
        if(x==null||y==null||x.length()<=0||y.length()<=0)
            return null;
        int dp[][]=new int[x.length()+1][y.length()+1];
        //初始化
        for (int i = 0; i <dp.length ; i++) {
            dp[i][0]=0;
        }
        for (int i = 0; i <dp[0].length ; i++) {
            dp[0][i]=0;
        }
        int xIndex = -1;
        int max=0;
        for (int i = 1; i <= x.length(); i++) {
            for (int j = 1; j <= y.length(); j++) {
                if (x.charAt(i-1) == y.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j]>max){
                        max=dp[i][j];
                        xIndex=i-1;
                    }
                }
            }
        }
        if(max>0)
            return x.substring((xIndex+1-max),max);
        else
            return null;
    }
}
