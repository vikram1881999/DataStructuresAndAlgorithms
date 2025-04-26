package com.vikram.dsa.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.function.Function;

public class ReconstructItenary {

  public static void main( String[] args ) {
    ReconstructItenary itinerarySolver = new ReconstructItenary();

        // 2) Properly build the list of ticket pairs
        List<List<String>> tickets = Arrays.asList(
            Arrays.asList("JFK","ATL"),
            Arrays.asList("JFK","SFO"),
            Arrays.asList("SFO","JFK")
        );

        // 3) Invoke and print the result
        System.out.println(itinerarySolver.findItinerary(tickets));
  }

  public List<String> findItinerary(List<List<String>> tickets) {
        if( tickets.isEmpty()) {
            return new ArrayList<>(List.of("JFK"));
        }
        LinkedList<String> order = new LinkedList<>();
        Map<String, PriorityQueue<String>> adjMap = new HashMap<>();
        for( int i = 0; i < tickets.size(); i++ ) {
            String source = tickets.get(i).get(0);
            String dest = tickets.get(i).get(1);
            if( adjMap.containsKey(source) ) {
                PriorityQueue<String> pq = adjMap.get(source);
                pq.add(dest);
                adjMap.put(source, pq);
            }
            else {
                PriorityQueue<String> pq = new PriorityQueue<>(
                    Comparator
                        .<String, String>comparing(Function.identity())
                        .thenComparingInt(String::length)
                );
                pq.add(dest);
                adjMap.put(source, pq);
            }
        }

        dfs(adjMap, "JFK", order);

        return order;
        
    }

    private void dfs( Map<String, PriorityQueue<String>> adjMap, String source, LinkedList<String> order ) {
      if( source == null ) {
        return;
      }

      PriorityQueue<String> pq = adjMap.get(source);
      while( pq != null && !pq.isEmpty() ) {
        String dest = pq.poll();
        dfs(adjMap, dest, order);
      }

      order.addFirst(source);
    }
  
}
