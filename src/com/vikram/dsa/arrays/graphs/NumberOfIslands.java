package com.vikram.dsa.arrays.graphs;

public class NumberOfIslands {

  public static void main( String[] args ) {
    NumberOfIslands n = new NumberOfIslands();
    int[][] mat = {{1,1,0,0,1},{0,1,0,1,0}, {1,0,0,1,1}, {1,1,0,0,0}, {1,0,1,1,1} };
    System.out.println(n.countConnectedIslands(mat));
  }

  public int countConnectedIslands( int[][] mat ) {
    int count = 0;
    int n = mat.length;
    int m = mat[0].length;
    for( int i = 0; i < n; i++ ) {
      for( int j = 0; j < m; j++ ) {
        if( mat[i][j] == 1 ) {
          dfs( mat, i, j );
          count++;
        }
      }
    }
    return count;
  }

  public void dfs( int[][] mat, int i, int j ) {
    if( i < 0 || j < 0 || i >= mat.length || j >= mat[0].length || mat[i][j] == 0 ) {
      return;
    }
    mat[i][j] = 0;
    dfs( mat, i-1, j );
    dfs( mat, i+1, j);
    dfs( mat, i, j+1);
    dfs( mat, i, j-1);
  }
  
}
