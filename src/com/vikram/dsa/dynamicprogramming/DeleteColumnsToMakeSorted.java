package com.vikram.dsa.dynamicprogramming;

import java.util.Arrays;

public class DeleteColumnsToMakeSorted {

  public static void main( String[] args  ){
    String[] arr = {"babca","bbazb"};
    DeleteColumnsToMakeSorted columnsToMakeSorted = new DeleteColumnsToMakeSorted();
    System.out.println( columnsToMakeSorted.minDeletionSize(arr) );
  }


  public int minDeletionSize(String[] strs) {
        
    int n = strs[0].length();

    int[][] dp = new int[n][n+1];
    for( int i = 0; i < n; i++ ) {
        Arrays.fill( dp[i], -1 );
    }

    return n - longetSubSequence( strs, 0, -1, dp, n );
}


private int longetSubSequence( String[] strs, int pos, int prevPos, int[][] dp, int n ) {
    if( pos >= n ) {
        return 0;
    }
    int maskedPrev = prevPos+1;
    if( dp[pos][maskedPrev] != -1 ) {
        return dp[pos][maskedPrev];
    }
    int length = longetSubSequence( strs, pos+1, prevPos, dp, n);
    if( canTake( strs, pos, prevPos) ) {
        length = Math.max( length, 1 + longetSubSequence(strs, pos+1, pos, dp, n) );
    }

    dp[pos][maskedPrev] = length;
    return length;
}

private boolean canTake( String[] strs, int pos, int prevPos ) {
    if( prevPos == -1 ){
        return true;
    }
    for( String str: strs ) {
        if (str.charAt(prevPos) > str.charAt(pos)) {
            return false;
        }
    }
    return true;
}
  
}
