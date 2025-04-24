package com.vikram.dsa.arrays.twodimensionalarrays;

public class MaxSortedSubmatrixSum {
  
  public static void main(String[] args) {
    MaxSortedSubmatrixSum maxSortedSubmatrixSum = new MaxSortedSubmatrixSum();
    int[][] mat = {{-5,-4,-3},{-1,2,3}, {2,2,4}};
    System.out.println(maxSortedSubmatrixSum.maxSubSum(mat));
  }

  public int maxSubSum( int[][] mat ) {
    int n = mat.length;
    int m = mat[0].length;
    int bx = n-1;
    int by = m-1;
    int maxSum = Integer.MIN_VALUE;
    int[][] pf = new int[n][m];
    // Row wise sum
    for( int i = 0; i < n; i++ ) {
      for( int j = 0; j < m; j++ ) {
        if( j == 0 ) {
          pf[i][j] = mat[i][j];
        }
        else {
          pf[i][j] = mat[i][j] + pf[i][j-1];
        }
      }
    }
    // Col wise sum
    for( int j = 0; j < m; j++ ) {
      for( int i = 0; i < n; i++) {
        if( i != 0  ){
          pf[i][j] = pf[i][j] + pf[i-1][j];
        }
      }
    }

    for( int i = 0; i < n; i++ ) {
      for( int j = 0; j < m; j++ ) {
        int sum = 0;
        if( i == 0 && j == 0 ) {
          sum = pf[bx][by];
        }
        else if( i == 0 ) {
          sum = pf[bx][by] - pf[bx][j-1];
        }
        else if( j == 0 ) {
          sum = pf[bx][by] - pf[i-1][by];
        }
        else {
          sum = pf[bx][by] + pf[i-1][j-1]  - pf[bx][j-1] - pf[i-1][by];
        }
        maxSum = Math.max(maxSum, sum);
      }
    }

    return maxSum;
  }

}
