package com.vikram.dsa.arrays;

import java.util.Arrays;

public class AddOneToTheNumber {

  public static void main(String args[] ) {
    int[] arr = { 0,3,7,6,4,0,5,5,5};
    int[] arr2 = {1,2,9};
    int[] arr3 = {9,9,9};
    AddOneToTheNumber addOneToTheNumber = new AddOneToTheNumber();
    System.out.println( Arrays.toString(addOneToTheNumber.addOne(arr)));
    System.out.println( Arrays.toString(addOneToTheNumber.addOne(arr2)));
    System.out.println( Arrays.toString(addOneToTheNumber.addOne(arr3)));
  }  

  public int[] addOne(int[] arr) {
    int cf = 0;
    arr = lStripZero(arr);
    if( arr.length == 0 ) {
      int[] array = {1};
      return array;
    }
    int n = arr.length;
    for( int i = n-1; i >=0; i-- ) {
      int sum = arr[i] + cf;
      if( i == n-1 ) {
        sum += 1;
      }
      cf = sum/10;
      arr[i] = sum%10;
    }
    if( cf > 0  ){
      int[] newArr = new int[n+1];
      newArr[0] = cf;
      for( int i = 1; i < newArr.length; i++ ) {
        newArr[i] = arr[i-1];
      }
      return newArr;
    }

    return arr;
  }

  private int[] lStripZero(int[] arr ) {
    int c = 0;
    for( int i = 0; i < arr.length; i++ ) {
      if( arr[i] == 0 ) {
        c++;
      }
      else {
        break;
      }
    }
    int[] newArr = new int[arr.length - c];
    for( int i = 0; i < newArr.length; i++ ) {
      newArr[i] = arr[i+c];
    }

    return newArr;
  }
}
