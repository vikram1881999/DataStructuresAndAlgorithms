package com.vikram.dsa.dynamicprogramming;

import java.util.Arrays;

public class DungeonPrincess {
  public static void main( String[] args ) {
    DungeonPrincess dungeonPrincess = new DungeonPrincess();
    int[][] hp  ={{-2,-3,3}, {-5,-10,1}, {10,30,-5}};
    System.out.println(dungeonPrincess.calculateMinimumHP(hp));
  }

  public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;
        int[][] dp = new int[n][m];
        for( int i = 0; i < n; i++ ) {
            Arrays.fill(dp[i], -1);
        }
        return minimumHealth(dungeon, n-1, m-1, dp);
    }

    private int minimumHealth( int[][] dungeon, int i, int j, int[][] dp  ) {
        if( i == 0 && j == 0 ) {
            dp[i][j] =  Math.max(1, 1 - dungeon[i][j]);
            return dp[i][j];
        }

        if( i < 0 || j < 0 ){
            return Integer.MAX_VALUE/2;
        }

        if( dp[i][j] == -1 ) {
            int minHealth = Math.min(minimumHealth(dungeon, i-1, j, dp), minimumHealth(dungeon, i, j-1, dp));
            dp[i][j] = Math.max( minHealth - dungeon[i][j], 1);
        }

        return dp[i][j];
    }
  
}
