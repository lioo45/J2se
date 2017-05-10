package interview;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by pro on 17/4/19.
 */
public class N皇后问题 {

    public static void main(String[] args) {
//        for (int i = 0; i <15 ; i++) {
//            System.out.println(nQueens(i));
//        }

        long start=System.currentTimeMillis();
        System.out.println(nQueens(12));
        long end=System.currentTimeMillis();
        System.out.println("run time: "+(end-start));
    }
//    public static int nQueens(int n) {
//        // write code here
//        int result[]={
//                0,1,0,0,2,10,4,40,92,352,724,2680,14200,73712,365596,2279184
//        };
//        return result[n];
//    }


    public static int nQueens(int n) {
        boolean column[]=new boolean[n];
        Set<Integer> diff=new HashSet<Integer>();
        Set<Integer> sum=new HashSet<Integer>();
        int[] result={0};
        dfs(0,column,diff,sum,result);
        return result[0];
    }


    /**
     * Dfs.
     *
     * @param n      the n ,代表着当前扫描到第几行
     *
     * @param column the column, 标识对于的列是否已经放置棋子,column[i]=true,
     *               表示第i列已经放置棋子.
     *
     *               假设一个棋子的位置为(x,y),那么我们判断一个棋子(x1,y1)是否在(x,y)上的对角线的公式为:
     *               |x1-x|=|y1-y|
     *               1.两个式子都为正数,那么x1-y1=x-y
     *               2.两个式子都为负数,那么x1-y1=x-y
     *               3.第一个式子为负数,第二个为正数,x1+y1=x+y
     *               4.第一个式子为正数,第二个位负数,x1+y1=x+y
     *               综上
     * @param diff   the diff,为xi-yi的集合
     * @param sum    the sum,为xi+yi的集合
     *               那么判断一个位置(xi,yi)是否在其他棋子的对角线上就可以这么表示:
     *               !diif.contains(xi-yi)&&!sum.contains(xi+yi)
     *
     * @param result the result,返回n皇后问题对应的解的数量.如8皇后的解数量为40.
     */
    public static void dfs(int n,boolean[] column,Set diff,Set sum,int[] result){
        int result1=0;
        //j为列,表示当前处理到第n行的第j列
        for (int j = 0; j <column.length ; j++) {
            //对称优化
            if(n==0){
                if(j==column.length/2){
                    result1=result[0];
                    if(column.length%2==0) {
                        result[0] += result1;
                        return ;
                    }
                }
                if(j==((column.length/2)+1)) {
                    result[0] +=result1;
                    return ;
                }
            }

            if(!column[j]&&!diff.contains(n-j)&&!sum.contains(n+j)){
                if(n==column.length-1){
                    result[0]+=1;
                    continue;
                }
                column[j]=true;
                //(xi,yi)--->(n,j)
                diff.add(n-j);
                sum.add(n+j);
                dfs(n+1,column,diff,sum,result);
                diff.remove(n-j);
                sum.remove(n+j);
                column[j]=false;
            }
        }
    }
}
