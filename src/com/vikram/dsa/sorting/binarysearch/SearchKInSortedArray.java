package com.vikram.dsa.sorting.binarysearch;

public class SearchKInSortedArray {

  public static void main( String[] args ) {
    SearchKInSortedArray searchKInSortedArray = new SearchKInSortedArray();

  }

  public boolean search(int[] arr, int k) {
    int s = 0;
    int e = arr.length-1;
    while( s <= e ) {
      int m = (s+e)/2;
      if( arr[m] == k ) {
        return true;
      }
      else if( arr[m] < k ) {
        s = m+1;
      }
      else {
        e = m-1;
      }
    }

    return false;
  }
  
}
