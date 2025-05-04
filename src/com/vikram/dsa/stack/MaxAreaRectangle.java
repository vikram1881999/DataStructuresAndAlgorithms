package com.vikram.dsa.stack;

import java.util.Stack;

public class MaxAreaRectangle {

  public static void main( String[] args ) {
    char[][] matrix = {{'1','0','1','0','0'}, {'1','0','1','1','1'}, {'1','1','1','1','1'}, {'1','0','0','1','0'} };
    MaxAreaRectangle areaRectangle = new MaxAreaRectangle();
    System.out.println(areaRectangle.maximalRectangle(matrix));
  }


  public int maximalRectangle(char[][] matrix) {
        if( matrix == null || matrix.length <= 0) {
            return 0;
        }
        int[][] pf = new int[matrix.length][matrix[0].length];
        for( int j = 0; j < matrix[0].length; j++ ) {
            for( int i = 0; i < matrix.length; i++ ) {
                if( i == 0 || matrix[i][j] == '0'  ) {
                    pf[i][j] =  matrix[i][j] - '0';
                }
                else {
                    pf[i][j] = pf[i-1][j] + matrix[i][j] - '0';
                }
            }
        }
        int ans = 0;
        for( int i = 0; i < matrix.length; i++ ) {
            ans = Math.max( maxAreaRow(pf[i]), ans);
        }

        return ans;
    }

    private int maxAreaRow( int[] arr ) {
        int[] left = smallerOnLeft( arr );
        int[] right = smallerOnRight(arr);
        int ans = 0;
        for( int i = 0; i < arr.length; i++ ) {
            int p1 = left[i];
            int p2 = right[i];
            int area = (p2-p1-1)*arr[i];
            ans = Math.max(area, ans );
        }
        return ans;
    }

    private int[] smallerOnLeft( int[] arr ) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[arr.length];
        for( int i = 0; i < arr.length; i++ ) {
            while( !stack.isEmpty() && arr[stack.peek()] >= arr[i] ) {
                stack.pop();
            }
            if( stack.isEmpty()) {
                ans[i] = -1;
            }
            else {
                ans[i] = stack.peek();
            }
            stack.push(i);
        }

        return ans;
    }

    private int[] smallerOnRight( int[] arr ) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[arr.length];
        for( int i = arr.length -1; i >= 0; i-- ) {
            while( !stack.isEmpty() && arr[stack.peek()] >= arr[i] ) {
                stack.pop();
            }
            if( stack.isEmpty()) {
                ans[i] = arr.length;
            }
            else {
                ans[i] = stack.peek();
            }
            stack.push(i);
        }

        return ans;
    }
  
}
