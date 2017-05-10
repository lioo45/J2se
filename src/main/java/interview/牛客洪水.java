package interview;

/**
 * Created by pro on 17/4/19.
 */
public class 牛客洪水 {

    public static void main(String[] args) {

    }

    public static int floodFill(int[][] map, int n, int m) {
        // write code here
        if(map==null)
            return -1;
        int result[][]=new int[n][m];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <m ; j++) {
                result[i][j]=Integer.MAX_VALUE;
            }
        }
        dp(map,result,n-1,m-1,0);
        return result[0][0];
    }

    public static void dp(int[][] map,int[][] result,int currentX,int currentY,int currentStep){
        if(currentX<0||currentY<0)
            return ;
        if(map[currentX][currentY]!=1) {
            if (currentStep < result[currentX][currentY]) {
                result[currentX][currentY] = currentStep;
                ++currentStep;
                dp(map, result, currentX - 1, currentY, currentStep);
                dp(map, result, currentX, currentY - 1, currentStep);
            }
        }
    }
}
