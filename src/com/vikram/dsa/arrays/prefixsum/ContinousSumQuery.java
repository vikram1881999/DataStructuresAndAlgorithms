package com.vikram.dsa.arrays.prefixsum;

import java.util.Arrays;

public class ContinousSumQuery {

  public static void main( String[] args ) {
    int[][] B = {{1,2,10}, {2,3,20}, {2,5,25}};
    int A = 5;
    ContinousSumQuery continousSumQuery = new ContinousSumQuery();
    System.out.println(Arrays.toString(continousSumQuery.amountInBeggerPot(A, B)));
  }

  public int[] amountInBeggerPot( int A, int[][] B ) {
    int[] moneyPot = new int[A];
    for( int i = 0; i < B.length; i++ ) {
      int l = B[i][0];
      int r = B[i][1];
      int m = B[i][2];
      moneyPot[l-1] += m;
      if( r < moneyPot.length ) {
        moneyPot[r] -= m;
      }
    }

    for( int i = 1; i < moneyPot.length; i++ ) {
      moneyPot[i] = moneyPot[i] + moneyPot[i-1];
    }

    return moneyPot;
  }
  
}
