package com.vikram.dsa.sorting.binarysearch;

public class FloorKNum {

  public int getGreatestElementLessThanOrEqualToK( int []arr, int k ) {
  int l = 0;
  int h = arr.length-1;
  int ans = Integer.MIN_VALUE;
  while( l <= h ) {
    int m = (l+h)/2;
    if  (arr[m] == k ) {
      return k;
    }
    if( arr[m] < k ) {
      ans = arr[m];
      l = m+1;
    }
    else {
      h = m-1;
    }
  }

  return ans;
}

  
}
