package interview;

/**
 * Created by pro on 17/4/16.
 */
public class P69_9_8 {
    public static void main(String[] args) {
//        System.out.println(test(1,countWays(1)));
//        System.out.println(test(1,countWays(2)));
//        System.out.println(test(1,countWays(3)));
//        System.out.println(test(1,countWays(4)));
//        System.out.println(test(2,countWays(6)));
//        System.out.println(test(6,countWays(15)));
//        System.out.println(test(4,countWays(10)));
        long start=System.currentTimeMillis();
        System.out.println(countWays(100000));
        System.out.println(System.currentTimeMillis()-start);

        long start1=System.currentTimeMillis();
        System.out.println(countWaysWithDP(100000));
        System.out.println(System.currentTimeMillis()-start);
    }

    public static boolean test(int origin,int value){
        if(origin==value)
            return true;
        System.out.println("origin: "+origin+" value: "+value);
        return false;
    }

    public static int countWays(int n) {
        // write code here
        if(n<=0)
            return 0;
        int result[]=new int[n+1];
        return dp(n,0,result);
    }

    public static int countWaysWithDP(int n){
        int coin[]={1,5,10,25};
        int dp[]=new int[100001];
        dp[0]=1;
        for (int i = 0; i <coin.length ; i++) {
            for (int j = coin[i]; j <=n ; j++) {
                dp[j]=dp[j]-dp[j-coin[i]];
                if(j>19000)
                    dp[j]%=1000000007;
            }
        }
        return dp[n];
    }
    //result数组用于保存已经计算过的结果
    //result[i]的意义为,i用0个25能有多种表示
    //即,i只能用1,5,10
    public static int dp(int n,int type,int result[]){
        int sum=0;
        int num=0;
        if(type==0){
            num=25;
        }
        else if(type==1){
            num=10;
        }else if(type==2){
            num=5;
        }

        for (int i = n; i >=0 ; i-=num) {
            if(type>=2) {
                //只能用1,5时 有多少种表示
                sum += (i/5)+1;
                break;
            }
            //结果已经计算过了
            else if(result[i]>0)
                sum+=result[i];
            else
                sum+=dp(i,type+1,result);
            if(n>19000)
                sum%=1000000007;
        }
        //缓存结果
        if(type==1)
            result[n]=sum;
        return sum;
    }
}
