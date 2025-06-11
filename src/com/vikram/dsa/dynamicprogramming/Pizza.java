package com.vikram.dsa.dynamicprogramming;

import java.util.Arrays;

public class Pizza {

  public static void main( String[] args ) {
    Pizza  pizza = new Pizza();
    String[] arr = {"A..", "AAA", "..."};
    System.out.println(pizza.ways(arr, 3));
  }

   long MOD = 1_000_000_007L;
    public int ways(String[] pizza, int k) {
        int n = pizza.length;
        int m = pizza[0].length();
        long[][][] dp = new long[n][m][k+1];
        int[][] apples = new int[n+1][m+1];
        for (int i = n-1; i >= 0; i--) {
            for (int j = m-1; j >= 0; j--) {
                apples[i][j] = apples[i+1][j]
                 + apples[i][j+1]
                 - apples[i+1][j+1]
                 + (pizza[i].charAt(j)=='A' ? 1 : 0);
            }
        }
        for( int i = 0; i < n; i++ ) {
            for( int j = 0; j < m; j++ ) {
                Arrays.fill(dp[i][j], -1L);
            }
        }

        return (int)ways( 0, 0, k, pizza, apples, dp, n, m);
    }

    public long ways( int i, int j, int cutsLeft, String[] pizza, int[][] apples, long[][][] dp, int n, int m) {
        if (cutsLeft == 1) {
            return apples[i][j] > 0 ? 1 : 0;
        }
        if (dp[i][j][cutsLeft] != -1) {
            return dp[i][j][cutsLeft];
        }

        long ways = 0;
        for (int r = i; r < n-1; r++) {
            if (apples[i][j] - apples[r+1][j] > 0) {
                ways = (ways + ways(r+1, j, cutsLeft-1, pizza, apples, dp, n, m)) % MOD;
            }
        }

        for (int c = j; c < m-1; c++) {
            if (apples[i][j] - apples[i][c+1] > 0) {
                ways = (ways + ways(i, c+1, cutsLeft-1, pizza, apples, dp, n, m)) % MOD;
            }
        }

        return dp[i][j][cutsLeft] = ways;

    }
  
}
