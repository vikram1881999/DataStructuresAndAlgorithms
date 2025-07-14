package com.vikram.dsa.dynamicprogramming;

import java.util.Arrays;

public class CountPairs {

  public static void main( String[] args  ){
    int[] arr = {2,3,2};
    CountPairs countPairs = new CountPairs();
    System.out.println( countPairs.countOfPairs(arr));
  }

   long MOD = 1_000_000_007L;
    public int countOfPairs(int[] nums) {
        int n = nums.length;
        long[][][] dp = new long[n][51][51];
        for( int i = 0; i < n; i++ ) {
            for( int j = 0; j <= 50; j++ ) {
                Arrays.fill( dp[i][j], -1 );
            }
        }
        return (int)countPairs( nums, 0, 0, 50, dp );
    }

    private long countPairs( int[] nums, int i, int prev1, int prev2, long[][][] dp ) {
        int n = nums.length;
        if( i >= n ) {
            return 1;
        }
        if( dp[i][prev1][prev2] != -1 ) {
            return dp[i][prev1][prev2];
        }
        
        long ways = 0;
        for( int k = 0; k <= nums[i]; k++ ) {
            int decreasing = nums[i] - k;
            if(  k >= prev1 && decreasing <= prev2 ) {
                ways = (ways + countPairs( nums, i+1, k, decreasing, dp))%MOD;
            }
        }

        dp[i][prev1][prev2] = ways;
        return ways;
    }
  
}
