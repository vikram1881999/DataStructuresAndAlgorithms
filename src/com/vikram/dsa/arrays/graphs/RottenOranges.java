package com.vikram.dsa.arrays.graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 0 - Empty cell
 * 1 - fresh Orange
 * 2 - rotten orange present
 * 
 * Every minute any fresh orange adjacent to a rotten orange becomes rottenm find the min time, when all the oranges become rotten
 * if not possible return -1;
 */
public class RottenOranges {

  public static void main( String[] args ) {
    int[][] arr = {{1,0,1,2,1}, {1,1,1,1,1}, {0,2,0,1,0}, {0,1,1,1,1}, {1,1,1,2,1}};
    RottenOranges oranges = new RottenOranges();
    System.out.println(oranges.timeTaken(arr));
  }

  public int timeTaken( int[][] arr ) {
    int timeTaken = -1;
    Queue<Pair> queue = new LinkedList<>();
    for( int i = 0; i < arr.length; i++ ){
      for( int j = 0; j < arr[i].length; j++ ) {
        if( arr[i][j]  ==  2) {
          Pair pair = new Pair(i, j);
          queue.add(pair);
        } 
      }
    }

    while( !queue.isEmpty() ) {
      Pair pair = queue.remove();
      int i = pair.x;
      int j = pair.y;
      if( j > 0 && arr[i][j-1] == 1 ) {
        arr[i][j-1] = arr[i][j] + 1;
        queue.add( new Pair(i, j-1));
      }
      if( j < arr[i].length-1 && arr[i][j+1] == 1 ) {
        arr[i][j+1] = arr[i][j] + 1;
        queue.add(new Pair(i, j+1));
      }
      if( i > 0 && arr[i-1][j] == 1 ) {
        arr[i-1][j] = arr[i][j] + 1;
        queue.add(new Pair(i-1, j));
      }
      if( i < arr.length-1 && arr[i+1][j] == 1 ) {
        arr[i+1][j] = arr[i][j] + 1;
        queue.add(new Pair(i+1, j));
      }
    }

    for( int i = 0; i < arr.length; i++ ) {
      for( int j = 0; j < arr[i].length; j++ ) {
        if( arr[i][j] == 1 ) {
          return -1;
        }
        timeTaken = Math.max(timeTaken, arr[i][j]);
      }
    }

    return timeTaken - 2;
  }
  
  private class Pair {
    public int x;
    public int y;
    Pair( int x, int y) {
      this.x = x;
      this.y = y;
    }
  } 
}
