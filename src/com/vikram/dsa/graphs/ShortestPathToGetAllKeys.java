package com.vikram.dsa.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class ShortestPathToGetAllKeys {

  public static void main( String[] args ) {
    String[] arr = {"@.a..","###.#","b.A.B"};
    ShortestPathToGetAllKeys allKeys = new ShortestPathToGetAllKeys();
    System.out.println( allKeys.shortestPathAllKeys(arr) );
  }

  public int shortestPathAllKeys(String[] grid) {
    int[][] moves = {{-1,0}, {1, 0}, {0, 1}, {0, -1}};
    int n = grid.length;
    int m = grid[0].length();
    Queue<State> queue = new LinkedList<>();
    Set<String> visited = new HashSet<>();
    Set<Character> allKeys = new HashSet<>();

    int startX = 0, startY = 0;
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            char ch = grid[i].charAt(j);
            if(ch == '@') {
                startX = i;
                startY = j;
            } else if(Character.isLowerCase(ch)) {
                allKeys.add(ch);
            }
        }
    }

    State start = new State(startX, startY, new HashSet<>());
    queue.offer(start);
    visited.add(startX + "_" + startY + "_");

    int steps = 0;
    while(!queue.isEmpty()) {
        int size = queue.size();
        for(int i = 0; i < size; i++) {
            State curr = queue.poll();

            if(curr.keys.size() == allKeys.size()) {
                return steps;
            }

            for(int[] move : moves) {
                int x = curr.x + move[0];
                int y = curr.y + move[1];

                if(x < 0 || y < 0 || x >= n || y >= m || grid[x].charAt(y) == '#') continue;

                char ch = grid[x].charAt(y);
                Set<Character> newKeys = new HashSet<>(curr.keys);

                if(Character.isLowerCase(ch)) {
                    newKeys.add(ch);
                } else if(Character.isUpperCase(ch) && !newKeys.contains(Character.toLowerCase(ch))) {
                    continue; // Can't pass through locked door
                }

                String keysString = getKeyString(newKeys);
                String newVisitedKey = x + "_" + y + "_" + keysString;
                if(!visited.contains(newVisitedKey)) {
                    visited.add(newVisitedKey);
                    queue.offer(new State(x, y, newKeys));
                }
            }
        }
        steps++;
    }
    return -1;
}

private String getKeyString(Set<Character> keys) {
    List<Character> list = new ArrayList<>(keys);
    Collections.sort(list);
    StringBuilder sb = new StringBuilder();
    for(char c : list) sb.append(c);
    return sb.toString();
}

private class State {
    int x, y;
    Set<Character> keys;
    State(int x, int y, Set<Character> keys) {
        this.x = x;
        this.y = y;
        this.keys = keys;
    }
}
  
}
