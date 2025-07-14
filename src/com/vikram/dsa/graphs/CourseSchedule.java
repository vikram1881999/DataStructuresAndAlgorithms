package com.vikram.dsa.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {


  public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer> adjList[] = new ArrayList[numCourses];
        int[] dependency = new int[numCourses];
        for( int i = 0; i < prerequisites.length; i++ ) {
            int course = prerequisites[i][0];
            int prerequisite = prerequisites[i][1];
            if( adjList[prerequisite] == null ) {
                adjList[prerequisite] = new ArrayList<>();
            }
            adjList[prerequisite].add(course);
            dependency[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for( int i = 0; i < numCourses; i++ ) {
            if( dependency[i] == 0 ) {
                queue.add(i);
            }
        }

        while( !queue.isEmpty() ) {
            int c = queue.remove();
            if( adjList[c] == null ) {
                continue;
            }
            for( int course: adjList[c] ) {
                dependency[course]--;
                if( dependency[course] == 0 ) {
                    queue.add( course );
                }
            }
        }

        for( int i = 0; i < numCourses; i++ ) {
            if( dependency[i] != 0 ) {
                return false;
            }
        }


        return true;
    }
  
}
