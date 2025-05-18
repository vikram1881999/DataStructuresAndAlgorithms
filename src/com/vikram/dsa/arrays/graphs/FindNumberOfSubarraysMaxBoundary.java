package com.vikram.dsa.arrays.graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class FindNumberOfSubarraysMaxBoundary {
  public static void main( String[] args ) {
    FindNumberOfSubarraysMaxBoundary findNumberOfSubarraysMaxBoundary = new FindNumberOfSubarraysMaxBoundary();
    int[] arr = {1,4,3,3,2};
    System.out.println(findNumberOfSubarraysMaxBoundary.numberOfSubarray2(arr));
  }

  public long numberOfSubarrays(int[] nums) {
        int[] maxLeft = getMaxLeft( nums );
        boolean[] visited = new boolean[nums.length];
        int sum = 0;
        for( int i = nums.length-1; i >= 0; i--) {
            if( visited[i] == false ) {
                Stack<Integer> stack = new Stack<>();
                stack.add(i);
                visited[i] = true;
                while( true ) {
                    int j = stack.peek();
                    int ele = nums[j];
                    int k = maxLeft[j];
                    if( k == -1 || nums[k] != ele ) {
                        break;
                    }
                    stack.push(k);
                    visited[k]=  true;
                }
                int l = stack.size();
                sum = sum + ((l)*(l+1)/2);
            }
        }

        return sum;
    }


    public int[] getMaxLeft( int[] nums ){
        Stack<Integer> stack = new Stack<>();
        int maxLeft[] = new int[nums.length];
        for( int i = 0; i < nums.length; i++ ) {
            while( !stack.isEmpty() && nums[stack.peek()] < nums[i] ) {
                stack.pop();
            }
            if( stack.isEmpty() ) {
                maxLeft[i] = -1;
            }
            else {
                maxLeft[i] = stack.peek();
            }
            stack.push(i);
        }

        return maxLeft;
    }

    public long numberOfSubarray2(int[] nums) {
      Stack<Pair> stack = new Stack<>();
      long sum = 0;
      for( int i = 0; i < nums.length; i++ ) {
          while( !stack.isEmpty() && nums[stack.peek().index] < nums[i] ) {
              Pair p = stack.pop();
              sum = sum + (long)p.c*((long)p.c+1)/2;
          }
          if( stack.isEmpty() || nums[stack.peek().index] != nums[i]) {
              stack.push( new Pair(i, 1));
          }
          else {
             Pair p = stack.pop();
             stack.push( new Pair(i, p.c + 1));
          }
      }

      while( !stack.isEmpty() ) {
        Pair p = stack.pop();
        sum = sum + (long)p.c*((long)p.c+1)/2;
      }

      return sum;
  }
  
}

class Pair {
  int index;
  int c;
  public Pair( int index, int c) {
      this.index = index;
      this.c = c;
  }
}