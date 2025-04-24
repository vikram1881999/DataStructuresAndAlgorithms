package com.vikram.dsa.arrays.twodimensionalarrays;

import java.util.Arrays;

public class SubMatrixSumQueries {

  public static void main(  String[] args ) {

    int[][] arr= {{1,2,3}, {4,5,6}, {7,8,9}};
    int[] A = {0,1};
    int[] B = {0,1};
    int[] C = {1,2};
    int[] D = {1,2};

    SubMatrixSumQueries matrixSumQueries = new SubMatrixSumQueries();
    System.out.println( Arrays.toString(matrixSumQueries.submatrixSum(arr, A, B, C, D)));
  }

  public int[] submatrixSum(int[][] mat, int A[], int B[], int C[], int D[]) {
    int[][] pf = new int[mat.length][mat[0].length];
    int ans[] = new int[A.length];

    // Row wise prefix sum
    for( int i = 0; i < mat.length; i++ ) {
      for( int j = 0; j < mat[i].length; j++ ) {
        if( j == 0 ) {
          pf[i][j] = mat[i][j];
          continue;
        }
        pf[i][j] = mat[i][j] + pf[i][j-1];
      }
    }

    // Col wise prefix sum
    for( int j = 0; j < mat[0].length; j++ ) {
      for( int i = 0; i < mat.length; i++ ) {
        if( i != 0 ) {
          pf[i][j] = pf[i][j] + pf[i-1][j];
        }
      }
    }

    for( int i = 0; i < A.length; i++ ) {
      int tx = A[i];
      int ty = B[i];
      int bx = C[i];
      int by = D[i];
      int sum = 0;
      if( tx == 0 && ty == 0 ) {
        sum = pf[bx][by];
      }
      else if( tx == 0 ) {
        sum = sum - pf[bx][ty-1];
      }
      else if( ty == 0 ) {
        sum = sum - pf[tx-1][by];
      }
      else {
        sum  =  pf[bx][by] + pf[tx-1][ty-1] - pf[tx-1][by] - pf[bx][ty-1];
      }
      ans[i] = sum;
    }

    return ans;

  }
  
}
