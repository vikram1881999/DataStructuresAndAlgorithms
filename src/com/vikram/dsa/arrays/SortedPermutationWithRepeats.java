package com.vikram.dsa.arrays;

import java.math.BigInteger;

public class SortedPermutationWithRepeats {

  public static void main( String[] args ) {
    SortedPermutationWithRepeats permutationRank = new SortedPermutationWithRepeats();
    String A = "babaa";
    System.out.println(permutationRank.findRank(A));
  }

  public int findRank(String A ) {
    int n = A.length();
    int rank = 0;
    int duplicatePermutations = 1;
    int[] fact = new int[n+1];
    fact[0] = 1;
    for( int i = 1; i <= n; i++ ) {
      fact[i] = fact[i-1] * i;
    }
    int[] charCount = new int[256];
    for( int i = 0; i < A.length(); i++ ) {
      char ch = A.charAt(i);
      int charPos = (int)ch;
      charCount[charPos] = charCount[charPos] +1 ;
    }

    for( int i = 0; i < 256; i++ ) {
      if( charCount[i] != 0 ) {
        duplicatePermutations = duplicatePermutations * fact[charCount[i]];
      }
    }

    int[] pfFreqCount = new int[charCount.length];
    pfFreqCount[0] = charCount[0];
    for( int i = 1; i < pfFreqCount.length; i++ ) {
      pfFreqCount[i] = pfFreqCount[i-1] + charCount[i-1];
    }

    for( int i = 0; i < A.length(); i++)  {
      char ch = A.charAt(i);
      int charPos = (int)ch;
      int count = pfFreqCount[charPos] - pfFreqCount[charPos-1];
      int totalArrangeMents = count*fact[n-i-1]/duplicatePermutations;
      rank = rank + totalArrangeMents;
      
      //frequency of current pos
      int f = charCount[charPos];
      charCount[charPos] -= 1;
      duplicatePermutations = duplicatePermutations/f;
    }


    return (rank);

  }


  private static final int ALPHABET_SIZE = 256; // Assuming ASCII characters

    public static BigInteger findRank1(String A) {
        int n = A.length();
        if (n == 0) return BigInteger.ONE;

        // Precompute factorials
        BigInteger[] factorial = new BigInteger[n + 1];
        factorial[0] = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1].multiply(BigInteger.valueOf(i));
        }

        // Build frequency array
        int[] freq = new int[ALPHABET_SIZE];
        for (char c : A.toCharArray()) {
            freq[c]++;
        }

        // Build prefix sum array for quick sum of freq[c] where c < current
        int[] prefix = new int[ALPHABET_SIZE];
        prefix[0] = 0;
        for (int i = 1; i < ALPHABET_SIZE; i++) {
            prefix[i] = prefix[i - 1] + freq[i - 1];
        }

        // Compute initial product of factorials
        BigInteger prodFact = BigInteger.ONE;
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if (freq[i] > 0) {
                prodFact = prodFact.multiply(factorial[freq[i]]);
            }
        }

        return rank(A, 0, n, freq, prodFact, factorial, prefix);
    }

    private static BigInteger rank(String s, int start, int n, int[] freq, 
                                 BigInteger prodFact, BigInteger[] factorial, int[] prefix) {
        // Base case: empty string has rank 1
        if (n == 0) return BigInteger.ONE;

        char current = s.charAt(start);
        int charIndex = (int) current;

        // Sum of frequencies of characters < current
        int sumFreq = prefix[charIndex];
        
        // Number of permutations with smaller character at this position
        BigInteger totalFact = factorial[n - 1].divide(prodFact);
        BigInteger res = BigInteger.valueOf(sumFreq).multiply(totalFact);

        // Update frequency and product for recursion
        int k = freq[charIndex];
        freq[charIndex]--;
        BigInteger newProdFact = (k > 1) ? prodFact.divide(BigInteger.valueOf(k)) : prodFact;
        
        // Recurse for the remaining string
        BigInteger nextRank = rank(s, start + 1, n - 1, freq, newProdFact, factorial, prefix);
        
        // Restore frequency
        freq[charIndex]++;

        return res.add(nextRank);
    }
  
}
