package com.vikram.dsa.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SortItems {

  public static void main( String[] args ) {
    List<List<Integer>> beforeItems = List.of( List.of(), List.of(6), List.of(5), List.of(6), List.of(3, 6), List.of(), List.of(), List.of() );
    int[] group = {-1,-1,1,0,0,1,0,-1};
    int m = 2;
    SortItems items = new SortItems();
    System.out.println( Arrays.toString(items.sortItems(8, m, group, beforeItems)));
  }

  public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
    for( int i = 0; i < n; i++ ) {
        if( group[i] == -1 ) {
            group[i] = m;
            m++;
        }
    }
    int[] ans = new int[n];
    List<Integer> adjItems[] = new ArrayList[n];
    List<Integer> adjGroups[] = new ArrayList[m];
    List<Integer> adjGroupItems[] = new ArrayList[m];
    int[] itemDependency = new int[n];
    int[] groupDependency = new int[m];
    for( int i = 0; i < n; i++ ) {
        int currGroup = group[i];
        int prevItemGroup = currGroup;
        if( adjGroups[currGroup] == null ){
            adjGroups[currGroup] = new ArrayList<>();
        }
        if( adjItems[i] == null ) {
            adjItems[i] = new ArrayList<>();
        }
        List<Integer> beforeItemList = beforeItems.get(i);
        for( int beforeItem: beforeItemList ) {
            if( adjItems[beforeItem] == null ) {
                adjItems[beforeItem] = new ArrayList<>();
            }
            adjItems[beforeItem].add(i);
            itemDependency[i]++;
            int beforeItemGroup = group[beforeItem];
            if( currGroup != beforeItemGroup && beforeItemGroup != prevItemGroup ) {
                if( adjGroups[beforeItemGroup] == null ){
                    adjGroups[beforeItemGroup] = new ArrayList<>();
                }
                adjGroups[beforeItemGroup].add(currGroup);
                groupDependency[currGroup]++;
                prevItemGroup = beforeItemGroup;
            }
        } 

    }

    List<Integer> groupOrder = topologicalSort( adjGroups, groupDependency, m );
    if( groupOrder.size() == 0 ) return new int[]{};

    List<Integer> itemOrder = topologicalSort( adjItems, itemDependency, n);
    if( itemOrder.size() == 0 ) return new int[]{};

    for( int item: itemOrder ) {
      int itemGroup = group[item];
      if( adjGroupItems[itemGroup] == null ) {
        adjGroupItems[itemGroup] = new ArrayList<>();
      }
      adjGroupItems[itemGroup].add(item);
    }

    int i = 0;
    for( int currGroup: groupOrder ) {
        for( int item: adjGroupItems[currGroup] ) {
            ans[i] = item;
            i++;
        }
    }



    return ans;

}

private List<Integer> topologicalSort( List<Integer> adjList[], int[] dependency, int total ){
    List<Integer> answer = new ArrayList<>();
    Queue<Integer> queue = new LinkedList<>();
    for( int i = 0; i < dependency.length; i++ ) {
        if( dependency[i] == 0 ) {
            queue.add(i);
        }
    }

    while( !queue.isEmpty() ) {
        int item = queue.remove();
        answer.add( item );
        if( adjList[item] == null ) continue;
        for( int neighbour: adjList[item] ) {
            dependency[neighbour]--;
            if( dependency[neighbour] == 0 ) {
                queue.add( neighbour );
            }
        }
    }


    return answer.size() != total ? new ArrayList<>(): answer;
}
  
}
