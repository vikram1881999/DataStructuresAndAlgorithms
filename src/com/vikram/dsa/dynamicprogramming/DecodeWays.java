package com.vikram.dsa.dynamicprogramming;

import java.util.Arrays;

public class DecodeWays {

  public static void main( String[] args ) {
    DecodeWays decodeWays = new DecodeWays();
    System.out.println( decodeWays.numDecodings("1000000"));
  }

  public int numDecodings(String s) {
    int[] dp = new int[s.length()];
    Arrays.fill(dp, -1);
    return numDecodings( s, dp, 0);
}

public int numDecodings(String s, int[] dp, int i ) {
    if( i >= s.length() ) {
        return 1;
    }
    if( s.charAt(i) == '0' ) {
        return 0;
    }
    if( dp[i] != - 1) {
        return dp[i];
    }
    dp[i] = numDecodings( s, dp, i+1 );
    if( i + 1 < s.length() && Integer.parseInt(s.substring(i, i+2)) <= 26) {
        int pickTwo = numDecodings( s, dp, i+2 );
        dp[i] += pickTwo;
    }

    return dp[i];
}
  
}
