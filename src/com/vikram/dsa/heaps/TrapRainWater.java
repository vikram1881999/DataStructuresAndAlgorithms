package com.vikram.dsa.heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TrapRainWater {

  public static void main( String[] args ) {
    int[][] buildings = {{12,13,1,12}, {13,4,13,12}, {13,8,10,12}, {12,12,12,12}, {13,13,13,13}};
    TrapRainWater trapRainWater = new TrapRainWater();
    System.out.println( trapRainWater.trapRainWater(buildings));
  }

  static int[][] DIRS = {{-1, 0}, {0, -1}, {1,0}, {0, 1}};
    public int trapRainWater(int[][] heightMap) {
        int n = heightMap.length;
        int m = heightMap[0].length;
        boolean[][] visited = new boolean[n][m];
        int totalWater = 0;
        PriorityQueue<Cell> minHeap = new PriorityQueue<>( new Comparator<Cell>() {
            @Override
            public int compare( Cell a, Cell b ) {
                return a.height-b.height;
            }
        });
        for( int j = 0; j < m; j++ ) {
            Cell cell = new Cell( 0, j, heightMap[0][j]);
            Cell lowerCell = new Cell( n-1, j, heightMap[n-1][j]);
            minHeap.add(cell);
            minHeap.add(lowerCell);
            visited[0][j] = true;
            visited[n-1][j] = true;
        }
        for( int i = 0; i < n; i++ ) {
            minHeap.add( new Cell(i, 0, heightMap[i][0]));
            minHeap.add( new Cell(i, m-1, heightMap[i][m-1]));
            visited[i][0] = true;
            visited[i][m-1] = true;
        }
    
        while( !minHeap.isEmpty() ){
            Cell curr = minHeap.remove();
            int i = curr.x;
            int j = curr.y;
            for( int[] dir: DIRS ) {
                int x = dir[0] + i;
                int y = dir[1] + j;
                if( x >= 0 && y >= 0 && x < n && y < m && !visited[x][y] ) {
                    int waterTrapped = Math.max( 0, curr.height -  heightMap[x][y]);
                    totalWater += waterTrapped;
                    visited[x][y] = true;
                    minHeap.add( new Cell( x, y, Math.max(curr.height, heightMap[x][y])));
                }
            }
        }

        return totalWater;
    }
  
}

class Cell {
    int x;
    int y;
    int height;
    public Cell( int x, int y, int height ) {
        this.x = x;
        this.y = y;
        this.height = height;
    }
}