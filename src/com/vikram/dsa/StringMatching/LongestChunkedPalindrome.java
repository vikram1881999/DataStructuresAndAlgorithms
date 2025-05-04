package com.vikram.dsa.StringMatching;

public class LongestChunkedPalindrome {

  public static void main( String[] args ) {
    LongestChunkedPalindrome longestChunkedPalindrome = new LongestChunkedPalindrome();
    String str = "ghiabcdefhelloadamhelloabcdefghi";
    System.out.println( longestChunkedPalindrome.longestDecomposition(str) );
  }

  public int longestDecomposition(String text) {
        String reverseText = new StringBuilder(text).reverse().toString();
        int c = 0;
        int prevMatchedIndex = 0;
            for( int j = 0; j < text.length(); j++ ){
                int x = j;
                int y = prevMatchedIndex;
                boolean isMatch = true;
                while( x >= prevMatchedIndex && y <= j ) {
                    if( reverseText.charAt(x) != text.charAt(y) ) {
                        isMatch = false;
                        break;
                    }
                    x--;
                    y++;
                }
                if( isMatch ) {
                  prevMatchedIndex = j + 1;
                  c++;
                }
        }
        return c;
    }



  
}
