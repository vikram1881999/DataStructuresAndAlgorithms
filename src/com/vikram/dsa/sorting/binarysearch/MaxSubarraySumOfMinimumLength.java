package com.vikram.dsa.sorting.binarysearch;

public class MaxSubarraySumOfMinimumLength {


  public int getLength(int[] arr, int B ) {

    int l = 0;
    int h = arr.length;
    int ans = 0;
    while( l < h ) {
      int m = (l+h)/2;
      int sum = getMaxSum(arr, m);
      if( sum <= B ) {
        ans = m;
        l = m+1;
      } 
      else {
        h = m-1;
      }

    }
    return ans;
  }
  
  private int getMaxSum(int[] arr, int m ) {
    int sum = 0;
    int maxSum = 0;
    for( int i = 0; i < m; i++ ) {
      sum = sum + arr[i];
    }
    maxSum = Math.max(maxSum, sum);
    for( int i = 1; i <= arr.length -m; i++ ) {
      sum = sum + arr[i + m -1];
      sum = sum - arr[i-1];
      maxSum = Math.max(maxSum, sum);
    }

    return sum;
  }
}
