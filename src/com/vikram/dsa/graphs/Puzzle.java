package com.vikram.dsa.graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Puzzle {

  public static void main( String[] args ) {
    int[][] arr = {{4,1,2},{5,0,3}};
    Puzzle puzzle = new Puzzle();
    System.out.println(puzzle.slidingPuzzle(arr));
  }

  int[][] moves = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};
    public int slidingPuzzle(int[][] board) {
        String answer = "123450";
        StringBuilder sb = new StringBuilder();
        Set<String> visited = new HashSet<>();
        Queue<Pair> queue = new LinkedList<>();
        int zeroIndex = 0;
        for( int i = 0; i < 2; i++) {
            for( int j = 0; j < 3; j++ ){
                if( board[i][j] == 0 ) {
                    zeroIndex = i*3 + j%3;
                }
                sb.append(board[i][j]);
            }
        }
        String start = sb.toString();
        visited.add(start);
        queue.add( new Pair(start, zeroIndex, 0));
        while( !queue.isEmpty() ) {
            Pair p = queue.remove();
            String pattern = p.pattern;
            int pos = p.pos;
            int length = p.length;
            if( pattern.equals(answer) ) {
                return length;
            }
            int r = pos/3;
            int c = pos%3;
            for( int[] move: moves ) {
                int x = r + move[0];
                int y = c + move[1];
                if( x >= 0 && y >= 0 && x < 2 && y < 3  ) {
                    int newPos = x*3 + y%3;
                    char[] arr = pattern.toCharArray();
                    char temp = arr[newPos];
                    arr[newPos] = arr[pos];
                    arr[pos] = temp;
                    String newPattern = new String(arr);
                    if( !visited.contains(newPattern) ){
                        visited.add( newPattern );
                        queue.add( new Pair(newPattern, newPos, length+1));
                    }
                }
            }
        }

        return -1;
    }   

    class Pair {
        String pattern;
        int pos;
        int length;
        public Pair( String pattern, int pos, int length ) {
            this.pattern = pattern;
            this.pos = pos;
            this.length = length;
        }
    }
  
}
