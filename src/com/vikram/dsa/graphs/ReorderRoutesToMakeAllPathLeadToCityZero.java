package com.vikram.dsa.graphs;

import java.util.ArrayList;
import java.util.List;

public class ReorderRoutesToMakeAllPathLeadToCityZero {

  public static void main( String[] args ) {
    int[][] arr = {{0,1},{1,3},{2,3},{4,0},{4,5}};
    ReorderRoutesToMakeAllPathLeadToCityZero allPathLeadToCityZero = new ReorderRoutesToMakeAllPathLeadToCityZero();
    System.out.println(allPathLeadToCityZero.minReorder(6, arr));
  }

  public int minReorder(int n, int[][] connections) {
        List<Pair> adjList[] = new ArrayList[n];
        for( int i = 0; i < connections.length; i++ ) {
            int from = connections[i][0];
            int to = connections[i][1];
            if( adjList[from] == null ) {
                adjList[from] = new ArrayList<>();
            }
            if( adjList[to] == null ) {
                adjList[to] = new ArrayList<>();
            }
            adjList[from].add(new Pair(to, 1));
            adjList[to].add(new Pair(from, 0));
        }

        boolean[] visited = new boolean[n];

        return dfs( adjList, visited, 0 );
    }

    public int dfs( List<Pair> adjList[], boolean[] visited, int from ) {
        if( visited[from] ) {
            return 0;
        }
        int change = 0;
        visited[from] = true;

        for( Pair to : adjList[from] ) {
            if( !visited[Math.abs(to.to)] ) { 
                change += dfs( adjList, visited, Math.abs(to.to) ) + to.w;
            }
        }

        return change;
    }

    private class Pair {
        int to;
        int w;
        public Pair( int to, int w ) {
            this.to = to;
            this.w = w;
        }
    }
  
}

