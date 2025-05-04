package com.vikram.dsa.stack;

import java.util.Stack;

public class Find132Pattern {

  public static void main( String[] args  ){
    Find132Pattern find132Pattern = new  Find132Pattern();
    int[] arr = {1,0,1,-4,-3};
    System.out.println(find132Pattern.find132pattern(arr));
  }
  public boolean find132pattern(int[] nums) {
        int[] smallLeft = smallestLeft(nums);
        Stack<Integer> stack = new Stack<>();
        stack.push(nums[0]);
        for( int i = 1; i < nums.length; i++ ) {
           while( !stack.empty() && stack.peek() <= nums[i] ) {
                stack.pop();
            } 
            if( !stack.isEmpty() && nums[i] < stack.peek() && smallLeft[i] < stack.peek() && nums[i] > smallLeft[i] ) {
                return true;
            }
            stack.push(nums[i]);
        }

        return false;
    }

    public int[] smallestLeft( int[] arr ) {
        int[] ans = new int[arr.length];
        int min = Integer.MAX_VALUE;
        for( int i = 0; i < arr.length; i++ ) {
            min = Math.min( arr[i], min );
            ans[i] = min;
        }
        return ans;
    }
  
}
