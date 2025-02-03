package com.vikram.dsa.arrays.graphs;

import java.util.*;

/**
 * Given the unidirected graph & source node and destination node check if node can be visited from source node
 */
public class DestinationNode {

    public static void main( String[] args ) {
        DestinationNode destinationNode = new DestinationNode();
        int[][] arr  = { {1,2}, {1,4}, {2,4}, {2,3}, {3,5}, {5,6}, {4,5}};
        System.out.println(destinationNode.canNodeBeVisited(arr, 6, 1, 6));
    }

    private boolean canNodeBeVisited(int[][] arr, int nodes, int source, int e) {
        List<Integer>[] adjList = new ArrayList[nodes+1];
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

        System.out.println(Arrays.toString(adjList));

        boolean[] visited = new boolean[nodes+1];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(source);
        visited[source] = true;
        while( !queue.isEmpty() ) {
            int src = queue.remove();
            for( int i = 0; i < adjList[src].size(); i++ ) {
                if( !visited[adjList[src].get(i)] ) {
                    queue.add(adjList[src].get(i));
                    visited[adjList[src].get(i)] = true;
                }
            }
        }

        return visited[e];
    }
}
