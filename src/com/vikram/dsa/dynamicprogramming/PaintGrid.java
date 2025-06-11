package com.vikram.dsa.dynamicprogramming;

import java.util.Arrays;

public class PaintGrid {

  public static void main( String[] args ) {
    PaintGrid paintGrid = new PaintGrid();
    System.out.println(paintGrid.numOfWays(1));
  }


  long MOD = 1_000_000_007L;
    private static final int[][] moves = {{0,-1}, {0, 1}, {1, 0}, {-1, 0}};
    public int numOfWays(int n) {
        long[][][] dp = new long[n][3][3+1];
        boolean[][][] visited = new boolean[n][3][3+1];
        for( int i = 0; i < n; i++ ) {
            for( int j = 0; j < 3; j++ ) {
                Arrays.fill(dp[i][j], -1L);
            }
        }
        long total = 0;
        for( int i = 1; i <= 3; i++ ) {
            total = (total + ways( n, i, 0, 0, dp, visited))%MOD;
        }

        return (int)total;
    }

    public long ways( int n, int currentColor, int i, int j, long[][][] dp, boolean[][][] visited) {
        if( i == n-1 && j == 2) {
            return 1;
        }
        if( i == n || j == 3) {
            return 0;
        }
        if( dp[i][j][currentColor] != -1L ) {
            return dp[i][j][currentColor];
        }
        visited[i][j][currentColor] = true;
        long steps = 0;
        for( int k = 1; k <= 3; k++ ) {
            if( currentColor != k ) {
                for( int[] move: moves ) {
                    int x = i + move[0];
                    int y = j + move[1];
                    if( x >= 0 && x < n && y > 0 && y < 3 && !visited[x][y][k]) {
                       steps = (steps + ways( n, k, x, y, dp, visited))%MOD;
                    }
                }
            }
        }
        visited[i][j][currentColor] = false;
        dp[i][j][currentColor] = steps;
        return dp[i][j][currentColor];
    }
  
}
