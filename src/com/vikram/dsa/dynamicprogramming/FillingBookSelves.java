package com.vikram.dsa.dynamicprogramming;

import java.util.Arrays;

public class FillingBookSelves {

  public static void main( String[] args ) {
    FillingBookSelves bookSelves = new FillingBookSelves();
    int[][] arr = {{1,1},{2,3},{2,3},{1,1},{1,1},{1,1},{1,2}};
    System.out.println( bookSelves.minHeightShelves(arr, 4));
  }


  public int minHeightShelves(int[][] books, int shelfWidth) {
    int[] dp =  new int[books.length];
    Arrays.fill(dp,-1);
    return minHeightShelves( books, shelfWidth, 0, dp);
}

public int minHeightShelves( int[][] books, int shelfWidth, int i, int[] dp ) {
    int n =  books.length;
    if( i >= n ) {
        return 0;
    }
    if( dp[i] != -1 ) {
      return dp[i];
    }
    int minHeight =  minHeightShelves( books, shelfWidth, i+1, dp) + books[i][1];
    int j = i;
    int currWidth = 0;
    int currHeight = 0;
    while( j < n && currWidth + books[j][0] <= shelfWidth ) {
      currHeight = Math.max( books[j][1], currHeight );
      currWidth +=  books[j][0];
      j++;
    }
    if( i != j ) {
        minHeight = Math.min(minHeightShelves( books, shelfWidth, j, dp ) + currHeight, minHeight);
    }
    dp[i] = minHeight;
    return minHeight;
}
  
}
