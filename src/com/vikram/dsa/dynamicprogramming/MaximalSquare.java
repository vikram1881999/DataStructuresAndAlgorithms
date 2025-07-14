package com.vikram.dsa.dynamicprogramming;

public class MaximalSquare {

  public static void main( String[] args ) {
    char[][] chars= {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
    MaximalSquare maximalSquare  =new MaximalSquare();
    System.out.println(maximalSquare.maximalSquare(chars)); 
  }


  public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] pf = new int[n][m];
        for( int i = 0; i < n; i++ ) {
            for( int j = 0; j < m; j++ ) {
                int val = matrix[i][j] == '1' ? 1: 0;
                if( j == 0 ) {
                    pf[i][j] = val;
                    continue;
                }
                pf[i][j] = pf[i][j-1] + val;
            } 
        }

        for( int j = 0; j < m; j++ ) {
            for( int i = 0; i < n; i++) {
                if( i == 0 ) {
                    continue;
                }
                pf[i][j] += pf[i-1][j];
            }
        }


        int l = 1;
        int h = Math.min(n, m);
        while( l <= h ) {
            int mid = (l+h)/2;
            if( squareExits( pf, mid) ) {
                l = mid+1;
            }
            else {
                h = mid-1;
            }
        }

        return h*h;
    }

  private boolean squareExits(int[][] pf, int mid) {
    int n = pf.length;
    int m = pf[0].length;
    for( int i = 0; i < n-mid+1; i++ ) {
      for( int j = 0; j < m-mid+1; j++ ){
        int area = pf[i+mid-1][j+mid-1];
        if( j != 0 ) {
          area -= pf[i+mid-1][j-1];
        }
        if(  i != 0 ) {
          area -= pf[i-1][j+mid-1];
        }
        if( j != 0 && i != 0 ) {
          area += pf[i-1][j-1];
        }

        if( area  ==  mid*mid ) {
          return true;
        }
      }
    }

    return false;
  }
  
}
