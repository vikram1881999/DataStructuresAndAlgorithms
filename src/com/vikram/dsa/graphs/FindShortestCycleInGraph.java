package com.vikram.dsa.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class FindShortestCycleInGraph {

  public static void main( String[] args ) {
    FindShortestCycleInGraph cycleInGraph = new FindShortestCycleInGraph();
    int[][] arr = {
      {
        4,
        1
      },
      {
        5,
        1
      },
      {
        3,
        2
      },
      {
        5,
        0
      },
      {
        4,
        0
      },
      {
        3,
        0
      },
      {
        2,
        1
      }
    };
    System.out.println( cycleInGraph.findShortestCycle(8, arr));
  }

  public int findShortestCycle(int n, int[][] edges) {
        int ans = Integer.MAX_VALUE;
        List<Integer> adjList[] = new ArrayList[n];
        for( int i = 0; i < edges.length; i++ ) {
            int u = edges[i][0];
            int v = edges[i][1];
            if( adjList[u] == null ) {
                adjList[u] = new ArrayList<>();
            }
            if( adjList[v] == null ) {
                adjList[v] = new ArrayList<>();
            }
            adjList[u].add(v);
            adjList[v].add(u);
        }

        for( int i = 0; i < n; i++ ) {
            int[] start = {i, -1};
            ans = Math.min( ans, bfs( adjList, start, n ) );
        }

        return ans == Integer.MAX_VALUE ? -1: ans;
    }

    public int bfs( List<Integer> adjList[], int[] start, int n ) {
        int shortestCycle = Integer.MAX_VALUE;
        Queue<int[]> queue = new LinkedList<>();
        int[] distance = new int[n];
        Arrays.fill( distance, -1 );
        queue.add( start );
        distance[start[0]] = 0;
        while( !queue.isEmpty() ) {
            int[] coords = queue.remove();
            int pos = coords[0];
            int parent = coords[1];
            if( adjList[pos] != null ){
              for (int neighbor : adjList[pos]) {
                if (distance[neighbor] == -1) {
                    distance[neighbor] = distance[pos] + 1;
                    queue.offer(new int[]{neighbor, pos});
                } else if (neighbor != parent) {
                    shortestCycle = Math.min(shortestCycle, distance[pos] + distance[neighbor] + 1);
                }
              }
            }
        }

        return shortestCycle;
    }
  
}
