package com.vikram.dsa.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {


  public static void main( String[] args ){
    int[] nums = {22,1,74,51,18,38,9,44,88,12};
    LargestDivisibleSubset divisibleSubset = new LargestDivisibleSubset();
    System.out.println(    divisibleSubset.largestDivisibleSubset(nums));
  } 

   public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        
        int n = nums.length;
        int[] lis = new int[n];
        int[] parent = new int[n];
        int maxLength = 0;
        List<Integer> answer = new ArrayList<>();

        for( int i = 0; i < n; i++ ){
            int len = 1;
            parent[i] = i;
            for( int j = 0; j < i; j++ ) {
                if( nums[i] % nums[j] == 0  && lis[j] + 1 > len ) {
                    len = lis[j] + 1;
                    parent[i] = j;
                }
            }
            maxLength = Math.max( maxLength, len );
            lis[i] = len;
        }

        int index = -1;
        for( int i = 0; i < n; i++ ) {
            if( maxLength == lis[i] ) {
                index = i;
                break;
            }
        }

        while( parent[index] != index) {
          answer.add(nums[index]);
          index = parent[index];
        }
        answer.add(nums[index]);

        return answer;
    }
  
}
