package com.vikram.dsa.arrays;

public class MaxDistance {

  public static void main(String[] args) {
    int[] arr = { 9,8,7,6,5,4,3,2,1};
    MaxDistance distance = new MaxDistance();
    System.out.println( distance.maxDistance(arr) );
  }

  public int maxDistance( int[] arr ) {
    int maxDistance = 0;
    int sfMax[] = new int[arr.length];
    int pfMin[] = new int[arr.length];
    int p1 = 0;
    int p2 = 0;
    for( int i = 0; i < arr.length; i++ ) {
      if( i == 0 ) {
        pfMin[i] = arr[i];
      }
      else {
        pfMin[i] = Math.min(pfMin[i-1], arr[i]);
      }
    }

    for( int i = arr.length-1; i >= 0; i-- ) {
      if( i == arr.length-1 ) {
        sfMax[i] = arr[i];
      }
      else {
        sfMax[i] = Math.max(sfMax[i+1], arr[i]);
      }
    }

    while( p1 < arr.length && p2 < arr.length ) {
      if( sfMax[p1] >= pfMin[p2] ) {
        maxDistance = Math.max(maxDistance, p1-p2 + 1);
        p1++;
      }
      else {
        p2++;
      }
    }

    return maxDistance;
  }
  
}
