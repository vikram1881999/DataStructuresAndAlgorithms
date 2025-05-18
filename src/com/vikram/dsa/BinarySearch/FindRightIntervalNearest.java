package com.vikram.dsa.BinarySearch;

import java.util.Stack;

public class FindRightIntervalNearest {

  public static void main( String[] args ) {
    int[][] intervals = {{1,2},{2,3},{0,1},{3,4}};
    FindRightIntervalNearest findRightInterval  = new FindRightIntervalNearest();
    System.out.println(findRightInterval.findRightInterval(intervals));
  }

  public int[] findRightInterval(int[][] intervals) {
        int[] maxLeft =getMaxIndexLeft(intervals);
        int[] maxRight = getMaxIndexRight(intervals);
        int[] ans = new int[intervals.length];
        for( int i = 0; i < intervals.length; i++ ) {
            int l = maxLeft[i];
            int r = maxRight[i];
            if( l == -1 ) {
                ans[i] = r;
            }
            else if( r == -1 ) {
                ans[i] = l;
            }
            else {
                ans[i] = i-l <= r-i ? l : r;
            }
        }

        return ans;
    }

    public int[] getMaxIndexLeft( int[][] intervals ) {
        int n = intervals.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];
        ans[0] = -1;
        stack.push(0);
        for( int i = 1; i < n; i++ ) {
            int s = intervals[i][0];
            int e = intervals[i][1];
            while( !stack.isEmpty() && intervals[stack.peek()][0] < e ) {
                stack.pop();
            }
            if( stack.isEmpty() ) {
                ans[i] = -1;
            }
            else {
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }

    public int[] getMaxIndexRight( int[][] intervals ) {
        int n = intervals.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];
        ans[n-1] = -1;
        stack.push(n-1);
        for( int i = n-2; i >= 0; i-- ) {
            int s = intervals[i][0];
            int e = intervals[i][1];
            while( !stack.isEmpty() && intervals[stack.peek()][0] < e ) {
                stack.pop();
            }
            if( stack.isEmpty() ) {
                ans[i] = -1;
            }
            else {
                ans[i] = stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }
  
}
