package com.vikram.dsa.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class BridgeLength {

  public static void main( String[] args ) {
    int[][] arr = {
      {
        1,
        1,
        1,
        1,
        1
      },
      {
        1,
        0,
        0,
        0,
        1
      },
      {
        1,
        0,
        1,
        0,
        1
      },
      {
        1,
        0,
        0,
        0,
        1
      },
      {
        1,
        1,
        1,
        1,
        1
      }
    };
    BridgeLength bridgeLength = new BridgeLength();
    System.out.println( bridgeLength.shortestBridge(arr) );
  }

   int[][] moves = {{ 0,1 }, {1, 0}, {-1, 0}, { 0, -1 }};
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        int islandCount = 0;
        for( int i = 0; i< n; i++ ) {
            if( islandCount == 1) {
              break;
            }
            for( int j = 0; j < m; j++ ) {
                if( grid[i][j] == 1 ) {
                  islandCount++;
                  island( visited, grid, queue, i, j, n, m );
                  break;
                }
            }
        }
        int bridgeLength = 0;
        while( !queue.isEmpty() ) {
            int size = queue.size();
            for( int i = 0; i < size; i++ ) {
                int[] coords = queue.remove();
                int r = coords[0];
                int c = coords[1];
                for( int[] move: moves ) {
                    int x = move[0] + r;
                    int y = move[1] + c;
                    if( x >= 0 && y >= 0 && x < n && y < m && !visited[x][y] ) {
                        visited[x][y] = true;
                        if( grid[x][y] == 1 ) {
                            return bridgeLength;
                        }
                        grid[x][y] = 1;
                        queue.add( new int[]{x, y});
                    } 
                }
            }
            bridgeLength++;
        }

        return 0;
    }

    private void island(  boolean[][] visited, int[][] grid, Queue<int[]> queue, int i, int j, int n, int m ) {
        visited[i][j] = true;
        queue.add( new int[]{i, j});
        for( int[] move: moves ) {
            int x = i + move[0];
            int y = j + move[1];
            if( x >= 0 && y >= 0 && x < n && y < m && grid[x][y] == 1 && !visited[x][y]) {
                island( visited, grid, queue, x, y, n , m);
            }
        }
    }
  
}
