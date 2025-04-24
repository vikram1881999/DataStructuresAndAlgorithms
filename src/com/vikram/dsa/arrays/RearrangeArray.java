package com.vikram.dsa.arrays;

public class RearrangeArray {

  public static void main( String[] args ) {

  }

  public int[] rearrangeArray(int[] arr ) {
    int n = arr.length;
    for( int i = 0; i < arr.length; i++ ) {
      arr[i] = arr[i]*n;
    }

    for( int i = 0; i < arr.length; i++ ) {
      arr[i] = arr[arr[i]/n]/n + arr[i];
    }

    for( int i = 0; i < arr.length; i++ ) {
      arr[i] = arr[i]%n;
    }

    return arr;
  }
  
}
