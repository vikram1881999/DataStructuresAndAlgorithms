package com.vikram.dsa.graphs;

public class RedundantNode {

  public static void main( String[] args ) {
    int[][] edges = {{3,4},{1,2},{2,4},{3,5},{2,5}};
    RedundantNode node = new RedundantNode();
    System.out.println(node.findRedundantConnection(edges));
  }


  public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1 ];
        for( int i = 1; i < parent.length; i++ ) {
            parent[i] = i;
        }

        for( int i = 0; i < edges.length; i++ ) {
            int u = edges[i][0];
            int v = edges[i][1];
            int su = getSuperParent(u, parent);
            int sv = getSuperParent(v, parent);
            if( su == sv ) {
                int[] redundantNode = {u, v};
                return redundantNode;
            }
            parent[u] = Math.min(su, sv);
            parent[v] = Math.min(su, sv);
        }

        return new int[0];
    }

    public int getSuperParent(int s, int[] parent) {
        if( s == parent[s] ) {
            return s;
        }
        parent[s] = getSuperParent(parent[s], parent);
        return parent[s];
    }
  
}
