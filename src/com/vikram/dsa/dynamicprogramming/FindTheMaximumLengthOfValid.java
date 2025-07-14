package com.vikram.dsa.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindTheMaximumLengthOfValid {

  public static void main( String[] args ) {
    FindTheMaximumLengthOfValid findTheMaximumLengthOfValid = new FindTheMaximumLengthOfValid();
    int[] num = { 1,4,2,3,1,4 };
    System.out.println( findTheMaximumLengthOfValid.maximumLength(num, 3));
  }

  public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        List<SuperPair> superPairs = new ArrayList<>();
        for( int i = 1; i < n; i++ ) {
            int sum = nums[i] + nums[i-1];
            SuperPair p = new SuperPair( i-1, i, sum );
            superPairs.add(p);
        }
        int[] parent = new int[superPairs.size()];
        int[] dp = new int[superPairs.size()];
        int size = dp.length;
        for( int i = 0; i < size; i++ ) {
            dp[i] = 1;
            SuperPair p1 = superPairs.get(i);
            parent[i] = i;
            for( int j = 0; j < i; j++ ) {
                SuperPair p2 = superPairs.get(j);
                if( p1.sum%k == p2.sum%k &&  ( p1.x == p2.y || p1.sum%k == (nums[p1.y] + nums[p2.x])%k) ) {
                    if( dp[i] < dp[j] + 1 ) {
                        dp[i] = dp[j] + 1;
                        parent[i] = j;
                    }
                }
            }
        }

        int maxLength = 0;
        int index = -1;
        for( int i = 0; i < dp.length; i++ ) {
            if( dp[i] > maxLength ) {
                maxLength = dp[i];
                index = i;
            }   
        }
        HashSet<Integer> set = new HashSet<>();
        while( index !=  parent[index] ) {
            SuperPair p = superPairs.get(index);
            set.add( p.x );
            set.add( p.y );
            index = parent[index];
        }
        SuperPair p = superPairs.get(index);
        set.add( p.x );
        set.add( p.y );

        return set.size();
    }
  
}


class SuperPair {
  int x;
  int y;
  int sum;
  public SuperPair( int x, int y, int sum ) {
      this.x = x;
      this.y = y;
      this.sum = sum;
  }
}