package com.vikram.dsa.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RedundantConnection2 {

  public static void main( String[] args  ) {
    int[][] edges = {{2,1}, {3,1}, {4,2}, {1,4}};
    RedundantConnection2 connection2 = new RedundantConnection2();
    System.out.println( Arrays.toString(connection2.findRedundantDirectedConnection(edges)));
  }

   public int[] findRedundantDirectedConnection(int[][] edges) {
        if( edges == null ||  edges.length <= 0 ) {
            return new int[0];
        }
        int n = edges.length;
        List<Integer> adjList[] = new ArrayList[n+1];
        int[] dependency = new int[n+1];
        int[] parent = new int[n+1];

        for( int i = 0; i < edges.length; i++ ) {
            int u = edges[i][0];
            int v = edges[i][1];
            if( adjList[v] == null ) {
                adjList[v] = new ArrayList<>();
            }
            adjList[v].add(u);
            dependency[v] += 1;
        }
        for( int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for( int i = 0; i < n; i++ ) {
            int u = edges[i][0];
            int v = edges[i][1];
            int su = superParent(u, parent);
            int sv = superParent(v, parent);
            if( su == sv ) {
                return removeEdge(dependency, edges, adjList, n, u, v);
            }
            parent[su] = sv;
        }


        return new int[0];
    }

    public int[] removeEdge( int[] dependency, int[][] edges, List<Integer> adjList[], int n, int u, int v ) {
        for( int i = 1; i <= n; i++) {
            if( dependency[i] > 1 ) {
                for( int j =  adjList[i].size()-1; j >= 0; j--) {
                    int ele = adjList[i].get(j);
                    int[] ans = {  ele, i};
                    if( !cycle(edges,ans )) {
                        return ans;
                    }
                }
            }
        }
        int[] ans = {u, v};
        return ans;
    }


    public boolean cycle( int[][] edges, int[] blackListNode ) {
        int[] parent = new int[edges.length+1];
        for( int i = 1; i <= edges.length; i++) {
            parent[i] = i;
        }
    
        for( int i = 0; i < edges.length; i++ ) {
            int u = edges[i][0];
            int v = edges[i][1];
            if( !(u == blackListNode[0] && v == blackListNode[1])) {
                int su = superParent(u, parent);
                int sv = superParent(v, parent);
                if( su == sv ) {
                    return true;
                }
                parent[su] = sv;
            }

        }
        return false;
    }

    private int superParent( int s, int[] parent ) {
        if( s == parent[s] ) {
            return s;
        }
        parent[s] = superParent(parent[s], parent);
        return parent[s];
    }
}
