package com.leetcode.medium;

/**
 * Created by pro on 16/11/10.
 */
public class UniqueBinarySearchTrees96 {
    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }

    public static int numTrees(int num) {
        if (num == 0)
            return 0;
        int r[] = new int[num + 1];
        r[0] = 1;
        r[1] = 1;
        for (int i = 2; i <= num; i++) {
            for (int j = i - 1; j >= 0; --j)
                    r[i] += r[j] * r[i - j - 1];

        }
        return r[num];

    }
}
