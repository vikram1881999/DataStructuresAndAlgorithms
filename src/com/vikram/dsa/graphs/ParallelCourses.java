package com.vikram.dsa.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ParallelCourses {

  public static void main( String[] args ) {
    int n = 5;
    int[][] relations = {{1,5},{2,5},{3,5},{3,4},{4,5}};
    ParallelCourses parallelCourses = new ParallelCourses();
    int[] time = {1,2,3,4,5};
    System.out.println( parallelCourses.minimumTime(n, relations, time));
  }

  public int minimumTime(int n, int[][] relations, int[] time) {
        int ans = 0;
        List<Integer> adjList[] = new ArrayList[n+1];
        int[] dependency = new int[n+1];
        for( int i = 0; i < relations.length; i++ ) {
            int u = relations[i][0];
            int v = relations[i][1];
            if( adjList[u] == null ) {
                adjList[u] = new ArrayList<>();
            }
            adjList[u].add(v);
            dependency[v]++;
        }

        int[] coursesTime = new int[n+1];

        Queue<Integer> queue = new LinkedList<>();
        for( int i = 1; i <= n; i++) {
            if( dependency[i] == 0 ) {
                queue.add( i ); 
            }
        }

        while( !queue.isEmpty() ) {
            int currCourse = queue.remove();
            coursesTime[currCourse] += time[currCourse-1];
            ans = Math.max( coursesTime[currCourse], ans );
            if( adjList[currCourse] == null ) {
                continue;
            }

            for( int nextCourse: adjList[currCourse] ) {
                coursesTime[nextCourse] = Math.max( coursesTime[nextCourse], coursesTime[currCourse] );
                dependency[nextCourse]--;
                if( dependency[nextCourse] == 0 ) {
                    queue.add( nextCourse );
                }
            }
        }

        return ans;

    }
  
}
