package com.vikram.dsa.arrays.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSort {

  public static void main( String[] args ) {

  }

  void topologicalSort( int[][] arr, int n ){
    List<Integer>[] adjList = new ArrayList[n+1];
    int[] dependency = new int[n+1];
    for( int i = 0; i < arr.length; i++ ) {
      int s = arr[i][0];
      int d = arr[i][1];
      if( adjList[s] == null ) {
        adjList[s] = new ArrayList<>();
      }
      adjList[s].add(d);
      dependency[d] += 1;
    }

    Queue<Integer> queue = new LinkedList<>();
    for( int i = 1; i < dependency.length; i++ ) {
      if( dependency[i] == 0 ) {
        queue.add(i);
      }
    }

    while( !queue.isEmpty() ) {
      int s = queue.remove();
      for( int i = 0; i < adjList[s].size(); i++ ) {
        int d = adjList[s].get(i);
        dependency[i] -= 1;
        if( dependency[i] == 0 ) {
          queue.add(d);
        }
      }
    }
  }
  
}
