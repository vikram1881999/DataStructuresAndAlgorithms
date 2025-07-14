package com.vikram.dsa.dynamicprogramming;

import java.util.Arrays;
public class FindNumberOfLis {

  public static void main( String[] args ) {
    FindNumberOfLis findNumberOfLis = new FindNumberOfLis();
    int[] arr = {2,2,2,2,2};
    System.out.println(findNumberOfLis.findNumberOfLIS(arr));
  }


  public int findNumberOfLIS(int[] nums) {
    int n = nums.length;
    int[][] lis = new int[n][2];
    int maxLength = 1;
    int maxCount = 1;
    for( int i = n-1; i >= 0; i-- ) {
        int maxLen = 1;
        int  maxCnt = 1;
        for( int j = i+1; j < n; j++ ) {
            if( nums[j] > nums[i] ) {
                if( lis[i][0] < lis[j][0] + 1 ) {
                    lis[i][0] = lis[j][0] + 1;
                    lis[i][1] = lis[j][1];
                    maxLen = Math.max( maxLen, lis[i][0] );
                    maxCnt = Math.max( maxCnt, lis[i][1] );
                }
                else if(  lis[i][0] == lis[j][0] + 1 ) {
                    lis[i][1] += lis[j][1];
                    maxCnt = Math.max( maxCnt, lis[i][1] );
                }
            }
        }
        lis[i][0] = maxLen;
        lis[i][1] = maxCnt;
        if( maxLen > maxLength ){
            maxLength = maxLen;
            maxCount = maxCnt;
        }
        else if( maxLen == maxLength ) {
            maxCount += maxCnt;
        }
    }

    return maxCount;
}
  
}
