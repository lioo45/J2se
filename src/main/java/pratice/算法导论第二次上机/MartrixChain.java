package pratice.算法导论第二次上机;

/**
 * Created by pro on 17/4/18.
 */
public class MartrixChain {
    public static void main(String[] args) {
        int a[][]={
                {3, 5, 2, 1,10},
                {2, 7, 3, 6, 10},
                {10, 3, 15, 12, 7, 2},
                {7, 2, 4, 15, 20, 5}
        };
        for (int i = 0; i <a.length ; i++) {
            System.out.println();
            System.out.print("输入为: ");
            for (int j = 0; j <a[i].length ; j++) {
                System.out.print(a[i][j]+",");
            }
            System.out.print(" 的最小相乘次数是:");
            System.out.println(getResult(a[i]));
        }

//        int b[]={30,35,15,5,10,20,25};
//        System.out.println(getResult(b));
    }

    public static int getResult(int[] a){
        if(a==null||a.length<=0)
            return -1;
        //初始化result
        int result[][]=new int[a.length-1][a.length-1];
        for (int i = 0; i <result.length ; i++) {
            for (int j = 0; j <result.length ; j++) {
                result[i][j]=Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < result.length; i++) {
            result[i][i]=0;
        }
        for (int j = 1; j <result.length ; j++) {
            int jClone=j;
            for (int i =0; j < result.length&&i<result.length; i++,++j) {
                for (int k = i; k <j ; k++) {
                    int buffer=result[i][k]+result[k+1][j]+a[i]*a[k+1]*a[j+1];
                    if(buffer<result[i][j])
                        result[i][j]=buffer;
                }

            }
            j=jClone;
        }
        return result[0][result.length-1];
    }
}
