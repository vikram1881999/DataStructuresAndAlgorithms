package com.vikram.dsa.dynamicprogramming;

public class ArithmeticSlices {

  public static void main( String[] args ) {

    ArithmeticSlices arithmeticSlices  = new ArithmeticSlices();
    int[] num = {1,2,3,4,5};
    System.out.println(arithmeticSlices.numberOfArithmeticSlices(num));
  }

  public int numberOfArithmeticSlices(int[] nums) {
    int totalSum = 0;
    int count = 0;
    int diff = Integer.MIN_VALUE;
    for( int i = 1; i < nums.length; i++ ){
        if( nums[i] - nums[i-1] != diff ) {
            count = 1;
            diff = nums[i] - nums[i-1];
        }
        else if(  nums[i] - nums[i-1] == diff ) {
            count++;
        }
        if( count >= 2 ) {
          if( count >= 3 ) {
              totalSum += 2;
          }
          else {
              totalSum += 1;
          }
      }
    }

    return totalSum;
}
  
}
