package com.vikram.dsa.arrays.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.sound.midi.SysexMessage;

/**
 * Given undirected graph find no of connected components A component is said to be connected, if from every node we can visit all nodes in component
 */
public class UnidirectedConnectedComponents {
  
  public static void main( String[] args ) {

    UnidirectedConnectedComponents connectedComponents = new UnidirectedConnectedComponents();
    int[] U = {1, 1, 1, 3, 3, 4, 5, 5, 9, 7, 10, 10, 11, 11, 12, 15};
    int[] V = {3, 6, 2, 4, 4, 6, 9, 7, 8, 8, 11, 14, 14, 12, 14, 13};
    System.out.println( connectedComponents.countConnectedComponents(U, V, 15));
  }

  public int countConnectedComponents( int[] u, int[] v, int nodes ) {
    int count = 0;
    List<Integer>[] adjList = adjList(u, v, nodes);
    boolean[] visited = new boolean[nodes+1];
    for( int i = 1; i < visited.length; i++ ) {
      if( !visited[i] ) {
        DFS(adjList, visited, i);
        System.out.println( Arrays.toString(visited));
        count++;
      }
    }
    return count;
  }

  public void DFS( List<Integer>[] adjList, boolean visited[], int s ) {
    if( visited[s] ) {
      return;
    }
    visited[s] = true;
    for( int i = 0; i < adjList[s].size(); i++ ) {
      DFS(adjList, visited, adjList[s].get(i));
    }
  }

  public List<Integer>[] adjList( int[] u, int[] v, int nodes ) {
    List<Integer>[] adjList = new ArrayList[nodes+1];
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
    return adjList;
  }
}
