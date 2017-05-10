package interview;

/**
 * Created by pro on 17/1/29.
 */
public class P47_1_6 {
    public static void main(String[] args) {
        int[][] n= {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        for (int i = 0; i <n.length ; i++) {
            for (int j = 0; j <n.length ; j++) {
                System.out.print(n[i][j]+"  ");
            }
            System.out.println();
        }
        spinNintyDegree(n);
        System.out.println("-----------");
        for (int i = 0; i <n.length ; i++) {
            for (int j = 0; j <n.length ; j++) {
                System.out.print(n[i][j]+"  ");
            }
            System.out.println();
        }
    }

    public static void spinNintyDegree(int[][] n) {
        if (n.length <= 1)
            return;
        int num=n.length%2==0?n.length/2:n.length/2+1;
        for(int k=0;k<num;++k) {
            for (int i = k; i < n.length - 1-k; i++) {
                int t = n[k][i];
                n[k][i] = n[n.length - 1 - i][k];
                n[n.length - 1 - i][k] = n[n.length - 1-k][n.length - 1 - i];
                n[n.length - 1-k][n.length - 1 - i] = n[i][n.length - 1-k];
                n[i][n.length - 1-k] = t;
            }
        }
    }
}
