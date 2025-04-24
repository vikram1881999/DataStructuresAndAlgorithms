package com.vikram.dsa.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Course {

  public static void main(String[] args) {
    Course course = new Course();
    int[][] courses = {{1,0}};
    System.out.println(course.canFinish(2, courses));
  }

   public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] dependency = new int[numCourses];
        List<Integer> adjList[] = new ArrayList[numCourses];
        Queue<Integer> courseQueue = new LinkedList<>();
        int c = 0;
        for( int i = 0; i < prerequisites.length; i++ ) {
            int course1 = prerequisites[i][0];
            int course2 = prerequisites[i][1];
            if( adjList[course1] == null ) {
                adjList[course1] = new ArrayList<>();
            }
            adjList[course1].add(course2);
            dependency[course2] += 1;
        }

        for( int i = 0; i < numCourses; i++ ) {
            if( dependency[i] == 0 ) {
                courseQueue.add(i);
            }
        }

        while( !courseQueue.isEmpty() ) {
            c++;
            int course = courseQueue.remove();
            if( adjList[course] == null ) {
                continue;
            }
            for( int i = 0; i < adjList[course].size(); i++ ) {
                int dependentCourse = adjList[course].get(i);
                dependency[dependentCourse] -= 1;
                if( dependency[dependentCourse] == 0 ) {
                    courseQueue.add(dependentCourse);
                }
            }
        }

        if( c != numCourses ) {
            return false;
        }
        return true;
    }
  
}
