package com.vikram.dsa.dynamicprogramming;

import java.util.Arrays;

public class MinimumDistanceToTypeWordUsinTwoFinger {

  public static void main( String[] args ) {
    MinimumDistanceToTypeWordUsinTwoFinger distanceToTypeWordUsinTwoFinger = new MinimumDistanceToTypeWordUsinTwoFinger();
    System.out.println( distanceToTypeWordUsinTwoFinger.minimumDistance("CAKE"));
  }

  public int minimumDistance(String word) {
        int n = word.length();
        int[][][] dp = new int[27][27][n];
        for( int i = 0; i <= 26; i++ ) {
            for( int j = 0; j <= 26; j++ ) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return minimumDistance( word, 0, 26, 26, dp);
    }

    private int minimumDistance( String word, int i, int finger1, int finger2, int[][][] dp ) {
        if( i == word.length()) {
            return 0;
        }
        if( dp[finger1][finger2][i] != -1 ) {
            return dp[finger1][finger2][i];
        }

        char c = word.charAt(i);
        int currIndex = c - 'A';
        int distanceFinger1 = getDistance( finger1, currIndex );
        int distanceFinger2 = getDistance( finger2, currIndex );
        int cost1 = distanceFinger1 + minimumDistance( word, i+1, currIndex, finger2, dp );
        int cost2 = distanceFinger2 + minimumDistance( word, i+1, finger1, currIndex, dp );

        dp[finger1][finger2][i] = Math.min(cost1, cost2 );
        return dp[finger1][finger2][i];
    }

    private int getDistance( int finger, int curr ) {
        if( finger == 26 ) {
            return 0;
        }
        int x1 = finger/6;
        int y1 = finger%6;
        int x2 = curr/6;
        int y2 = curr%6;

        return Math.abs( x1 - x2 ) + Math.abs( y1 - y2 );
    }
  
}
