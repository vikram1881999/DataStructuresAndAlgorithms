package com.vikram.dsa.dynamicprogramming;

import java.util.Arrays;

public class MaxInPartitionSum {

  public static void main( String[] args ) {
    int[] arr = {1,15,7,9,2,5,10};
    MaxInPartitionSum maxInPartitionSum = new MaxInPartitionSum();
    System.out.println( maxInPartitionSum.maxSumAfterPartitioning(arr, 3));
  }

  public int maxSumAfterPartitioning(int[] arr, int k) {
        int[][] dp = new int[arr.length][arr.length];
        for( int i = 0; i < arr.length; i++ ) {
            Arrays.fill(dp[i], -1);
        }
        return maxSumAfterPartitioning(arr, 0, arr.length-1, k, dp);
    }

    public int maxSumAfterPartitioning( int[] arr, int i, int j, int l, int[][] dp ) {
        if( i > j ) {
            return 0;
        }
        if( j-i+1 <= l ) {
            int max = 0;
            for( int k = i; k <= j; k++ ) {
                max = Math.max(max, arr[k]);
            }
            dp[i][j] = (j-i+1)*max;
            return dp[i][j];
        }
        int max = 0;
        for( int k = i; k <= j; k++ ) {
            int left = maxSumAfterPartitioning( arr, i, k, l, dp);
            int right = maxSumAfterPartitioning( arr, k+1, j, l, dp);
            max = Math.max( max, left+right);
        }
        dp[i][j] = max;
        return max;
    }
  
}
