package com.vikram.dsa.arrays;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {

  public static void main( String[] args ) {
    int[][] arr = {{6037774, 6198243}, {6726550, 7004541}, {8842554, 10866536}, {11027721, 11341296}, {11972532, 14746848}, {16374805, 16706396}, {17557262, 20518214}, {22139780, 22379559}, {27212352, 28404611}, {28921768, 29621583}, {29823256, 32060921}, {33950165, 36418956}, {37225039, 37785557}, {40087908, 41184444}, {41922814, 45297414}, {48142402, 48244133}, {48622983, 50443163}, {50898369, 55612831}, {57030757, 58120901}, {59772759, 59943999}, {61141939, 64859907}, {65277782, 65296274}, {67497842, 68386607}, {70414085, 73339545}, {73896106, 75605861}, {79672668, 84539434}, {84821550, 86558001}, {91116470, 92198054}, {96147808, 98979097}};
    MergeIntervals mergeIntervals = new MergeIntervals();
    System.out.println(mergeIntervals.mergeIntervals(arr, 36210193,61984219));
  }

  public List<List<Integer>> mergeIntervals( int[][] intervals, int s, int e ) {
    List<List<Integer>> mergedIntervals = new ArrayList<>();
    for( int i = 0; i < intervals.length; i++ ) {
      int x = intervals[i][0];
      int y = intervals[i][1];
      if( s <= y ) {
        if( e < x ) {
         List<Integer> interval = new ArrayList<>();
         interval.add(s);
         interval.add(e);
         mergedIntervals.add(interval);
         s = x;
         e = y;
        }
        else {
          s = Math.min(s, x);
          e = Math.max(e, y);
        }
      }
      else {
        List<Integer> interval = new ArrayList<>();
        interval.add(x);
        interval.add(y);
        mergedIntervals.add(interval);
      }
    }

    List<Integer> interval = new ArrayList<>();
    interval.add(s);
    interval.add(e);
    mergedIntervals.add(interval);

    return mergedIntervals;
  }
  
}
