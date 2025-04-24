package com.vikram.dsa.arrays;

public class MaxAbsoluteDifference {

  public static void main( String[] args ) {
    int[] arr = {3,1,8,6,9,4,3,9,3,11,1};
    MaxAbsoluteDifference absoluteDifference = new MaxAbsoluteDifference();
    System.out.println(absoluteDifference.getMaxAbsoluteDifference(arr));
  }

  public int getMaxAbsoluteDifference( int[] arr ) {
    int n = arr.length;
    int xMax = Integer.MIN_VALUE;
    int yMax = Integer.MIN_VALUE;
    int xMin = Integer.MAX_VALUE;
    int yMin = Integer.MAX_VALUE;

    for( int i = 0; i < n; i++ ) {
      xMax = Math.max(xMax, arr[i]-i);
      yMax = Math.max(yMax, arr[i] + i);
      xMin = Math.min(xMin, arr[i] - i);
      yMin = Math.min(yMin, arr[i] + i);
    }

    return Math.max((xMax-xMin), (yMax - yMin));
  }
  
}
