package com.vikram.dsa.arrays.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AddEdgeTreeBipartie {

  public static void main( String[] args ) {

  }

  public int addBiPartie(int[][] arr, int n) {
    List<Integer>[] adjList = new ArrayList[n+1];
    Queue<Integer> queue = new LinkedList<>();
    int[] colors = new int[n+1];

    for( int i = 0; i < arr.length; i++ ) {
      int s = arr[i][0];
      int d = arr[i][1];
      if( adjList[s] == null ) {
        adjList[s] = new ArrayList<>();
      }
      if( adjList[d] == null ) {
        adjList[d] = new ArrayList<>();
      }
      adjList[s].add(d);
      adjList[d].add(s);
    }

    queue.add(1);
    colors[1] = 1;
    while( !queue.isEmpty() ) {
      int s = queue.remove();
      for( int i = 0; i < adjList[s].size(); i++ ) {
        int node = adjList[s].get(i);
        if( colors[node] == 0 ) {
          colors[node] = 3 - colors[s];
          queue.add(node);
        }
      }
    }

    int g = 0;
    int b = 0;
    for( int i = 1; i < colors.length; i++  ){
      if( colors[i] == 1 ) {
        g++;
      }
      else {
        b++;
      }
    }

    return b * g - arr.length;
  }
  
}
