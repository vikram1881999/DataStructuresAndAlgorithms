package com.vikram.dsa.arrays.subarrays;

import java.util.Arrays;

public class MaxNegativeSubArray {

  public static void main(String[] args ) {
    int[] arr = {336465782,-278722862,-2145174067,1101513929,1315634022,-1369133069,1059961393,628175011,-1131176229,-859484421};
    MaxNegativeSubArray maxNegativeSubArray = new MaxNegativeSubArray();
    System.out.println(Arrays.toString(maxNegativeSubArray.subArray(arr)));
  }

  public int[] subArray(int[] arr ) {
    long mod = Long.MAX_VALUE;
    long maxSum = Integer.MIN_VALUE;
    long sum = 0;
    int maxLength = 0;
    int l = 0;
    int startIndex = -1;
    for( int i = 0; i < arr.length; i++ ) {
      if( arr[i] < 0 ) {
        if( sum > maxSum ) {
          maxSum = sum;
          maxLength = l;
          startIndex = i-l;
        }
        sum = 0;
        l = 0;
      }
      else {
        sum = (sum + (long)arr[i])%mod;
        l += 1;
      }
    }
    if( sum > maxSum ) {
      maxSum = sum;
      maxLength = l;
      startIndex = arr.length-l;
    }
    int[] subrray = new int[maxLength];
    int index = 0;
    for( int i = startIndex; i < startIndex + maxLength; i++ ) {
      subrray[index] = arr[i]; 
      index++;
    }

    return subrray;
  }
  
}
