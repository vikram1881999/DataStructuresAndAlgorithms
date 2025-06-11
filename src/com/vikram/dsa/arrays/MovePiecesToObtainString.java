package com.vikram.dsa.arrays;

public class MovePiecesToObtainString {

  public static void main( String[] args ) {
    MovePiecesToObtainString movePiecesToObtainString  =new MovePiecesToObtainString();
    System.out.println( movePiecesToObtainString.canChange("_L", "LR"));
  }

  public boolean canChange(String start, String target) {
    int n = start.length();
    int i = 0;
    int j = 0;
    while( i < n || j < n ) {
        while( i < n && start.charAt(i) == '_') {
            i++;
        }
        while( j < n && target.charAt(j) == '_') {
            j++;
        }
        if( i == n && j == n ) {
            return true;
        }
        if( i == n || j == n ) {
            return false;
        }

        if( start.charAt(i) != target.charAt(j)  || (start.charAt(i) == 'L' &&  i < j)  || (start.charAt(i) =='R'  && i > j) ) {
            return false;
        } 

        i++;
        j++;
    }


    return true;
}
  
}
