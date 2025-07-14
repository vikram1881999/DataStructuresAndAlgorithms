package com.vikram.dsa.graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SnakesAndLadders {

  public static void main( String[] args ) {
    int[][] arr = {{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}};
    SnakesAndLadders snakesAndLadders = new SnakesAndLadders();
    System.out.println(snakesAndLadders.snakesAndLadders(arr));
  }

   public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<Pair> queue = new LinkedList<>();
        queue.add( new Pair( 1, 0 ));
        Set<Integer> visited = new HashSet<>();
        visited.add(1);
        while( !queue.isEmpty() ) {
            Pair pair = queue.remove();
            int pos = pair.num;
            for( int i = 1; i <= 6; i++ ) {
                int newPos = Math.min( pos+i, n*n);
                int[] cords = getRowCol(newPos-1, n);
                int r = cords[0];
                int c = cords[1];
                if( board[r][c] != -1 ){
                    newPos = board[r][c];
                }
                if( newPos == n*n ) {
                    return pair.distance + 1;
                }
                if( !visited.contains(newPos) ) {
                    visited.add(newPos);
                    queue.add( new Pair(newPos, pair.distance+1));
                }
               
            }
        }

        return -1;
    }

    private int[] getRowCol(int num, int n) {
      int r = n - 1 - num/n;
      int c = num % n;
      if (((n - 1 - r) % 2) == 1) {
        c = n - 1 - c;
      }
      return new int[]{r, c};
    }

    private class Pair {
        int num;
        int distance;

        public Pair( int num, int distance ) {
            this.num = num;
            this.distance = distance;
        }
    }
  
}
