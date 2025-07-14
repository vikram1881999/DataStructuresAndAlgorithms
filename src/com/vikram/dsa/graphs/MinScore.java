package com.vikram.dsa.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinScore {

  public static void main( String[] args) {
    int[][] roads = {{1,2,2},{1,3,4},{3,4,7}};
    int n = 4;
    MinScore minScore = new MinScore();
    System.out.println(minScore.minScore(n, roads));
  } 
  
  public int minScore(int n, int[][] roads) {
        int ans = Integer.MAX_VALUE;
        List<Pair> adjList[] = new ArrayList[n+1];
        boolean[] visited = new boolean[n+1];
        for( int[] road: roads ) {
            int from = road[0];
            int to = road[1];
            int distance = road[2];
            if( adjList[from] == null ) {
                adjList[from] = new ArrayList<>();
            }
            if( adjList[to] == null ) {
                adjList[to] = new ArrayList<>();
            }
            adjList[from].add( new Pair(to, distance));
            adjList[to].add( new Pair(from, distance));
        }

        Queue<Pair> queue = new LinkedList<>( );
        queue.add(new Pair( 1, Integer.MAX_VALUE ));
        visited[1] = true;
        while( !queue.isEmpty() ) {
            Pair pair = queue.remove();
            int source = pair.destination;
            int cost = pair.cost;
            ans = Math.min( ans, cost);
            for(  Pair destination: adjList[source] ) {
                int loc = destination.destination;
                if( !visited[loc] ) {
                    visited[loc] = true;
                    queue.add(destination);
                }
            }
        }

        return ans;
    }

    private class Pair {
        int destination;
        int cost;
        public Pair( int destination, int cost ) {
            this.destination = destination;
            this.cost = cost;
        }
    }
}
