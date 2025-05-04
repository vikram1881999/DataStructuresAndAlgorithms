package com.vikram.dsa.stack;

import java.util.Stack;

public class MaxChunksToMakeSorted {

  public static void main(String[] args ) {
    MaxChunksToMakeSorted  chunksToMakeSorted = new MaxChunksToMakeSorted();
    int[] arr = { 0,2,1,4,3 };
    System.out.println( chunksToMakeSorted.maxChunksToSorted(arr));
  }


  public int maxChunksToSorted(int[] arr) {
        int countChunks = 0;

        int[] smallerIndexLeft = getSmallerLeft( arr );
        int[] largerIndexRight = getLargerRight( arr );
        for( int i = 0; i < arr.length; i++ ) {
            int small = smallerIndexLeft[i] + 1;
            int large = largerIndexRight[i] - 1;
            if( small == large && arr[i] == small ) {
                countChunks++;
            }
            else if( i == 0 && small != large ) {
                countChunks++;
            }
            else if( i > 0 && small != large ) {
                int prevSmall = smallerIndexLeft[i-1] + 1;
                int prevLarge = largerIndexRight[i-1] - 1;
                if( prevSmall == prevLarge ) {
                    countChunks++;
                }
            }
           
        }    

        return countChunks;

    }

    private int[] getSmallerLeft( int[] arr ) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[arr.length];
        for( int i = 0; i < arr.length; i++) {
            while( !stack.isEmpty() && arr[stack.peek()] >= arr[i] ) {
                stack.pop();
            }
            if( stack.isEmpty() ) {
                ans[i] = -1;
            }
            else {
                ans[i]= stack.peek();
            }
            stack.push(i);
        }

        return ans;
    }

    private int[] getLargerRight( int[] arr ) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[arr.length];
        for( int i = arr.length-1; i >= 0; i--) {
            while( !stack.isEmpty() && arr[stack.peek()] <= arr[i] ) {
                stack.pop();
            }
            if( stack.isEmpty() ) {
                ans[i] = arr.length;
            }
            else {
                ans[i]= stack.peek();
            }
            stack.push(i);
        }

        return ans;
    }
  
}
