package com.vikram.dsa.arrays;

import java.util.ArrayList;
import java.util.List;

public class MinSwaps {

  public static void main(String[] args) {
    List<Integer> integerList = new ArrayList<>(List.of(4,23,3,23,4,1,34,1,4,1,245,1,23,3,5,1,4,14,24,21,43,45));
    MinSwaps minSwaps = new MinSwaps();
    System.out.println(minSwaps.solve( integerList, 3));
  }
  
  public int solve(List<Integer> A, int B) {
        int c = 0;
        int swaps = 0;
        int minSwaps = A.size();
        for( int i = 0; i < A.size(); i++) {
            if( A.get(i) <= B ) {
                c++;
            }
        }
        if( c <=1 ) return 0;
        for( int i = 0; i < c; i++ ) {
            if( A.get(i) > B )  {
                swaps++;
            }
        }
        minSwaps = swaps;

        for( int i = 1; i <= A.size() - c; i++ ) {
            if( A.get(i-1) > B ) {
                swaps -= 1;
            }
            if( A.get(i+c-1) > B ) {
                swaps += 1;
            }
            minSwaps = Math.min(minSwaps, swaps);
        }

        return minSwaps;
    }
}
