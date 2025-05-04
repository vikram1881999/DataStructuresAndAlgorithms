package com.vikram.dsa.heaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class OptimiziingBox {

  public static void main( String[] args ) {
    List<Integer> list = List.of(5,5,5,5,5,5);
    OptimiziingBox box = new OptimiziingBox();
    System.out.println(box.minimalHeaviestSetA(list));
  }

   public static List<Integer> minimalHeaviestSetA(List<Integer> arr) {
        int sum1 = 0;
        int sum2 = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>( new Comparator<Integer>() {
            @Override
            public int compare( Integer A, Integer B) {
                return B-A;
            }
        });
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>( new Comparator<Integer>() {
            @Override
            public int compare( Integer A, Integer B) {
                return A-B;
            }
        });
        
        for( int i = 0; i < arr.size(); i++ ) {
            int ele = arr.get(i);
            if( maxHeap.isEmpty()) {
                maxHeap.add(ele);
                sum1 += ele;
            }
            else {
                if( maxHeap.peek() > ele ) {
                    maxHeap.add(ele);
                    sum1 += ele;
                }
                else {
                    minHeap.add(ele);
                    sum2 += ele;
                }
                if( minHeap.size() > maxHeap.size() ) {
                    int popele = minHeap.poll();
                    maxHeap.add(popele);
                    sum1 += popele;
                    sum2 -= popele;
                }
                if( maxHeap.size() - minHeap.size() > 1 ) {
                    int popele = maxHeap.poll();
                    minHeap.add(popele);
                    sum1 -= popele;
                    sum2 += popele;
                }
            }
        }
        
         while( true ) {
           int ele = minHeap.peek();
           if( sum1 + ele < sum2-ele ) {
            minHeap.poll();
            sum1 += ele;
            sum2 -= ele;
           }
           else {
            break;
           }
        }
        
        List<Integer> ans = new ArrayList<>();
        while( !minHeap.isEmpty() ) {
            ans.add(minHeap.poll());
        }
        
        return ans;

    }
  
}
