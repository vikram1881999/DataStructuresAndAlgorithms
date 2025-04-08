package com.vikram.dsa.arrays;

public class FlipBinaryString {

  public static void main(String[] args) {
    String str = "100100111101";
    FlipBinaryString binaryString = new FlipBinaryString();
    System.out.println(binaryString.maxOnesAfterFlipping(str));
  }


  public int maxOnesAfterFlipping( String str ) {
    int max = 0;
    int sum = 0;
    int count = getCount(str, '1');
    if( count == str.length()) {
      return count;
    }
    for( int i = 0; i < str.length(); i++ ) {
      if( str.charAt(i) == '1' ) {
        sum = sum - 1;
        sum = Math.max(sum, 0);
      } 
      else if( str.charAt(i) == '0') {
        sum = sum + 1;
      }
      max = Math.max(max, sum);
    }
    
    return max + count;
  }

  public int getCount(String str, char ch ) {
    int c = 0;
    for( int i = 0; i < str.length(); i++ ) {
      if( str.charAt(i) == ch ) {
        c++;
      }
    }
    return c;
  }
  
}