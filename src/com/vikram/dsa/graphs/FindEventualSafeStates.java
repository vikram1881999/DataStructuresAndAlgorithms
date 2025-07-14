package com.vikram.dsa.graphs;

import java.util.ArrayList;
import java.util.List;

public class FindEventualSafeStates {

  public static void main( String[] args ) {
    int[][] arr = {
      {
        1,
        2
      },
      {
        2,
        3
      },
      {
        5
      },
      {
        0
      },
      {
        5
      },
      {},
      {}
    };
    FindEventualSafeStates eventualSafeStates = new FindEventualSafeStates();
    System.out.println( eventualSafeStates.eventualSafeNodes(arr));
  }

  public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer> safeNodes = new ArrayList<>();
        boolean[] visited = new boolean[n];
        boolean[] safeNode = new boolean[n];
        boolean[] pathVisited = new boolean[n];

        for( int i = 0; i < n; i++ ) {
            if( !visited[i] ) {
                dfs(visited, safeNode, pathVisited,i, graph );
            }
        }

        for( int i = 0; i < n; i++ ) {
            if( safeNode[i] ) {
                safeNodes.add(i);
            }
        }

        return safeNodes;
    }

    private boolean dfs(boolean[] visited, boolean[] safeNode, boolean[] pathVisited, int node, int[][] graph) {
      visited[node] = true;
      pathVisited[node] = true;
      
      for(int nextNode : graph[node]) {
          if(!visited[nextNode] && !dfs(visited, safeNode, pathVisited, nextNode, graph)) {
              // If neighbor is unsafe, current node is also unsafe
              pathVisited[node] = false;
              return false;
          } else if(pathVisited[nextNode]) {
              // Cycle detected - current node is unsafe
              pathVisited[node] = false;
              return false;
          }
      }
      
      pathVisited[node] = false;
      safeNode[node] = true;
      return true;
  }
  
}
