package com.vikram.dsa.arrays.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BiPartieGraph {
  
  public static void main( String[] args ) {
    BiPartieGraph biPartieGraph = new BiPartieGraph();

  }

  public boolean biPartie( int n, int e, int[] u, int[] v ) {
    List<Integer>[] adjList = new ArrayList[n+1];
    int[] color = new int[n+1];
    Queue<Integer> queue = new LinkedList<>();

    for( int i = 0; i < u.length; i++ ) {
      int s = u[i];
      int d = v[i];
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
    color[1] = 1;
    while( !queue.isEmpty() ) {
      int s = queue.remove();
      for( int i = 0; i < adjList[s].size(); i++ ) {
        int node = adjList[s].get(i);
        if( color[node] == 0 ) {
          color[node] = 3 - color[s];
          queue.add(node);
        }
        else if( color[node] == color[s] ){
          return false;
        }
      }
    }

    return true;
  }

}
