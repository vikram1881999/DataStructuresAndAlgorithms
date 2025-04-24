package com.vikram.dsa.graphs;

import java.util.Arrays;

public class LongestIncreasingPathSum {

  public static void main( String[] args ) {
    int[][] matrix = {{9,9,4}, {6,6,8}, {2,1,1}};
    LongestIncreasingPathSum increasingPathSum =  new LongestIncreasingPathSum();
    System.out.println(increasingPathSum.longestIncreasingPath(matrix));
  }

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
        if( i < 0 || j < 0 || i >= n || j >= m ) {
            return 0;
        }
        int max = 0;
        if( i > 0 && matrix[i-1][j] > matrix[i][j] ) {
            if( dp[i-1][j] == -1 ) {
                max = Math.max(max, dfs(matrix, i-1, j, n, m, dp) + 1);
            }
            else {
                max = Math.max( max, dp[i-1][j]+1 );
            }
        }
         if( j > 0 && matrix[i][j-1] > matrix[i][j] ) {
            if( dp[i][j-1] == -1 ) {
                max = Math.max(max, dfs(matrix, i, j-1, n, m, dp) + 1);
            }
            else {
                max = Math.max( max, dp[i][j-1]+1 );
            }
        }
         if( i < n-1 && matrix[i+1][j] > matrix[i][j] ) {
            if( dp[i+1][j] == -1 ) {
                max = Math.max(max, dfs(matrix, i+1, j, n, m, dp) + 1);
            }
            else {
                max = Math.max( max, dp[i+1][j]+1 );
            }
        }
         if( j < m-1  && matrix[i][j+1] > matrix[i][j] ) {
            if( dp[i][j+1] == -1 ) {
                max = Math.max(max, dfs(matrix, i, j+1, n, m, dp) + 1);
            }
            else {
                max = Math.max( max, dp[i][j+1]+1 );
            }
        }

        dp[i][j] = max;

        return dp[i][j];
    }
  
}
