package com.vikram.dsa.stack;

import java.util.Stack;

public class UnsortedContinousSubarray {

  public static void main( String[] args  ){
    UnsortedContinousSubarray continousSubarray  =new UnsortedContinousSubarray();
    int[] num = {1,2,3,4};
    System.out.println( continousSubarray.findUnsortedSubarray(num));
  }

  public int findUnsortedSubarray(int[] nums) {
        int start = nums.length;
        int end = -1;
        int[] minLeft = firstSmallerLeft(nums);
        int[] maxRight = firstLargerOnRight(nums);
        for( int i = 0; i < nums.length; i++ ) {
          int index = minLeft[i];
          if( index + 1 != i ) {
            start = Math.min(index + 1, start);
          }
        }
        for( int i = nums.length-1; i >= 0 ; i-- ) {
          int index = maxRight[i];
          if( index - 1 != i ) {
            end = Math.max(end, index-1);
          }
        }
        if( start == nums.length || end == -1 ) {
          return nums.length;
        }
        return end - start + 1;
    }

    public int[] firstSmallerLeft( int[] arr  ){
      int[] ans = new int[arr.length];
      Stack<Integer> minStack = new Stack<>();

      for( int i = 0; i < arr.length; i++ ) {
        while( !minStack.isEmpty() && arr[minStack.peek()] > arr[i] ) {
          minStack.pop();
        }
        if( minStack.isEmpty() ) {
          ans[i] = -1;
        }
        else {
          ans[i] = minStack.peek();
        }
        minStack.push(i);
      }

      return ans;
    } 

    public int[] firstLargerOnRight( int[] arr ) {
      int[] ans = new int[arr.length];
      Stack<Integer> maxStack = new Stack<>();
      for( int i = arr.length-1; i >= 0 ; i-- ) {
        while( !maxStack.isEmpty() && arr[maxStack.peek()] < arr[i]) {
          maxStack.pop();
        }
        if( maxStack.isEmpty() ) {
          ans[i] = arr.length;
        }
        else {
          ans[i] = maxStack.peek();
        }
        maxStack.push(i);
      }

      return ans;
    }
  
}
