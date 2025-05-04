package com.vikram.dsa.StringMatching;

public class LongestPalindromicSubstring {

  public static void main( String[] args ) {
    LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
    System.out.println(longestPalindromicSubstring.longestPalindrome("abbbaaaabb"));
  }

  public String longestPalindrome(String s) {
        int n = s.length();
        int maxLength = 1;
        String longestPalindrome = s.charAt(0) + "";
        for( int i = 1; i < n; i++ ) {
            int k = i;
            int j = i;
            while( k >= 0 && j < n ) {
                if( s.charAt(k) != s.charAt(j) ) {
                    break;
                }
                k--;
                j++;
            }
            String str = s.substring(k+1, j);
            if( str.length() > maxLength ) {
                maxLength = str.length();
                longestPalindrome = str;
            }

            if( s.charAt(i-1) == s.charAt(i) ) {
                k = i-1;
                j = i;
                while( k >= 0 && j < n ) {
                    if( s.charAt(k) != s.charAt(j) ) {
                        break;
                    }
                    k--;
                    j++;
                }
                String str2 = s.substring(k+1, j);
                if( str2.length() > maxLength ) {
                    maxLength = str2.length();
                    longestPalindrome = str2;
                }
            }
        }

        return longestPalindrome;
    }
    
}

class Pair {
  int max;
  int index;
  public Pair(int max, int index ){
    this.max = max;
    this.index = index;
  }
}