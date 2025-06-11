package com.vikram.dsa.arrays;

public class MakeStringASubsequenceUsingCyclicIncrement {


  public static void main( String[] args ) {
    MakeStringASubsequenceUsingCyclicIncrement cyclicIncrement = new MakeStringASubsequenceUsingCyclicIncrement();
    System.out.println(cyclicIncrement.canMakeSubsequence("abc", "ad"));
  }


  public boolean canMakeSubsequence(String str1, String str2) {
    int j = 0;
    int n = str1.length();
    int m = str2.length();
    for( int i = 0; i < n; i++ ) {
        int val1 = (str2.charAt(j) - 'a')%26;
        int val2 = (str1.charAt(i) - 'a' + 1)%26;
        if( str1.charAt(i) == str2.charAt(j) || ( val1 == val2 ) ) {
            j++;
        }
        if( j == m ) {
            return true;
        }
    }

    return false;
}
  
}
