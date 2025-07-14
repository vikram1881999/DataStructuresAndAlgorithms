package com.vikram.dsa.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MapOfHighestPeak {

  public static void main( String[] args ) {
    MapOfHighestPeak highestPeak = new MapOfHighestPeak();
    int[][] arr = {{0, 1}, {0, 0}};
    System.out.println( Arrays.deepToString(highestPeak.highestPeak(arr)) );
  }

   public static int[][] moves = {{1,0}, {0, 1}, {0, -1}, {-1, 0}} ;
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length;
        int m = isWater[0].length;
        int ans = 0;
        Queue<int[]> queue = new LinkedList<>();
        for( int i = 0; i < n; i++ ) {
            for( int j = 0; j < m; j++ ) {
                if( isWater[i][j] == 1 ) {
                    queue.add( new int[]{i, j});
                }
            }
        }

        while( !queue.isEmpty() ) {
            int[] coords = queue.remove();
            int r = coords[0];
            int c = coords[1];
            ans = Math.max(ans, isWater[r][c]);
            for( int[] move: moves ) {
                int x = r + move[0];
                int y = c + move[1];
                if( x >= 0 && y >= 0 && x < n && y < m && isWater[x][y] == 0 ) {
                    isWater[x][y] = isWater[r][c] + 1;
                    queue.add( new int[]{x,y});
                }
            }
        }

        for( int i = 0; i < n; i++ ) {
            for( int j = 0; j < m; j++ ) {
                isWater[i][j] -= 1;
            }
        }

        return isWater;

    }  

  
}
