package com.vikram.dsa.arrays;

public class FindFirstMissingInteger {

  public static void main(String[] args ) {
    int[] arr = { 8,1,2,3,4,5,6,7};
    FindFirstMissingInteger findFirstMissingInteger  = new FindFirstMissingInteger();
    System.out.println(findFirstMissingInteger.findFirstMissingInteger(arr));
  }

  public int findFirstMissingInteger(int[] arr) {
    for( int i = 0; i < arr.length; i++ ) {
      if( arr[i] < 1 || arr[i] > arr.length || arr[i] == i+1 || arr[arr[i]-1] == arr[i] ) {
        continue;
      }
      int temp = arr[arr[i]-1];
      arr[arr[i]-1] = arr[i];
      arr[i] = temp;
      i--;;
    }

    for( int i = 0; i < arr.length; i++ ) {
      if( arr[i] != i+1 ) {
        return i+1;
      }
    }

    return arr.length + 1;
  }
  
}
