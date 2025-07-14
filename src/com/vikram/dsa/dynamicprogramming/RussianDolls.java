package com.vikram.dsa.dynamicprogramming;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDolls {

  public static void main( String[] args ) {
    RussianDolls dolls = new RussianDolls();
    int[][] arr = {{5,4},{6,4},{6,7},{2,3}};
    System.out.println(dolls.maxEnvelopes(arr));
  }


   public int maxEnvelopes(int[][] envelopes) {
        
        Arrays.sort( envelopes, new Comparator<int[]>() {
            @Override
            public int compare( int[] a, int[] b ) {
                if( a[0] == b[0] ) {
                    return b[1] - a[1];
                }
                return a[0]-b[0];
            }
        });

        int maxCount = 0;

        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);

        for( int i = 0; i < envelopes.length; i++ ) {
            for( int j = 0; j < i; j++ ) {
                if( envelopes[j][1] < envelopes[i][1] ) {
                    dp[i] = Math.max( dp[i], dp[j] + 1);
                }
            }
            maxCount = Math.max( dp[i], maxCount );
        }

        return maxCount;

    }
  
}
