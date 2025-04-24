package com.vikram.dsa.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class MinHeightTree {

  public static void main( String[] args ) {
    MinHeightTree heightTree = new MinHeightTree();
    int[][] edges = {{0,1}, {0,9}, {1,2}, {1,3}, {1,4}, {1,5}, {9, 6}, {9, 7}, {9, 8}};
    System.out.println( heightTree.findMinHeightTrees2(10, edges));
  }


  public List<Integer> findMinHeightTrees2(int n, int[][] edges) {
        if( edges.length == 0 ) {
            return new ArrayList<>(List.of(0));
        }
        List<Integer> ans = new ArrayList<>();
        Set<Integer> adjList[] = new HashSet[n];
        int dependency[] = new int[n];
        for( int i = 0; i < edges.length; i++ ) {
            int u = edges[i][0];
            int v = edges[i][1];
            if( adjList[u] == null ) {
                adjList[u] = new HashSet<>();
            }
            if( adjList[v] == null ) {
                adjList[v] = new HashSet<>();
            }
            adjList[u].add(v);
            adjList[v].add(u);
            dependency[u] +=1;
            dependency[v] +=1;
        }

        Set<Integer> leaves = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        for( int i = 0; i < n; i++ ) {
            if( dependency[i] <= 1 ) {
                queue.add(i);
                leaves.add(i);
            }
        }

        int remaining = n;
        while (remaining > 2) {
          int sz = queue.size();
          remaining -= sz;
          for (int i = 0; i < sz; i++) {
            int leaf = queue.poll();
            for( Integer neighbor: adjList[leaf] ) {
              adjList[neighbor].remove(leaf);
              if (adjList[neighbor].size() == 1) {
                leaves.add(neighbor);
                queue.add(neighbor);
            }
            }
          }
      }
      return new ArrayList<>(queue);

    }

    public Map<Integer, Set<Integer>> trimLeaves(Map<Integer, Set<Integer>> adjMap ) {
        if( adjMap.size() <= 2 ) {
            return adjMap;
        }
        List<Integer> leaves = new ArrayList<>();
        for(Map.Entry<Integer, Set<Integer>> entry: adjMap.entrySet()) {
            int key = entry.getKey();
            Set<Integer> set = entry.getValue();
            if( set.size() == 1 ) {
                adjMap.remove(key);
                leaves.add(key);
            }
        }

        for( Integer leave: leaves ) {
            for(Map.Entry<Integer, Set<Integer>> entry: adjMap.entrySet()) {
                Set<Integer> set = entry.getValue();
                if( set.contains(leave)) {
                    set.remove(leave);
                }
            }
        }

        return trimLeaves(adjMap);
    }



  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> adjList[] = new ArrayList[n];
        int min = n;
        Map<Integer, List<Integer>> map = new HashMap<>();

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
        for( int i = 0; i < n; i ++ ) {
            int maxHeight = getTreeHeight(adjList, n, i);
            if( map.containsKey(maxHeight) ) {
                List<Integer> list = map.get(maxHeight);
                list.add(i);
                map.put(maxHeight, list);
            } 
            else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(maxHeight, list);
            }
            min = Math.min(maxHeight, min);
        }

        return map.get(min);
    }

    public int getTreeHeight(List<Integer> adjList[], int n, int s ) {
        int height = 0;
        int[] level = new int[n];
        boolean[] visited = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        level[s] = 1;
        visited[s] = true;
        while( !queue.isEmpty() ) {
            int node = queue.remove();
            height = Math.max(level[node], height);
            for( int i = 0; i < adjList[node].size(); i++ ) {
                int childNode =  adjList[node].get(i);
                if( !visited[childNode] ) {
                    visited[childNode] = true;
                    level[childNode] = level[node] + 1;
                    queue.add(childNode);
                }
            }
        }

        return height;
    }
}