package com.vikram.dsa.graphs;

public class NumberOfIncreasingPaths {

  public static void main( String[] args ) {
    NumberOfIncreasingPaths numberOfIncreasingPaths = new NumberOfIncreasingPaths();
    int[][] arr = {{1,1}, {3,4}};
    System.out.println( numberOfIncreasingPaths.countPaths(arr) );
  }


  int[][] moves = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
    public int countPaths(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int sum = 0;
        for( int i = 0; i < n; i++ ) {
            for( int j = 0; j < m; j++ ) {
                boolean[][] visited = new boolean[n][m];
                sum += countPaths( grid, n, m, i, j, visited );
            }
        }

        return sum;
    }

    private int countPaths( int[][] grid, int n, int m, int i, int j, boolean[][] visited ) {
        int step = 1;
        visited[i][j] = true;
        for( int[] move: moves ) {
            int r = i + move[0];
            int c = j + move[1];
            if( r >= 0 && c >= 0 &&  r < n && c < m && !visited[r][c] && grid[r][c] > grid[i][j]) {
                step += countPaths( grid, n, m, r, c, visited );
            }
        }

        return step;
    }
  
}
