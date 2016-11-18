package com.leetcode.hard;

/**
 * Created by pro on 16/11/10.
 */
public class DistinctSequences115 {
    public static void main(String[] args) {
        System.out.println(numDistinct("aabb", "ab"));
    }

    public static int numDistinct(String s, String t) {
        if (t.length() > s.length())
            return 0;
        if (t.isEmpty())
            return s.isEmpty() ? 1 : s.length();

        int result[][] = new int[s.length()][t.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == t.charAt(t.length() - 1)) {
                if (i == s.length() - 1)
                    result[i][t.length() - 1] = 1;
                else
                    result[i][t.length() - 1] = result[i + 1][t.length() - 1] + 1;
            } else {
                if (i == s.length() - 1)
                    result[i][t.length() - 1] = 0;
                else
                    result[i][t.length() - 1] = result[i + 1][t.length() - 1];
            }
        }
        for (int i = t.length() - 2; i >= 0; --i) {
            for (int j = s.length() - t.length() + i; j >= 0; j--) {
                if (s.charAt(j) == t.charAt(i))
                    result[j][i] = result[j + 1][i] + result[j + 1][i + 1];
                else
                    result[j][i] = result[j + 1][i];
            }
        }
        return result[0][0];
    }
}
