package com.vikram.dsa.arrays;

public class SeparateBlackAndWhiteBalls {

  public static void main( String[] args ) {
    SeparateBlackAndWhiteBalls blackAndWhiteBalls = new SeparateBlackAndWhiteBalls();
    System.out.println(blackAndWhiteBalls.minimumSteps("010010100101001010"));
  }


  public long minimumSteps(String s) {
    char[] chars = s.toCharArray();
        long steps = 0;
        int i = 0;
        int j = 0;
        int k = 0;
        while( k < s.length() ) {
            if( chars[j] == '0' && chars[i] == '0' ) {
                i++;
                j++;
            }
            else if( chars[i] == '1' && chars[j] == '1') {
                j++;
            }
            else if( chars[j] == '0' && chars[i] == '1') {
                char temp = chars[j];
                chars[j] = chars[i];
                chars[i] = temp;
                steps++;
                i++;
                j++;
            }
            k++;
        }

        return steps;
  }
  
}
