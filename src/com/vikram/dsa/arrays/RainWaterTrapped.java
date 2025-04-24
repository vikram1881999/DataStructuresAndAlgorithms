package com.vikram.dsa.arrays;

/**
 * To know water is trapped over a building we need to know the longest building on left an right.
 */
public class RainWaterTrapped {

  public static void main( String[] args ) {
    int[] arr = { 5, 4, 1,4,3,2,7};
    RainWaterTrapped rainWaterTrapped = new RainWaterTrapped();
    System.out.println(rainWaterTrapped.getTotalAmountWaterTrapped(arr));
  }


  public int getTotalAmountWaterTrapped( int[] arr ) {
    int n = arr.length;
    int waterTrapped = 0;
    int[] pfmax  = new int[n];
    int[]  sfmax = new int[n];
    for( int i = 0; i < n; i++)  {
      if( i == 0 ) {
        pfmax[i] = arr[i];
      }
      else {
        pfmax[i] = Math.max(pfmax[i-1], arr[i]);
      }
    }
    for( int i = n-1; i >= 0; i-- ) {
      if( i == n-1 ) {
        sfmax[i] = arr[i];
      }
      else {
        sfmax[i] = Math.max(arr[i], sfmax[i+1]);
      }
    }

    for( int i = 0; i < n; i++ ) {
      int maxR = sfmax[i];
      int maxL = pfmax[i];
      waterTrapped += Math.max( 0, (Math.min(maxR, maxL) - arr[i]));
    }

    return waterTrapped;
  }
  
}
