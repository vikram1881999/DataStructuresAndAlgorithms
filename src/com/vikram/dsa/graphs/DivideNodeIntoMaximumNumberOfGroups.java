package com.vikram.dsa.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DivideNodeIntoMaximumNumberOfGroups {

  public static void main( String[] args ) {
    int[][] arr = {
      {
        1,
        2
      },
      {
        1,
        4
      },
      {
        1,
        5
      },
      {
        2,
        6
      },
      {
        2,
        3
      },
      {
        4,
        6
      }
    };
    DivideNodeIntoMaximumNumberOfGroups divideNodeIntoMaximumNumberOfGroups = new DivideNodeIntoMaximumNumberOfGroups();
    System.out.println( divideNodeIntoMaximumNumberOfGroups.magnificentSets(6, arr));
  }

  public int magnificentSets(int n, int[][] edges) {
        List<Integer> adjList[] = new ArrayList[n+1];
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
        if( !bipartie( adjList, n ) ) {
            return -1;
        }
        List<List<Integer>> components = getComponents( adjList, n );

        int maxGroup = 0;

        for( List<Integer> component: components ) {
            for( int ele: component ) {
                boolean[] visited = new boolean[n+1];
                Queue<int[]> queue = new LinkedList<>();
                visited[ele] = true;
                queue.add(new int[]{ele, 1});
                while( !queue.isEmpty() ) {
                    int[] element = queue.remove();
                    int pos = element[0];
                    int color = element[1];
                    maxGroup = Math.max( maxGroup, color);
                    if( adjList[pos] == null ) continue;

                    for( int dest: adjList[pos] ) {
                        if( !visited[dest] ) {
                            visited[dest] = true;
                            queue.add( new int[]{ dest, color+1});
                        }
                    }
                }
            }
        }

        return maxGroup;
    }


    private List<List<Integer>> getComponents( List<Integer> adjList[], int n ) {
        boolean[] visited = new boolean[n+1];
        List<List<Integer>> components = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for( int i = 1; i <= n; i++ ){
            if( !visited[i] ) {
                List<Integer> component = new ArrayList<>();
                visited[i] = true;
                queue.add(i);
                while( !queue.isEmpty() ) {
                    int from = queue.remove();
                    component.add(from);
                    if( adjList[from] == null ) {
                        continue;
                    }
                    for( int to: adjList[from] ) {
                        if( !visited[to] ) {
                            queue.add(to);
                            visited[to] = true;
                        }
                    }
                }

                components.add(component);
            }
        }

        return components;
    }

    private boolean bipartie( List<Integer> adjList[], int n ) {
        boolean[] visited = new boolean[n+1];
        int[] color = new int[n+1];
        Queue<Integer> queue = new LinkedList<>();
        for( int i = 1; i <= n; i++ ) {
            if( !visited[i] ) {
                visited[i] = true;
                color[i] = 1;
                queue.add(i);
                while( !queue.isEmpty() ) {
                    int from = queue.remove();
                    if( adjList[from] == null )  {
                        continue;
                    }
                    for( int to: adjList[from] ) {
                        if( !visited[to] ) {
                            visited[to] = true;
                            color[to] = 3 - color[from];
                            queue.add(to);
                        }
                        else if( visited[to] && color[from] == color[to] ) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
  
}
