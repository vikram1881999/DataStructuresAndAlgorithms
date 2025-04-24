package com.vikram.dsa.arrays;

public class SortedPermutationRank {

  public static void main( String[] args ) {
    String A = "DTNGJPURFHYEW";
    SortedPermutationRank sortedPermutationRank = new SortedPermutationRank();
    System.out.println( sortedPermutationRank.findRank(A) );
  }

  public int findRank( String A ) {
    int rank = 0;
    int[] fact = new int[A.length() + 1];
    fact[0] = 1;
    for( int i =1;  i < fact.length; i++ ) {
      fact[i] = fact[i-1] * i;
    };
    int[] charCount = new int[256];
    for( int i = 0; i < A.length(); i++ ) {
      int chPos = (int)A.charAt(i);
      charCount[chPos] = 1;
    }

    for( int i = 0; i < A.length(); i++ ) {
      int ch = (int)A.charAt(i);
      int chPos = ch;
      int count = 0;
      for( int j = 0; j < 256; j++ ) {
        if( j != chPos ) {
          count =  count + charCount[j];
        }
        else {
          break;
        }
      }
      charCount[chPos] = 0;
      rank = rank + count*fact[A.length()-i-1];
    }

    return rank + 1;
  }
  
}
