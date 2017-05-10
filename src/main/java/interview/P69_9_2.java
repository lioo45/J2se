package interview;

import java.util.concurrent.ForkJoinPool;

/**
 * Created by pro on 17/4/15.
 */
public class P69_9_2 {

    public static void main(String[] args) {
//        System.out.println(countWays(2,2));
        int a[][]={
                {1,0,1,1},
                {0,1,1,1},
                {1,1,1,1},
                {1,1,1,1},
        };
        System.out.println(countWaysTwo(4,4,a));

//        System.out.println(countWays(4,4));
    }

    public static int countWays(int x, int y) {
        // write code here
        int result[][]=new int[x][y];
        for (int i = 0; i <x ; i++) {
            result[i][y-1]=1;
        }
        for (int i = 0; i <y ; i++) {
            result[x-1][i]=1;
        }
        for (int i = x-2; i >=0 ; i--) {
            for (int j = y-2; j >=0 ; j--) {
                result[i][j]=result[i+1][j]+result[i][j+1];
            }
        }
        return result[0][0];
    }

    public static int countWaysTwo(int x, int y,int[][] map) {
        // write code here


        int result[][]=new int[x][y];
        //根据障碍设置结果值
        for (int i = 0; i <x ; i++) {
            for (int j = 0; j <y ; j++) {
                if(map[i][j]!=1)
                    result[i][j]=-1;
            }
        }

        for (int i = x-1; i >=0 ; i--) {
            if(result[i][y-1]!=-1) {
                result[i][y - 1] = 1;
            }
            else{
                while(--i>=0){
                    result[i][y-1]=-1;
                }
            }
        }
        for (int i = y-1; i >=0 ; i--) {
            if(result[x-1][i]!=-1)
                result[x-1][i]=1;
            else {
                while(--i>=0){
                    result[x-1][i]=-1;
                }
            }
        }

        for (int i = x-2; i >=0 ; i--) {
            for (int j = y-2; j >=0 ; j--) {
                if(map[i][j]==1) {
                    int right = result[i][j + 1] > 0 ? result[i][j + 1] : 0;
                    int down = result[i + 1][j] > 0 ? result[i + 1][j] : 0;
                    result[i][j] = (right + down) % 1000000007;
                }
            }
        }
        return result[0][0]<0?0:result[0][0];
    }
}
