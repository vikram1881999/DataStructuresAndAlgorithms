package com.vikram.dsa.sorting.binarysearch;

public class FirstOccurenceOfRepeatingELement {
  public int getIndexOfFirstOccurance(int[] arr, int k ) {
  int l = 0;
  int h =  arr.length;
  int ans = -1;
  while( l <=  h ) {
    int m = (l+h)/2;
    if( arr[m] ==  k ) {
      ans = m;
      h = m-1;
    }
    else if ( arr[m] < k ) {
      l = m+1;
    }
    else {
      h = m-1;
    }
  }

  return ans;
}

}