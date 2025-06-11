package com.vikram.dsa.dynamicprogramming;

import java.util.Arrays;

public class KInversePairs {

  public static void main( String[] args ) {
    KInversePairs inversePairs = new KInversePairs();
    System.out.println(inversePairs.kInversePairsEfficient(3, 3));
  }

  int mod = 1_000_000_007;
    public int kInversePairs(int n, int k) {
        long[][] dp = new long[n+1][k+1];
        for( int i = 0; i <=n; i++) {
            Arrays.fill( dp[i], -1L );
        }

        return (int)kInversePairs( dp, n, k );
    }

    public long kInversePairs( long[][] dp, int n, int k ) {
        if( k < 0 ) {
          return 0;
        }
        if( n <= 0 ) {
          if( k==0 ) {
            return 1;
          }
          return 0;
        }
        if( dp[n][k] != -1L ) {
            return dp[n][k];
        }

        dp[n][k] = 0;
        for( int i = 0; i < n; i++ ) {
          dp[n][k] += kInversePairs( dp, n-1, k-i );
        }
        
        return dp[n][k];
    }


    public int kInversePairsEfficient(int n, int k) {
      int mod = 1_000_000_007;
      long[][] dp = new long[n+1][k+1];
      dp[0][0] = 1L;
      for( int i = 1; i <= n; i++ ) {
          long sum = 0;
          for( int j = 0; j <= k; j++ ) {
            sum =  (sum + dp[i-1][j])%mod;
            if( j >= i ) {
                      sum = (sum - dp[i-1][j-i] + (long)mod)%mod;
                  }
                  dp[i][j] = sum;
          }
      }

      return (int)dp[n][k];
  }
  
}
