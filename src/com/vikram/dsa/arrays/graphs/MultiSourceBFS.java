package com.vikram.dsa.arrays.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Given N nodes & multisource S1 S2 S3 find the length of shortest path for all nodes to any of the source node { S1, S2, S3}
 */
public class MultiSourceBFS {
  
  public static void main( String[] args ) {
    MultiSourceBFS bfs = new MultiSourceBFS();
    int[][] arr = {{11, 1}, {11,6}, {11, 5}, {5,2}, {5,4}, {4,8}, {2,3}, {8,7}, {7, 10}, {10, 13}, {13, 9}, {9,3}, {3,12}};
    int[] src = { 11, 7, 2};
    System.out.println( Arrays.toString(bfs.multiSourceBFS(arr, src, 13)));
  }


  public int[] multiSourceBFS(int[][] arr, int[] src, int nodes ) {
    List<Integer>[] adjList = adjList(arr, nodes);
    Queue<Integer> queue = new LinkedList<>();
    int[] distance = new int[nodes+1];
    boolean[] visited = new boolean[nodes+1];
    for( int i = 0; i < src.length; i++ ) {
      queue.add(src[i]);
      visited[src[i]] = true;
      distance[src[i]] = 0;
    }

    while( !queue.isEmpty() ) {
      int s = queue.remove();
      for( int i = 0; i < adjList[s].size(); i++ ) {
        int node = adjList[s].get(i);
        if( !visited[node] ) {
          visited[node] = true;
          distance[node] = distance[s] + 1;
          queue.add(node);
        }
      }
    }

    return distance;
  } 

  public List<Integer>[] adjList( int[][] arr, int nodes) {
    List<Integer>[] lists = new ArrayList[nodes+1];
    for( int i = 0; i < arr.length; i++ ) {
      int u = arr[i][0];
      int v = arr[i][1];
      if( lists[u] == null ) {
        lists[u] = new ArrayList<>();
      }
      if( lists[v] == null ) {
        lists[v] = new ArrayList<>();
      }
      lists[u].add(v);
      lists[v].add(u);
    }
    return lists;
  }
  
}
