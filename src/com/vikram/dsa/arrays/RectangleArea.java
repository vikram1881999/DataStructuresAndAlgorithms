package com.vikram.dsa.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.TreeMap;
import java.util.TreeSet;

public class RectangleArea {

  public static void main( String[] args ) {
    RectangleArea rectangleArea  = new RectangleArea();
    int[][] coordinates = {{0,0,3,3} , { 2,0, 5, 3}, {1,1,4,4} };
    System.out.println( rectangleArea.rectangleArea(coordinates));
  }


   public int rectangleArea(int[][] rectangles) {
        int MOD = 1_000_000_007;
        List<Pair> points = new ArrayList<>();
        long area = 0;
        for( int[] cords: rectangles ) {
            int x1 = cords[0];
            int y1 = cords[1];
            int x2 = cords[2];
            int y2 = cords[3];
            Pair p = new Pair( x1, y1, y2, false);
            Pair p2 = new Pair( x2, y1, y2, true);
            points.add(p2);
            points.add(p);
        }

        Collections.sort(points, new Comparator<Pair>() {
          @Override
          public int compare( Pair a, Pair b) {
            if( a.x == b.x  ){
              if( a.y1 == b.y1 ) {
                return a.y2-b.y2;
              }
              return a.y1 - b.y1;
            }
            return a.x-b.x;
          }
        });

        TreeSet<Pair> activePoints = new TreeSet<>( new Comparator<Pair>() {
          @Override
          public int compare( Pair a, Pair b) {
            if( a.y1 == b.y1  ){
                if( a.y2 == b.y2 ) {
                  return a.x - b.x;
                }
                return a.y2 - b.y2;
            }
            return a.y1 - b.y1;
          }
        });

        int prevX = points.get(0).x;
        int i = 0;
        while( i < points.size())  {
          Pair p = points.get(i);
          int currX = p.x;
          long yCovered = coverY(activePoints);
          if( !p.closing ) {
            activePoints.add(p);
          }
          else {
            for( Pair point: activePoints ) {
              if( point.y1 == p.y1 && point.y2 == p.y2 ) {
                activePoints.remove(point);
                break;
              }
            }
          }
          area =(area + (yCovered*(currX-prevX))%MOD)%MOD;
          prevX = currX;
          i++;
        }

        return (int)area;
    }

    private long coverY( TreeSet<Pair> activePoints ) {
      long area = 0;
      int prevY = -1;
      for( Pair p: activePoints ) {
        int y1 = Math.max( p.y1, prevY );
        int y2 = p.y2;
        if( y2 > y1 ) {
          area += y2-y1;
          prevY = y2;
        }
      }
      return area;
    }


    static class Event implements Comparable<Event> {
        int x, y1, y2, type;
        Event(int x, int y1, int y2, int type) {
            this.x = x; this.y1 = y1; this.y2 = y2; this.type = type;
        }
        public int compareTo(Event other) {
            return this.x - other.x;
        }
    }

    public int rectangleAre2(int[][] rectangles) {
        int MOD = 1_000_000_007;
        List<Event> events = new ArrayList<>();
        for (int[] rect : rectangles) {
            // Entering event (left side of rectangle)
            events.add(new Event(rect[0], rect[1], rect[3], 1));
            // Leaving event (right side of rectangle)
            events.add(new Event(rect[2], rect[1], rect[3], -1));
        }
        // Sort events by x coordinate
        Collections.sort(events);

        // Use TreeMap to track active intervals (y1 to y2 with their counts)
        TreeMap<int[], Integer> active = new TreeMap<>(Comparator.comparingInt(a -> a[0]));

        long area = 0;
        int prevX = events.get(0).x;

        for (int i = 0; i < events.size(); ) {
            int currX = events.get(i).x;
            // Calculate total y covered by active intervals
            long y_covered = getTotalY(active);

            // Add area from previous x to current x
            area = (area + y_covered * (currX - prevX)) % MOD;

            // Process all events at this x
            while (i < events.size() && events.get(i).x == currX) {
                Event e = events.get(i);
                int[] key = new int[]{e.y1, e.y2};
                if (e.type == 1) {
                    // Add interval
                    active.put(key, active.getOrDefault(key, 0) + 1);
                } else {
                    // Remove interval
                    int cnt = active.getOrDefault(key, 0);
                    if (cnt == 1) {
                        active.remove(key);
                    } else {
                        active.put(key, cnt - 1);
                    }
                }
                i++;
            }
            prevX = currX;
        }
        return (int) area;
    }

    // Helper to calculate total length of the union of all active y-intervals
    private long getTotalY(TreeMap<int[], Integer> active) {
        long total = 0;
        int currStart = -1, currEnd = -1;
        for (int[] interval : active.keySet()) {
            int start = interval[0], end = interval[1];
            if (currEnd < start) {
                // No overlap, add last interval
                total += currEnd - currStart;
                currStart = start;
                currEnd = end;
            } else {
                // Overlapping, merge intervals
                currEnd = Math.max(currEnd, end);
            }
        }
        total += currEnd - currStart; // add the last interval
        return total;
    }
  
}



class Pair {
  int x;
  int y1;
  int y2;
  boolean closing;
  public Pair( int x, int y1, int y2, boolean closing ) {
      this.x = x;
      this.y1 = y1;
      this.y2 = y2;
      this.closing = closing;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Pair)) return false;
    Pair p = (Pair) o;
    return y1 == p.y1 && y2 == p.y2;
  }
  @Override
  public int hashCode() {
    return Objects.hash(y1, y2);
  }
}