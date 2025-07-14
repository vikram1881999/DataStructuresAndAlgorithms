package com.vikram.dsa.graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class ParallerCourseMinSemesters {

  public static void main( String[] args ) {
    ParallerCourseMinSemesters courseMinSemesters = new ParallerCourseMinSemesters();
    int n = 12;
    int[][] relations = {
      {
        1,
        2
      },
      {
        1,
        3
      },
      {
        7,
        5
      },
      {
        7,
        6
      },
      {
        4,
        8
      },
      {
        8,
        9
      },
      {
        9,
        10
      },
      {
        10,
        11
      },
      {
        11,
        12
      }
    };
    System.out.println(courseMinSemesters.minNumberOfSemesters2(n, relations, 2));
  }

  public int minNumberOfSemesters(int n, int[][] relations, int k) {
        int c = 0;
        List<Integer> adjList[] = new ArrayList[n+1];
        List<Integer> reverseAdjList[] = new ArrayList[n+1];
        int[] dependency = new int[n+1];
        int[] reverseDependency = new int[n+1];
        for( int i = 0; i < relations.length; i++ ) {
            int u = relations[i][0];
            int v = relations[i][1];
            if( adjList[u] == null ) {
                adjList[u] = new ArrayList<>();
            }
            if( reverseAdjList[v] == null ) {
                reverseAdjList[v] = new ArrayList<>();
            }
            adjList[u].add(v);
            reverseAdjList[v].add(u);
            dependency[v]++;
            reverseDependency[u]++;
        }

        c = getTime( adjList, dependency, k , n);
        c = Math.min( c, getTime( reverseAdjList, reverseDependency, k, n) );
        return c;
    }


    private int getTime( List<Integer> adjList[], int[] dependency, int k, int n ) {
        int time = 0;
        Queue<Integer> queue = new LinkedList<>();
        for( int i = 1; i <= n; i++) {
            if( dependency[i] == 0 ) {
                queue.add( i ); 
            }
        }
        while( !queue.isEmpty() ) {
            int size = queue.size();
            for( int i = 0; i < Math.min(size, k); i++ ) {
                int currCourse = queue.remove();
                if( adjList[currCourse] == null ) {
                    continue;
                }
                for( int nextCourse: adjList[currCourse] ) {
                    dependency[nextCourse]--;
                    if( dependency[nextCourse] == 0 ) {
                        queue.add(nextCourse);
                    }
                }
            }
            time++;
        }
        return time;
    }


    public int minNumberOfSemesters2(int n, int[][] relations, int k) {
        int c = 0;
        List<Integer> adjList[] = new ArrayList[n+1];
        int[] dependency = new int[n+1];
        int[] outgoingEdges = new int[n+1];
        for( int i = 0; i < relations.length; i++ ) {
            int u = relations[i][0];
            int v = relations[i][1];
            if( adjList[u] == null ) {
                adjList[u] = new ArrayList<>();
            }
  
            adjList[u].add(v);
            dependency[v]++;
            outgoingEdges[u]++;
        }


        PriorityQueue<Pair> queue = new PriorityQueue<>( new Comparator<Pair>() {

          @Override
          public int compare(Pair o1, Pair o2) {
            return o2.nextCoursesNumber - o1.nextCoursesNumber;
          }
          
        });

        for( int i = 1; i <= n; i++ ) {
            if( dependency[i] == 0 ) {
                queue.add( new Pair( i, outgoingEdges[i] ) );
            }
        }

        while( !queue.isEmpty() ) {
            int size = queue.size();
            for( int i = 0; i < Math.min(size, k); i++ ) {
                Pair p = queue.remove();
                int currentCourse = p.course;

                if( adjList[currentCourse] == null ) continue;
                for( int nextCourse: adjList[currentCourse] ) {
                    dependency[nextCourse]--;
                    if( dependency[nextCourse] == 0 ) {
                        queue.add( new Pair( nextCourse, outgoingEdges[nextCourse] ) );
                    }
                }
            }
            c++;
        }
        return c;
    }

    private static class Pair {
        int course;
        int nextCoursesNumber;
        public Pair( int course, int nextCoursesNumber ) {
            this.course = course;
            this.nextCoursesNumber = nextCoursesNumber;
        }
    }
  
}
