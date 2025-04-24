package com.vikram.dsa.arrays.subarrays;


/**
 * Can be solved using kadane's algo
 */
public class MaxSumContigousSubarray {

  public static void main( String[] args ) {
    int[] arr1 = {1,2,3,4,-10};
    int[] arr2 = {-2,1,-3,4,-1,2,1,-5,4};
    MaxSumContigousSubarray contigousSubarray = new MaxSumContigousSubarray();
    System.out.println(contigousSubarray.maxSum(arr1));
    System.out.println(contigousSubarray.maxSum(arr2));
  }

  public int maxSum( int[] arr ) {
    int n = arr.length;
    int maxSum = 0;
    int sum = 0;
    for( int i = 0; i < n; i++ ) {
      sum = sum + arr[i];
      if( sum < 0 ) {
        sum = 0;
      }
      maxSum = Math.max(maxSum, sum);
    }

    return maxSum;
  }
  
}
