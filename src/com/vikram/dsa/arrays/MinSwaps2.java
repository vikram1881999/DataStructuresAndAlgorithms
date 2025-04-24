package com.vikram.dsa.arrays;

import javax.sound.midi.SysexMessage;

/*
 * Given an array of integers A of size N that is a permutation of [0, 1, 2, ..., (N-1)].
 * It is allowed to swap any two elements (not necessarily consecutive).
 * Find the minimum number of swaps required to sort the array in ascending order.
 * 
 */
public class MinSwaps2 {

  public static void main(String[] args) {
    int[] arr = { 2,0,1,3};
    MinSwaps2 minSwaps2 = new MinSwaps2();
    System.out.println(minSwaps2.getMinSwaps(arr));
  }

  public int getMinSwaps(int[] arr) {
    int swaps = 0;
    for( int i = 0; i < arr.length; i++ ) {
      if( arr[i] == i ) {
        continue;
      }
      else {
        int temp = arr[arr[i]];
        arr[arr[i]] = arr[i];
        arr[i] = temp;
        i--;
        swaps++;
      }
    }
    return swaps;
  }
  
}
