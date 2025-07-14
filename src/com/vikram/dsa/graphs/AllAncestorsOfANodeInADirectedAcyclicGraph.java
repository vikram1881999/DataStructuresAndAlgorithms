package com.vikram.dsa.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class AllAncestorsOfANodeInADirectedAcyclicGraph {

  public static void main( String[] args ) {
    int[][] edges= {
      {
        0,
        3
      },
      {
        0,
        4
      },
      {
        1,
        3
      },
      {
        2,
        4
      },
      {
        2,
        7
      },
      {
        3,
        5
      },
      {
        3,
        6
      },
      {
        3,
        7
      },
      {
        4,
        6
      }
    };


    AllAncestorsOfANodeInADirectedAcyclicGraph aDirectedAcyclicGraph = new AllAncestorsOfANodeInADirectedAcyclicGraph();
    System.out.println( aDirectedAcyclicGraph.getAncestors(8, edges));
  }

   public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> adjList[] = new ArrayList[n];
        int[] dependency = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> parentTracker[] = new HashSet[n];
        for( int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            if( adjList[u] == null ) {
                adjList[u] = new ArrayList<>();
            }
            if( adjList[v] == null ) {
                adjList[v] = new ArrayList<>();
            }
            adjList[u].add(v);
            dependency[v]++;
        }

        for( int i = 0; i < n; i++ ) {
            if( dependency[i] == 0 ) {
                queue.add(i);
            }
            parentTracker[i] = new HashSet<>();
        }

        while( !queue.isEmpty() ) {
            int node = queue.remove();
            Set<Integer> parentList = parentTracker[node];
            for( int neighbour: adjList[node] ) {
                Set<Integer> neighbourParent = parentTracker[neighbour];
                neighbourParent.add(node);
                for( int parent: parentList ){
                    neighbourParent.add(parent);
                }
                dependency[neighbour]--;
                if( dependency[neighbour] == 0 ) {
                    queue.add(neighbour);
                }
            }
        }

        for( int i = 0; i < n; i++ ) {
            List<Integer> parents = new ArrayList<>();
            Set<Integer> parentSet = parentTracker[i];
            for( int parent: parentSet ) {
                parents.add(parent);
            }
            Collections.sort(parents);
            ans.add(parents);
        }


        return ans;

    }
  
}
