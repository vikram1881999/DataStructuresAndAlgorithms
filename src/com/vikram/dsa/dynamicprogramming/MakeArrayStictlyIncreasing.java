package com.vikram.dsa.dynamicprogramming;

import java.util.Arrays;

public class MakeArrayStictlyIncreasing {

  public static void main( String[] args ) {
    MakeArrayStictlyIncreasing arrayStictlyIncreasing = new MakeArrayStictlyIncreasing();
    int[] arr1 = {1,5,3,6,7};
    int[] arr2 = {1,6,3,3};
    System.out.println(arrayStictlyIncreasing.makeArrayIncreasing(arr1, arr2));
  }

  public int makeArrayIncreasing(int[] arr1, int[] arr2) {
    int n = arr1.length;
    int m = arr2.length;
    Arrays.sort(arr2);
    int[][][] dp = new int[n][n+1][m+1];
    for( int i = 0; i < n; i++ ) {
        for( int j = 0; j <=n; j++ ) {
            Arrays.fill(dp[i][j], -1 );
        }
    }
    int cost = minCost( arr1, arr2, n-1, n, m-1, dp, n);
    return cost == 20001 ? -1 : cost;
}

private int minCost( int[] arr1, int[] arr2, int curr, int prev, int index, int[][][] dp, int n ) {
    if( curr < 0 ) {
        return 0;
    }

    int cost = 20001;
    if( (prev == n && arr1[curr] > arr2[index] )|| ( prev != n && arr1[curr] < arr1[prev] &&  arr1[curr] > arr2[index] ) ) {
      cost = Math.min( cost, minCost(arr1, arr2, curr-1, curr, index, dp, n));
    }
    if( (prev == n && arr1[curr] <= arr2[index]) || (prev!= n && arr1[curr] < arr1[prev] && arr2[index] >= arr2[curr]) ) {
      cost = Math.min( cost, minCost(arr1, arr2, curr, prev, index-1, dp, n)+1);
      cost = Math.min( cost, minCost(arr1, arr2, curr-1, curr, index-1, dp, n)+1);
      cost = Math.min( cost, minCost(arr1, arr2, curr-1, curr, index, dp, n)+1);
    }
    if( prev < n && arr1[curr] >= arr1[prev] && arr2[index] < arr1[prev] )  {
      cost = Math.min( cost, minCost(arr1, arr2, curr, prev, index-1, dp, n) + 1);
      cost = Math.min( cost, minCost(arr1, arr2, curr-1, curr, index-1, dp, n));
    }

    return cost;
}
}
