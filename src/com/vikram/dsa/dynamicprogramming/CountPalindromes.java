package com.vikram.dsa.dynamicprogramming;

import java.util.Arrays;

public class CountPalindromes {

    public int countPalindromes(String s) {
        long[][][] dp = new long[s.length()][s.length()][6];
        for( int i = 0; i < s.length(); i++ ){
            for( int j = 0; j < s.length(); j++ ) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return (int)(countPalindromes( s, 0, s.length()-1, 5, dp)%1000000007);
    }

    public long countPalindromes(  String s, int i, int j, int k, long[][][] dp ) {
        if(i > j) {
            return 0L;
        }
        if( k == 0 ) {
            return 1L;
        }
        if( k == 1 ) {
            dp[i][j][k] = j - i + 1;
            return j - i + 1;
        }
        if( dp[i][j][k] != -1 ) {
            return dp[i][j][k];
        }

        long skipLeft = countPalindromes( s, i+1, j, k, dp);
        long skipRight = countPalindromes( s, i, j-1, k, dp);
        long skipBoth = countPalindromes(s, i+1, j-1, k, dp);
        long keep = skipLeft + skipRight - skipBoth;
        if( s.charAt(i) == s.charAt(j) && k >= 2 ) {
            keep += countPalindromes(s, i+1, j-1, k-2, dp);
        }
        dp[i][j][k] = keep;
        return dp[i][j][k];
    }
}
