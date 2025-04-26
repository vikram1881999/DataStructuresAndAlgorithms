package com.vikram.dsa.graphs;

import java.util.Arrays;

public class LongestIncreasingPathSum {

  public static void main( String[] args ) {
    int[][] matrix = {{9,9,4}, {6,6,8}, {2,1,1}};
    LongestIncreasingPathSum increasingPathSum =  new LongestIncreasingPathSum();
    System.out.println(increasingPathSum.longestIncreasingPath(matrix));
  }

  private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  public int longestIncreasingPath(int[][] matrix) {
        if( matrix.length < 1 ) {
            return 0;
        }
        int ans = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for( int i = 0; i < n; i++ ) {
           Arrays.fill(dp[i], -1);
        }
        for( int i = n-1; i >= 0; i-- ) {
            for( int j =m-1; j >= 0; j-- ) {
                dfs(matrix, i, j, n, m, dp);
            }
        }

        for( int i = 0; i < n; i++ ) {
            for( int j = 0; j < m; j++ ) {
                ans = Math.max(ans, dp[i][j]);
            }
        }

        return ans+1;
    }


    public int dfs(int[][] matrix, int i, int j, int n, int m, int[][] dp ) {
      if( dp[i][j] != -1 ) {
        return dp[i][j];
      }

      int max = 0;
      for( int[] dir: DIRS ) {
        int x = i + dir[0];
        int y = j + dir[1];
        if( x >= 0 && x < n && y>=0 && y < m && matrix[x][y] > matrix[i][j]) {
          int l = 1 + dfs(matrix, x, y, n, m, dp);
          max = Math.max(l, max);
        }
      } 
      dp[i][j] = max;

      return dp[i][j];
    }
  
}
