package com.vikram.dsa.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGame3 {

  public static void main( String[] args ) {
    JumpGame3 game3 = new JumpGame3();
    int[] arr = {4,2,3,0,3,1,2};
    System.out.println(game3.canReach(arr, 5));
  }

  public boolean canReach(int[] arr, int start) {
    int n = arr.length;
    boolean[] visited = new boolean[n];
    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);
    while( !queue.isEmpty() ) {
        int s = queue.remove();
        int jump = arr[s];
        if( jump == 0 ) {
            return true;
        }
        int pos1 = s-jump;
        int pos2 = s+jump;
        if(  pos1 >= 0 && !visited[pos1] ) {
            visited[pos1] = true;
            queue.add(pos1);
        }
        if( pos2 < n && !visited[pos2] ) {
            visited[pos2] = true;
            queue.add(pos2);
        }
    }

    return false;
}
  
}
