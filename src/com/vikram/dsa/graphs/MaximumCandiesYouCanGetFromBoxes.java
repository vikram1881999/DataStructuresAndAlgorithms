package com.vikram.dsa.graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MaximumCandiesYouCanGetFromBoxes {

  public static void main( String[] args ) {
    int[] status = {1, 0, 1, 0};
    int[] candies = {7, 5, 4, 100};
    int[][] keys = {{},{},{1},{3}};
    int[][] containerBoxes = {{1,2},{3},{},{}};
    int[] initialBoxes = {0};
    MaximumCandiesYouCanGetFromBoxes maximumCandiesYouCanGetFromBoxes = new MaximumCandiesYouCanGetFromBoxes();
    System.out.println(maximumCandiesYouCanGetFromBoxes.maxCandies(status, candies, keys, containerBoxes, initialBoxes));
  }

  public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
    int totalCandies = 0;
    int n = status.length;
    boolean[] visited = new boolean[n];
    Queue<Integer> queue = new LinkedList<>();
    Set<Integer> openLock = new HashSet<>();
    Set<Integer> keySets[] = new HashSet[n];

    for( int i = 0; i < keys.length; i++ ) {
        if( keySets[i] == null ) {
            keySets[i] = new HashSet<>();
        }
        for( int key: keys[i] ) {
            keySets[i].add(key);
        }
    }
    for( int box: initialBoxes ) {
        if( status[box] == 1 ) {
            queue.add(box);
            visited[box] = true;
        }
    }

    while( !queue.isEmpty() ) {
        int currBox = queue.remove();
        totalCandies += candies[currBox];
        for( int key: keys[currBox] ) {
          if( openLock.contains(key) ) {
              visited[key] = true;
              queue.add(key);
              openLock.remove(key);
          }
      }

        for( int box: containedBoxes[currBox] ) {
            if( (status[box] == 1 || keySets[currBox].contains(box)) && !visited[box] ) {
                visited[box] = true;
                queue.add(box);
            }
            else if(  status[box] == 0 ) {
              openLock.add(box);
            }
        }
    }

    return totalCandies;

}
  
}
