package com.vikram.dsa.dynamicprogramming;

public class ScrambleString {

  public static void main( String[] args ) {
    ScrambleString scrambleString = new ScrambleString();
    System.out.println(scrambleString.isScramble("abcde", "caebd"));
  }


  public boolean isScramble(String s1, String s2) {
        if( s1.length() != s2.length() ) {
            return false;
        }
        boolean isScramble = false;
        int s = 0;
        for( int i = 0; i < s1.length(); i++  ) {
            int p1 = s;
            int p2 = i;
            boolean isSubStrSrcamble = true;
            while( p1 <= i && p2 >= s) {
                if( s1.charAt(p1) != s2.charAt(p2) ){
                    isSubStrSrcamble = false;
                    break;
                }
                p1++;
                p2--;
            }
            if( isSubStrSrcamble ) {
                s = i+1;
            }
            isScramble = isSubStrSrcamble;
        }

        return isScramble;
    }
  
}
