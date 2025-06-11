package com.vikram.dsa.dynamicprogramming;

import java.util.Arrays;

public class KnightDialer {

  public static void main(String[] args) {
    KnightDialer knightDialer = new KnightDialer();
    System.out.println(knightDialer.knightDialer(3131));
  }

  private static final int[][] moves = {
      { -2, -1 }, { -2, 1 }, { 2, -1 }, { 2, 1 },
      { -1, -2 }, { -1, 2 }, { 1, -2 }, { 1, 2 }
  };
  private static final int mod = 1_000_000_007;;

  public int knightDialer(int n) {
    long[][] dp = new long[n+1][12];
    for( int i = 0; i <= n; i++ ) {
      Arrays.fill(dp[i], -1);
    }
    long totalSum = 0;
    for (int i = 0; i <= 11; i++) {
      if (i != 9 && i != 11) {
        totalSum += kinghtDialer(n - 1, i, dp);
      }
    }
    return (int) (totalSum % mod);
  }

  public long kinghtDialer(int n, int i, long[][] dp) {
    if (n <= 0) {
      return 1;
    }
    if( dp[n][i] != -1 ) {
      return dp[n][i];
    }
    long sum = 0;
    int row = i / 3;
    int col = i % 3;
    for (int[] move : moves) {
      int x = row + move[0];
      int y = col + move[1];
      int newPos = x * 3 + y;
      if (x >= 0 && x <= 3 && y >= 0 && y < 3 && newPos != 9 && newPos != 11 && newPos < 11) {
        sum = (sum + kinghtDialer(n - 1, newPos, dp)) % mod;
      }
    }
    dp[n][i] = sum;
    return dp[n][i];
  }

}
