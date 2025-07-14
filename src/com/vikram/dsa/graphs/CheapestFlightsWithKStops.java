package com.vikram.dsa.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CheapestFlightsWithKStops {

  public static void main( String[] args ) {
     CheapestFlightsWithKStops cheapestFlightsWithKStops = new CheapestFlightsWithKStops();
     int[][] flights = {
      {
        0,
        1,
        5
      },
      {
        1,
        2,
        5
      },
      {
        0,
        3,
        2
      },
      {
        3,
        1,
        2
      },
      {
        1,
        4,
        1
      },
      {
        4,
        2,
        1
      }
    };
    System.out.println( cheapestFlightsWithKStops.findCheapestPrice(5, flights, 0, 2, 2));

  }

  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
    k = k+1;
    List<int[]> adjList[] = new ArrayList[n];
    int[] time = new int[n];
    Arrays.fill( time, 100000000 );
    for( int i = 0; i < flights.length; i++ ) {
        int u = flights[i][0];
        int v = flights[i][1];
        int w = flights[i][2];
        if( adjList[u] == null ) {
            adjList[u] = new ArrayList<>();
        }
        adjList[u].add( new int[]{ v, w });
    }
    Queue<int[]> queue = new LinkedList<>();
    time[src] = 0;
    queue.add( new int[]{ src, 0, 0});
    while( !queue.isEmpty() ) {
        int[] sourceAirport = queue.remove();
        int source = sourceAirport[0];
        int price = sourceAirport[1];
        int stops = sourceAirport[2];
        if( adjList[source] == null ) {
            continue;
        }
        for( int[] destination: adjList[source] ) {
            int destinationPort = destination[0];
            int priceToDest = destination[1];
            if( stops + 1 <= k ) {
                time[destinationPort] = Math.min(  priceToDest + price, time[destinationPort ]);
                queue.add( new int[]{ destinationPort, priceToDest + price , stops+1 });
            }
        }
    }


    return time[dst] == 100000000? -1: time[dst];
}
  
}
