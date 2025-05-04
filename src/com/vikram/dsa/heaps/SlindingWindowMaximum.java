package com.vikram.dsa.heaps;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlindingWindowMaximum {

  public static void main( String[] args ) {
    SlindingWindowMaximum maximum = new SlindingWindowMaximum();
    int[] arr = {1,3,1,2,0,5};
    System.out.println(maximum.maxSlidingWindow(arr, 3));
  }

  public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length-k+1];
        Deque<Integer> deque = new ArrayDeque<>();
        for( int i = 0; i < k; i++ ) {
            while( !deque.isEmpty() && deque.peekLast() < nums[i] ) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }

        ans[0] = deque.peekFirst();

        for( int i = 1; i <= nums.length-k; i++ ) {
            if( !deque.isEmpty() && nums[i-1] == deque.peekFirst() ) {
                deque.removeFirst();
            }
            while( !deque.isEmpty() && deque.peekLast() < nums[i+k-1] ) {
                deque.removeLast();
            }
            deque.addLast(nums[i+k-1]);
            ans[i] = deque.peekFirst();
        }

        return ans;
    }
  
}
