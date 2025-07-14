package com.vikram.dsa.graphs;

public class MaxAreaOfIsland {

  public static void main( String[] args ) {
    int[][] arr = {
      {
        0,
        0,
        1,
        0,
        0,
        0,
        0,
        1,
        0,
        0,
        0,
        0,
        0
      },
      {
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        1,
        1,
        1,
        0,
        0,
        0
      },
      {
        0,
        1,
        1,
        0,
        1,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0
      },
      {
        0,
        1,
        0,
        0,
        1,
        1,
        0,
        0,
        1,
        0,
        1,
        0,
        0
      },
      {
        0,
        1,
        0,
        0,
        1,
        1,
        0,
        0,
        1,
        1,
        1,
        0,
        0
      },
      {
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        1,
        0,
        0
      },
      {
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        1,
        1,
        1,
        0,
        0,
        0
      },
      {
        0,
        0,
        0,
        0,
        0,
        0,
        0,
        1,
        1,
        0,
        0,
        0,
        0
      }
    };

    MaxAreaOfIsland areaOfIsland = new MaxAreaOfIsland();
    System.out.println( areaOfIsland.maxAreaOfIsland(arr) );
  }


  int[][] moves = {{ 0, -1 }, { -1, 0 }, { 1, 0 }, { 0, 1 }};
    public int maxAreaOfIsland(int[][] grid) {
        int l = 0;
        int n =  grid.length;
        int m = grid[0].length;
        for( int i = 0; i < n; i++) {
            for( int j = 0; j < m; j++ ) {
                if( grid[i][j] == 1 ) {
                    l = Math.max( l, dfs( grid, i, j, n, m ) );
                }
            }
        }
        return l;
    }

    private int dfs( int[][] grid, int i, int j, int n, int m ) {
        int l = 1;
        grid[i][j] = 0;
        for( int[] move: moves ) {
            int r = i + move[0];
            int c = j + move[1];
            if( r >= 0 && c >= 0 && r < n && c < m && grid[r][c] == 1 ) {
                l = l + dfs( grid, r, c, n, m );
            }
        }

        return l;
    }
}
