package com.vikram.dsa.arrays.twodimensionalarrays;

public class MaxSumSubMatrix {

  public static void main(String[] args) {
    int[][] mat = {{2,-1,2,9},{-8,-5, -3, 11}, {3,4,4,-6}, {-3,-1,18,2}};
    MaxSumSubMatrix matriMaxSumSubMatrix = new MaxSumSubMatrix();
    System.out.println(matriMaxSumSubMatrix.getMaxSumSubMatrix(mat));
  }

  public int getMaxSumSubMatrix(int[][] mat) {
    int n = mat.length;
    int m = mat[0].length;
    int[][] pf = new int[n][m];
    int maxSum = Integer.MIN_VALUE;
    //row wise prefix sum
    for( int i = 0; i < n; i++ ) {
      for( int j = 0; j < m; j++ ) {
        if( j == 0 ) {
          pf[i][j] = mat[i][j];
          continue;
        }
        pf[i][j]=  mat[i][j] + pf[i][j-1];
      }
    }

    for( int i = 0; i < m; i++ ) {
      int l = i;
      int r = n-1;
      int sum = 0;
      if( i > 0 ) {
        for( int j = 0; j < n; j++ ) {
          pf[j][i] = pf[j][i] - pf[j][i-1];
        }
      }
      for( int k = r; k >= l; k-- ) {
        for( int j = 0; j < m; j++ ) {
          sum = sum + pf[j][i];
          if( sum < 0 ) {
            sum = 0;
          }
          maxSum = Math.max(maxSum, pf[j][i]);
          maxSum = Math.max(maxSum, sum);
        }
      }
    }

    return maxSum;
  }
  
}
