package com.vikram.dsa.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class LastDayWhereYouCanStillCross {

  public static void main( String[] args ) {
    LastDayWhereYouCanStillCross canStillCross = new LastDayWhereYouCanStillCross();
    int[][] arr = {{1,2},{2,1},{3,3},{2,2},{1,1},{1,3},{2,3},{3,2},{3,1}};
    System.out.println(canStillCross.latestDayToCross(3, 3, arr));
  }

  int[][] moves = {{0,1}, {0, -1}, {-1, 0}, { 1, 0 }};
    public int latestDayToCross(int row, int col, int[][] cells) {
        int l = 1;
        int h = cells.length;
        int ans = 0;
        while( l <= h ) {
            int m = (l+h)/2;
            if( canCross(row, col, cells, m) ) {
                ans = m;
                l = m+1;
            }
            else {
                h = m-1;
            }
        }

        return ans;

    }

    private boolean canCross( int row, int col, int[][] cells, int k ) {
        int[][] island = new int[row+1][col+1];
        Queue<int[]> queue = new LinkedList<>();
        for( int i = 1; i <= k; i++ ) {
            int[] cell = cells[i-1];
            int x = cell[0];
            int y = cell[1];
            island[x][y] = 1;
        }
        for( int i = 1; i <= col; i++ ) {
            if( island[1][i] != 1 ) {
                int[] cord = { 1, i };
                queue.add(cord);
            }
        }

        while( !queue.isEmpty() ){
            int[] coord = queue.remove();
            int i = coord[0];
            int j = coord[1];
            if( i == row ) {
                return true;
            }
            for( int[] move: moves ) {
                int x = i + move[0];
                int y = j + move[1];
                if( x >= 1 && y>= 1 && x <= row && y <= col && island[x][y] != 1 ) {
                    island[x][y] = 1;
                    int[] destCord = { x, y };
                    queue.add(destCord);
                }
            }
        }

        return false;
    }
  
}
