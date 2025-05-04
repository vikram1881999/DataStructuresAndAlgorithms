package com.vikram.dsa.dynamicprogramming;

public class MergeStones {
  public static void main( String[] args ) {
    int[] arr = {3,5,1,2,6};
    MergeStones mergeStones = new MergeStones();
    System.out.println(mergeStones.mergeStones(arr, 3));
  }

  public int mergeStones(int[] stones, int k) {
        if ((stones.length - 1) % (k - 1) != 0)
          return -1;
        int[] pf = new int[stones.length];
        pf[0] = stones[0];
        for( int i = 1; i < stones.length; i++ ) {
            pf[i] = pf[i-1] + stones[i];
        }
        return mergeStones( pf, 0, stones.length-1, k);
    }

    private int mergeStones( int[] stones, int i, int j, int x ) {
        if( j-i+1 < x ){
          return 0;
        }
        int minCost = Integer.MAX_VALUE;
        for( int k = i; k < j; k += x-1 ) {
            int left = mergeStones( stones, i, k, x);
            int right = mergeStones( stones, k+1, j, x);
            int mergeCost = left + right;
            if(  (j-i)%(x-1) == 0 ) {
              if( i == 0 ) {
                mergeCost += stones[j];
              }
              else {
                mergeCost += stones[j] - stones[i-1];
              }
            }
            minCost = Math.min(mergeCost, minCost);            
        }

        return minCost;
    }
  
}


class Pair {
    int cost;
    int element;
    public Pair( int cost, int element) {
        this.cost = cost;
        this.element = element;
    }
}