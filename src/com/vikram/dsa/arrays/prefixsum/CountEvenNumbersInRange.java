package com.vikram.dsa.arrays.prefixsum;

import java.util.Arrays;

public class CountEvenNumbersInRange {

  public static void main( String[] args ) {
    int[] arr = {2,4,3,7,9,8,6,5,4,9};
    int[][] q = {{0,4}, {4, 8}, {3, 9}};
    CountEvenNumbersInRange countEvenNumbersInRange = new CountEvenNumbersInRange();
    System.out.println(Arrays.toString(countEvenNumbersInRange.evenInRange(arr, q)));
  }

  public int[] evenInRange( int[] arr, int[][] queries ) {
    int n = queries.length;
    int[] ans = new int[n];
    int[] pf = new int[arr.length];
    pf[0] = 1-arr[0]%2;
    for( int i = 1; i < arr.length; i++ ) {
      pf[i] = pf[i-1] + (1-arr[i]%2);
    }

    for( int i = 0; i < n; i++ ) {
      int l = queries[i][0];
      int r = queries[i][1];
      if( l == 0 ) {
        ans[i] = pf[r];
      }
      else {
        ans[i] = pf[r] - pf[l-1];
      }
    }
    return ans;
  }
  
}

