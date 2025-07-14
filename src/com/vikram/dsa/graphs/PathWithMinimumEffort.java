package com.vikram.dsa.graphs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {

  public static void main( String[] args ) {
    PathWithMinimumEffort pathWithMinimumEffort = new PathWithMinimumEffort();
    int[][] arr = {
      {
        1,
        2,
        3
      },
      {
        3,
        8,
        4
      },
      {
        5,
        3,
        5
      }
    };
    System.out.println( pathWithMinimumEffort.minimumEffortPath(arr));
  }


  public static final int[][] moves = {{1,0}, {0, 1}, {-1, 0}, {0, -1}};
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] best = new int[n][m];
        for( int i = 0; i < n; i++ ) {
            Arrays.fill( best[i], Integer.MAX_VALUE );
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>( new Comparator<int[]>() {
          @Override
          public int compare(int[] o1, int[] o2) {
            return o1[2] - o2[2];
          }
        });

        minHeap.add( new int[]{ 0, 0, 0 });
        best[0][0] = 0;
        while( !minHeap.isEmpty() ) {
            int[] coords = minHeap.remove();
            int r = coords[0];
            int c = coords[1];
            int h = coords[2];
            if( h > best[r][c] ) {
                continue;
            }
            for( int[] move: moves ) {
                int x = move[0] + r;
                int y = move[1] + c;
                if( x >= 0 && y >= 0 && x < n && y < m  ) {
                    int diff = Math.abs( heights[r][c] - heights[x][y] );
                    diff = Math.max( diff, h);
                    if( diff < best[x][y] ) {
                        best[x][y] = diff;
                        minHeap.add( new int[] { x, y, diff } );
                    }
                }
            }
        }

        return best[n-1][m-1];
    }
  
}
