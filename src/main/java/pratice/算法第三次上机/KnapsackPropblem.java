package pratice.算法第三次上机;

/**
 * Created by pro on 17/4/26.
 */
public class KnapsackPropblem {

    public static void main(String[] args) {
        int[] weights = {
                50, 30, 45, 25, 5
        };
        int[] values = {
                200, 180, 225, 200, 50
        };
        System.out.println(getMaxValue(100, weights, values));
    }

    public static int getMaxValue(int capacity, int[] weight, int[] values) {
        if (weight == null || values == null || weight.length != values.length)
            return -1;
        int result[][] = new int[weight.length + 1][capacity + 1];
        for (int i = 1; i <= weight.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (weight[i - 1] > j)
                    result[i][j] = result[i - 1][j];
                else {
                    if (j - weight[i-1] >= 0) {
                        int t = result[i - 1][j - weight[i-1]] + values[i-1];
                        result[i][j] = t > result[i - 1][j] ? t : result[i - 1][j];
                    }
                }
            }
        }
        return result[weight.length][capacity];
    }
}
