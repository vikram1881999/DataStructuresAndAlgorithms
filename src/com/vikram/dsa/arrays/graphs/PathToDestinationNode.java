package com.vikram.dsa.arrays.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PathToDestinationNode {

  public static void main( String[] args  ) {

    PathToDestinationNode pathToDestinationNode = new PathToDestinationNode();
    int[][] arr  = { {1,2}, {1,4}, {2,4}, {2,3}, {3,5}, {5,6}, {4,5}};
    System.out.println(pathToDestinationNode.pathToDestination(arr, 6, 1, 6));
  
  }

  public List<Integer> pathToDestination( int[][] arr, int nodes, int from, int to ) {
    List<Integer>[] adjList = new ArrayList[nodes+1];
    int[] parentArray = new int[nodes+1];
    boolean[] visited = new boolean[nodes+1];
    Queue<Integer> queue = new LinkedList<>();
    List<Integer> path = new ArrayList<>();
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

    parentArray[from] = from;
    visited[from] = true;
    queue.add(from);

    while( !queue.isEmpty() ) {
      int s = queue.remove();
      for( int i = 0; i < adjList[s].size(); i++ ) {
        int node = adjList[s].get(i);
        if( !visited[node] ) {
          queue.add(node);
          visited[node] = true;
          parentArray[node] = s;
        }
      }
    }

    int d = to;
    while( d != parentArray[d] ) {
      path.add(d);
      d = parentArray[d];
    }

    return path;
  } 
  
}
