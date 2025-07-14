package com.vikram.dsa.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CountCompleteComponent {

  public static void main(String[] args) {
    CountCompleteComponent completeComponent = new CountCompleteComponent();
    int[][] edges = { { 2, 1 } };
    System.out.println(completeComponent.countCompleteComponents(3, edges));

  }

  public int countCompleteComponents(int n, int[][] edges) {
    List<List<Integer>> g = new ArrayList<>(n);
    for (int i = 0; i < n; i++)
      g.add(new ArrayList<>());
    for (int[] e : edges) {
      g.get(e[0]).add(e[1]);
      g.get(e[1]).add(e[0]);
    }

    boolean[] visited = new boolean[n];
    int complete = 0;

    for (int start = 0; start < n; start++) {
      if (visited[start])
        continue;
      Queue<Integer> q = new LinkedList<>();
      List<Integer> comp = new ArrayList<>();
      visited[start] = true;
      q.add(start);

      while (!q.isEmpty()) {
        int u = q.poll();
        comp.add(u);
        for (int v : g.get(u)) {
          if (!visited[v]) {
            visited[v] = true;
            q.add(v);
          }
        }
      }

      boolean isComplete = true;
      int k = comp.size();
      for (int v : comp) {
        if (g.get(v).size() != k - 1) {
          isComplete = false;
          break;
        }
      }
      if (isComplete)
        complete++;
    }
    return complete;
  }

}
