package com.vikram.dsa.dynamicprogramming;

import java.util.HashSet;

public class CountPalindromeSubsequences {

  public static void main( String[] args ) {
    CountPalindromeSubsequences countPalindromeSubsequences =  new CountPalindromeSubsequences();
    System.out.println( countPalindromeSubsequences.countPalindromes("103301"));
  }


  public int countPalindromes(String s) {
        HashSet<String> palindromes = new HashSet<>();
        countPalindromes( s, 0, 5, "", palindromes);;
        return palindromes.size();
    }

    public int countPalindromes(  String s, int i, int k, String resultantStr , HashSet<String> palindromes) {
        if( k == 0 && isPalindrome(resultantStr)) {
            palindromes.add(resultantStr);
            return 1;
        }
        if( i >= s.length() || k <= 0  ) {
            return 0;
        }


        int keep = countPalindromes( s, i+1, k-1, resultantStr + s.charAt(i), palindromes );
        int skip = countPalindromes( s, i+1, k, resultantStr, palindromes  );

        return keep + skip;
    }

    private boolean isPalindrome( String s ) {
        int i = 0;
        int j = s.length() - 1;
        while( i < j ) {
            if( s.charAt(i) != s.charAt(j) ) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
  
}
