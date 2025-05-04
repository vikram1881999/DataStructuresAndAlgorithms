package com.vikram.dsa.heaps;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class SlindingWindowMedian {

  public static void main( String[] args)  {
    int[] nums = {1,2,3,4,2,3,1,4,2};
    SlindingWindowMedian slindingWindowMaximum = new SlindingWindowMedian();
    System.out.println( Arrays.toString( slindingWindowMaximum.medianSlidingWindow(nums, 3)));
  }

  static int elementCountMaxHeap = 0;
  static int elementCountMinHeap = 0;
  public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] answer = new double[n-k+1];
        TreeMap<Integer, Integer> maxHeap = new TreeMap<>( new Comparator<Integer>() {
            @Override
            public int compare( Integer a, Integer b) {
                return b-a;
            }
        });

        TreeMap<Integer, Integer> minHeap = new TreeMap<>( new Comparator<Integer>() {
            @Override
            public int compare( Integer a, Integer b) {
                return a-b;
            }
        });

        for( int i = 0; i < k; i++ ) {
            int num = nums[i];
            insert(num, minHeap, maxHeap);
        }
        answer[0] = median(minHeap, maxHeap, k);

        for( int i = 1; i <= n-k; i++ ) {
          insert(nums[i+k-1], minHeap, maxHeap);
          removeElement(nums[i-1], minHeap, maxHeap);
          answer[i] = median(minHeap, maxHeap, k);
        }

        return answer;
    }

    public void removeElement( int num, TreeMap<Integer, Integer> minHeap, TreeMap<Integer, Integer> maxHeap ) {
        if( minHeap.containsKey(num) ) {
          if( minHeap.get(num) == 1 ) {
            minHeap.remove(num);
          }
          else {
            minHeap.put(num, minHeap.getOrDefault(num, 0) - 1);
          }
          elementCountMinHeap--;
        }
        else if( maxHeap.containsKey(num) ) {
          if( maxHeap.get(num) == 1 ) {
            maxHeap.remove(num);
          }
          else {
            maxHeap.put(num, maxHeap.getOrDefault(num, 0) - 1);
          }
          elementCountMaxHeap--;
        }
        balanceHeaps(minHeap, maxHeap);
    }

    public void insert(int num, TreeMap<Integer, Integer> minHeap, TreeMap<Integer, Integer> maxHeap ) {
        if( maxHeap.isEmpty() ) {
            maxHeap.put(num, 1);
            elementCountMaxHeap++;
            return;
        }
        if( num < maxHeap.firstEntry().getKey() ) {
            elementCountMaxHeap++;
            maxHeap.put(num, maxHeap.getOrDefault(num, 0) + 1);
        }
        else {
            minHeap.put(num, minHeap.getOrDefault(num, 0) + 1);
            elementCountMinHeap++;
        }
       balanceHeaps(minHeap, maxHeap);
    }

    public void balanceHeaps( TreeMap<Integer, Integer> minHeap, TreeMap<Integer, Integer> maxHeap ) {
       if((elementCountMaxHeap - elementCountMinHeap) > 1 ) {
            minHeap.put(maxHeap.firstEntry().getKey(), minHeap.getOrDefault(maxHeap.firstEntry().getKey(),0) + 1);
            if( maxHeap.firstEntry().getValue() == 1) {
              maxHeap.remove(maxHeap.firstEntry().getKey());
            }
            else {
              maxHeap.put(maxHeap.firstEntry().getKey(), maxHeap.firstEntry().getValue()-1);
            }
            elementCountMaxHeap--;
            elementCountMinHeap++;
        }
        else if( elementCountMinHeap > elementCountMaxHeap) {
            maxHeap.put(minHeap.firstEntry().getKey(), maxHeap.getOrDefault(minHeap.firstEntry().getKey(),0) + 1);
            if( minHeap.firstEntry().getValue() == 1) {
              minHeap.remove(maxHeap.firstEntry().getKey());
            }
            else {
              minHeap.put(minHeap.firstEntry().getKey(), minHeap.firstEntry().getValue()-1);
            }
            elementCountMaxHeap++;
            elementCountMinHeap--;
        }
    }

    public double median( TreeMap<Integer, Integer> minHeap,  TreeMap<Integer, Integer> maxHeap , int k ) {
        if( k%2 == 0 ) {
            return ((double)maxHeap.firstEntry().getKey() + (double)minHeap.firstEntry().getKey())/2.0;
        }
        return maxHeap.firstEntry().getKey();
    }
  
}
