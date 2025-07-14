package com.vikram.dsa.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class NumberOfWaysToArriveDestination {

  public static void main( String[] args ) {
    NumberOfWaysToArriveDestination arriveDestination = new NumberOfWaysToArriveDestination();
    int[][] arr = {
      {
        0,
        6,
        7
      },
      {
        0,
        1,
        2
      },
      {
        1,
        2,
        3
      },
      {
        1,
        3,
        3
      },
      {
        6,
        3,
        3
      },
      {
        3,
        5,
        1
      },
      {
        6,
        5,
        1
      },
      {
        2,
        5,
        1
      },
      {
        0,
        4,
        5
      },
      {
        4,
        6,
        2
      }
    };
    System.out.println( arriveDestination.countPaths(7, arr));
  }

   public int countPaths(int n, int[][] roads) {
        List<int[]> adjList[] = new ArrayList[n];
        Pair[] times = new Pair[n];
        Arrays.fill( times, new Pair( Integer.MAX_VALUE ) );
        for( int i = 0; i < roads.length; i++ ) {
            int u = roads[i][0];
            int v = roads[i][1];
            int time = roads[i][2];
            if( adjList[u] == null ) {
                adjList[u] = new ArrayList<>();
            }
            if( adjList[v] == null ) {
                adjList[v] = new ArrayList<>();
            }
            adjList[u].add( new int[]{v, time});
            adjList[v].add( new int[]{u, time});
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>( new Comparator<int[]>() {
          @Override
          public int compare(int[] o1, int[] o2) {
            return o1[1] - o2[1];
          }
        });
        minHeap.add( new int[]{ 0, 0} );
        times[0] = new Pair(0);
        while( !minHeap.isEmpty() ) {
            int[] sourceNode = minHeap.remove();
            int source = sourceNode[0];
            int time = sourceNode[1];
            if( time > times[source].time ) {
                continue;
            }
            for( int[] destNode: adjList[source] ) {
                int destination = destNode[0];
                int destTime = destNode[1];
                int totalTime = time + destTime;
                if( totalTime == times[destination].time ) {
                    times[destination].count = times[destination].count + 1;
                }
                if( totalTime < times[destination].time ) {
                    times[destination] = new Pair( totalTime );
                    minHeap.add( new int[]{ destination, totalTime} );
                }
            }
        } 
        return times[n-1].count;
    }

    private static class Pair {
        int time;
        int count;
        public Pair( int time ) {
            this.time = time;
            this.count = 1;
        }
    }
  
}
