package com.vikram.dsa.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class EvaluateDivision {

  public static void main(String[] args ) {
    List<List<String>> equations = new ArrayList<>(
      List.of(
        List.of("x1","x2"),
        List.of("x2","x3"),
        List.of("x3","x4"),
        List.of("x4","x5")
      )
    );

    double[] values = {3.0,4.0,5.0,6.0};

    List<List<String>> queries = new ArrayList<>(
      List.of(
        List.of("x1","x5"),
        List.of("x5","x2"),
        List.of("x2","x4"),
        List.of("x2","x2"),
        List.of("x2","x9"),
        List.of("x9", "x9")
      )
    );

    EvaluateDivision division = new EvaluateDivision();
    System.out.println(division.calcEquation(equations, values, queries));
  }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        if( equations.isEmpty() || queries.isEmpty() ) {
            return new double[0];
        }
        double[] ans = new double[queries.size()];
        int n = equations.size();
        Map<String, List<Pair>> adjMap = new HashMap<>();
        for( int i = 0; i < n; i++ ) {
            double value = values[i];
            String b = equations.get(i).get(1);
            String a = equations.get(i).get(0);
            if( adjMap.containsKey(a) ) {
                List<Pair> list = adjMap.get(a);
                list.add(new Pair(b, value));
                adjMap.put(a, list); 
            }
            else {
                List<Pair> list = new ArrayList<>();
                list.add(new Pair(b, value));
                adjMap.put(a, list);
            }
             if( adjMap.containsKey(b) ) {
                List<Pair> list = adjMap.get(b);
                list.add(new Pair(a, 1/value));
                adjMap.put(b, list); 
            }
            else {
                List<Pair> list = new ArrayList<>();
                list.add(new Pair(a, 1/value));
                adjMap.put(b, list);
            }
        }

        for( int i = 0; i < queries.size(); i++ ) {
            String s = queries.get(i).get(0);
            String d = queries.get(i).get(1);
            HashSet<String> visited = new HashSet<>();
            ans[i] = dfs(s, d, adjMap, visited, 1);
        }

        return ans;
        
    }

    private double dfs(String s, String d, Map<String, List<Pair>> adjMap, HashSet<String> visited, double ans ) {
      if( adjMap.get(s) == null ) {
        return -1;
      }

      if( s.equals(d) ) {
        return 1;
      }

      double max = -1;
      visited.add(s);
        for( int i = 0; i < adjMap.get(s).size(); i++ ) {
            Pair p  =adjMap.get(s).get(i);
            if( p.node.equals(d) ) {
              max = Math.max(max, ans * p.value);
              break;
            }
            else {
              if( !visited.contains(p.node) ) {
                max = Math.max( dfs(p.node, d, adjMap, visited, ans * p.value), max);
              }
            }
        }

        return max;
    }
}


class Pair {
  String node;
  double value;
  public Pair( String node, double value) {
    this.node = node;
    this.value = value;
  }
}
