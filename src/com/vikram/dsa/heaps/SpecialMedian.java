package com.vikram.dsa.heaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class SpecialMedian {

  public static void main( String[] args ) {
    List<Integer> list = List.of(6,5,8,4);
    SpecialMedian median = new SpecialMedian();
    System.out.println( median.solve(new ArrayList<>(list)));
  }

  public int solve(ArrayList<Integer> A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>( new Comparator<Integer>(){
            @Override
            public int compare( Integer a, Integer b ) {
                return b-a;
            }
        });

        PriorityQueue<Integer> minHeap = new PriorityQueue<>( new Comparator<Integer>(){
            @Override
            public int compare( Integer a, Integer b ) {
                return a-b;
            }
        });

       for( int i = 0; i < A.size(); i++ ){
           int ele = A.get(i);
           if( map.get(ele) == null ) {
               map.put( ele, 1 );
           }
           else {
               int c = map.get(ele);
               c+=1;
               map.put(ele,c);
           }
       }

       for( int i = A.size() - 1; i >= 0; i-- ) {
           if( maxHeap.isEmpty() ) {
               maxHeap.add(A.get(i));
               continue;
           }
           if( maxHeap.peek() < A.get(i) ) {
               minHeap.add(A.get(i));
           }
           else {
               maxHeap.add(A.get(i));
           }
           if( maxHeap.size() - minHeap.size() > 1 ) {
               int ele = maxHeap.remove();
               minHeap.add(ele);
           }
           if( minHeap.size() > maxHeap.size() ) {
               int ele = minHeap.remove();
               maxHeap.add(ele);
           }
          if( i != 0 ){
             if( ( minHeap.size() + maxHeap.size())%2 == 0 ) {
               if( ( minHeap.peek() + maxHeap.peek())/2 == A.get(i-1) ){
                   return 1;
               }
           }
           if((minHeap.size() + maxHeap.size())%2 == 1 ) {
               if( minHeap.peek() == A.get(i-1) ){
                   return 1;
               }
           }
          }
        }
        if( A.size()%2 == 1 ) {
           if( map.get(minHeap.peek()) >= 2 ) {
               return 1;
           }
        }


       return 0;
    }
  
}
