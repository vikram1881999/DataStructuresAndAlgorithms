package com.vikram.dsa.sorting.binarysearch;

public class Duplicates {


  public static void main(String[] args) {

  }

  public int getNonDuplicate(int[] arr)  {
    if( arr.length == 1  ){
      return arr[arr.length-1];
    }
    if( arr[0]  != arr[1] ) {
      return arr[0];
    }
    if( arr[arr.length-1] != arr[arr.length-2]) {
      return arr[arr.length-1];
    }
    int l = 0;
    int r = arr.length-1;

    while( l <= r ) {
      int m = (l+r)/2;
      if( arr[m-1] != arr[m] && arr[m+1] != arr[m]  ){
        return arr[m];
      }
      if( arr[m] == arr[m-1] ) {
        m = m-1;
      }
      if( m%2 == 0 ) {
        l = m+2;
      }
      else {
        r = m-1;
      }
      
    }

    return -1;
  }
  
}
