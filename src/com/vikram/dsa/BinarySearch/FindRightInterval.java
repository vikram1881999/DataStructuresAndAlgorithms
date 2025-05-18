package com.vikram.dsa.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FindRightInterval {

  public static void main( String[] args ) {
    int[][] intervals = {{1,2},{2,3},{0,1},{3,4}};
    FindRightInterval findRightInterval = new FindRightInterval();
    System.out.println(Arrays.toString(findRightInterval.findRightInterval(intervals)));
  }
  public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        List<Pair> pairList = new ArrayList<>();
        int[] ans = new int[n];
        for( int i = 0; i < n; i++ ) {
            Interval interval = new Interval( intervals[i][0], intervals[i][1]);
            pairList.add( new Pair( i, interval));
        }
        Collections.sort(pairList, new Comparator<Pair>() {
            @Override
            public int compare( Pair A, Pair B ) {
                return A.interval.s - B.interval.s;
            }
        });
        for( int i = 0; i < n; i++) {
            int index = getIndex(pairList, pairList.get(i).interval.e);
            ans[pairList.get(i).i] = index;
        }

        return ans;
    }

    public int getIndex( List<Pair> pariList, int time ) {
        int l = 0;
        int h = pariList.size()-1;
        int pos = -1;
        while( l <= h ) {
            int m = (l+h)/2;
            Pair p = pariList.get(m);
            if( p.interval.s >= time ) {
                pos = p.i;
                h = m-1;
            }
            else {
                l = m+1;
            }

        }

        return pos;
    }
  
}

class Interval {
    int s;
    int e;
    public Interval( int s, int e ) {
        this.s = s;
        this.e = e;
    }
}

class Pair {
    int i;
    Interval interval;

    public Pair( int i, Interval interval ) {
        this.i = i;
        this.interval = interval;
    }
}