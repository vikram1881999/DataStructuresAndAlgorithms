package com.vikram.dsa.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class AsForLandAsPossible {

  public static void main( String[] args) {
    AsForLandAsPossible asForLandAsPossible = new AsForLandAsPossible();
    int[][] arr = {{1,0,1},{0,0,0},{1,0,1}}; 
    System.out.println( asForLandAsPossible.maxDistance(arr) );
  }

   int[][] coords = {{0,1}, {0,-1}, {1, 0}, {-1, 0}};
    public int maxDistance(int[][] grid) {
        int dist = 0;
        int n = grid.length;
        int m = grid[0].length;

        Queue<String> queue = new LinkedList<>();
        for( int i = 0; i < n; i++ ) {
            for( int j = 0; j < m; j++ ) {
                if( grid[i][j] == 1 ) {
                    queue.add(i + "_" + j);
                }
            }
        }

        while( !queue.isEmpty() ) {
            String coordinates = queue.remove();
            String[] coordinate = coordinates.split("_");
            int i = Integer.parseInt(coordinate[0]);
            int j = Integer.parseInt(coordinate[1]);
            for( int[] coord: coords ) {
                int x = i + coord[0];
                int y = j + coord[1];
                if( x >= 0 && y >= 0 && x < n &&  y < m && grid[x][y] == 0 ) {
                    grid[x][y] = grid[i][j] + 1;
                    queue.add( x + "_" + y );
                }
            }
        }

        for( int i = 0; i < n; i++ ) {
            for( int j = 0; j < m; j++ ){
                dist = Math.max( dist, grid[i][j]-1);
            }
        }

        return dist;
    }
  
}
