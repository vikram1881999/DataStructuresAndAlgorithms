package com.vikram.dsa.arrays;

import java.util.ArrayList;
import java.util.List;

public class MergeOverlappingIntervals {

  public static void main( String[] args ) {
    List<Interval> intervals = new ArrayList<>();
    intervals.addAll(List.of( new Interval(1, 3), new Interval(4, 6), new Interval(7, 9), new Interval(8, 11), new Interval(10, 14), new Interval(12, 13), new Interval(15, 16)));
    MergeOverlappingIntervals mergeOverlappingIntervals = new MergeOverlappingIntervals();
    System.out.println(mergeOverlappingIntervals.mergeOverlappingIntervals(intervals));
  }

  public List<Interval> mergeOverlappingIntervals( List<Interval> intervals ) {
    List<Interval> mergedIntervals = new ArrayList<>();
    if( intervals.size() <= 1) {
      return intervals;
    }
    Interval pivotInterval = new Interval(intervals.get(0).start,intervals.get(0).end);
    for( int i = 1; i < intervals.size(); i++ ) {
      Interval currentInterval = intervals.get(i);
      if( pivotInterval.start <= currentInterval.end ) {
        if( pivotInterval.end < currentInterval.start ) {
          mergedIntervals.add(pivotInterval);
          pivotInterval = new Interval(currentInterval.start, currentInterval.end);
        }
        else {
          pivotInterval.start = Math.min(pivotInterval.start, currentInterval.end);
          pivotInterval.end = Math.max(pivotInterval.end, currentInterval.end);
        }
      }
      else {
        mergedIntervals.add(currentInterval);
      }
    }

    mergedIntervals.add(pivotInterval);

    return mergedIntervals;
  }
  
}

class Interval {
  int start;
  int end;
  public Interval(int start, int end) {
    this.start = start;
    this.end = end;
  }
}