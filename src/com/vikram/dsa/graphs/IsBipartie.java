package com.vikram.dsa.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class IsBipartie {


  public static void main( String[] args ) {

  }

  public boolean isBipartite(int[][] graph) {
        int n =  graph.length;
        boolean[] visited = new boolean[n];
        int[] color = new int[n];
        for( int i = 0; i < n; i++ ) {
            if( !visited[i] ) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                color[i] = 1;
                visited[i] = true;
                while( !queue.isEmpty() ) {
                    int pos = queue.remove();
                    for( int neighbour: graph[pos] ) {
                        if( !visited[neighbour] ) {
                            color[neighbour] = 3 - color[pos];
                            visited[neighbour] = true;
                            queue.add(neighbour);
                        }
                        else {
                            if( color[pos] == color[neighbour] ) {
                                return false;
                            }
                        }
                    }
                }
            }
        }

        return true;
    }
  
}
