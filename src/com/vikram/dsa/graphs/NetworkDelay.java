package com.vikram.dsa.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class NetworkDelay {

  public static void main( String[] args ) {
    int[][] arr = {{2,1,1},{2,3,1},{3,4,1}};
    NetworkDelay networkDelay = new NetworkDelay();
    System.out.println( networkDelay.networkDelayTime(arr, 4, 2));
  }

  public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]> adjList[] = new ArrayList[n+1];
        int[] time = new int[n+1];
        Arrays.fill( time, 60000);
        int delay = 0;
        for( int i = 0; i < times.length; i++ ) {
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];
            if( adjList[u] == null ) {
                adjList[u] = new ArrayList<>();
            }
            adjList[u].add( new int[]{ v, w });
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>( new Comparator<int[]>() {
          @Override
          public int compare(int[] o1, int[] o2) {
            return o1[1] - o2[1];
          }
          
        });
        time[k] = 0;
        minHeap.add( new int[]{ k, 0});
        while( !minHeap.isEmpty() ) {
            int[] node = minHeap.remove();
            int source = node[0];
            int t = node[1];
            if( time[source] > t || adjList[source] == null ) {
                continue;
            }

            for( int[] neighbour: adjList[source] ) {
                int neighbourNode = neighbour[0];
                int timeToNeighbour = neighbour[1];
                if( t + timeToNeighbour < time[neighbourNode] ) {
                    time[neighbourNode] = t + timeToNeighbour;
                    minHeap.add( new int[] { neighbourNode,  t + timeToNeighbour });
                }
            }
        }

        for( int i = 1; i < time.length; i++ ) {
            if( time[i] == 60000 ) {
                return -1;
            }
            delay = Math.max( delay, time[i] );
        }

        return delay;
    }
  
}
