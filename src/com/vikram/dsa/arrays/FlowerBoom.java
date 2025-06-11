package com.vikram.dsa.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FlowerBoom {

  public static void main( String[] args ) {
    int[][] flowers = {{19,37},{19,38},{19,35}};
    int[]people = {6,7,21,1,13,37,5,37,46,43};
    FlowerBoom flowerBoom = new FlowerBoom();
    System.out.println(flowerBoom.fullBloomFlowers(flowers, people));
  }


  public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int n = people.length;
        int[] ans = new int[n];
        List<int[]> flowersList = new ArrayList<>();
        for( int[] flower: flowers) {
          flowersList.add(flower);
        }
        Collections.sort(flowersList, new Comparator<int[]>() {
          @Override
          public int compare(int[] A, int[] B)  {
            if( A[0] == B[0] ) {
              return A[1] - B[1];
            }
            return A[0]-B[0];
          }
        });

        for( int i = 0; i < n; i++ ) {
            int low = getLowerBound(flowersList, people[i]);
            int high = getHigherBound( flowersList, people[i]);
            ans[i] =   low - high + 1;
        }

        return ans;
    }

    public int getLowerBound( List<int[]> flowersList, int val ) {
        int l = 0;
        int h = flowersList.size()-1;
        while( l <= h ) {
            int m = (l+h)/2;
            if( flowersList.get(m)[0]<= val ) {
                l = m+1;
            }
            else {
                h = m-1;
            }
        }
        return h;
    }

    public int getHigherBound( List<int[]> flowersList, int val ) {
        int l = 0;
        int h = flowersList.size()-1;
        while( l <= h ) {
            int m = (l+h)/2;
            if( flowersList.get(m)[1] >= val ) {
                h = m-1;
            }
            else {
                l = m+1;
            }
        }
        return l;
    }
  
}
