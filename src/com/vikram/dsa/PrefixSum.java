package com.vikram.dsa;


// Given N array elements and. Q queries [l, r]
public class PrefixSum {

  int[] arr = { -3, 6, 2, 4, 5, 2, 8, -9, 3 ,1  };
  {-3 , 3, 5, 9, 14, 16, 24, 15, 18, 19}
  int[][] q = {{4, 8}, {3, 7}, {1, 3}, { 0, 4 }, { 6, 9}, { 7, 7}}; -> N *Q


  int[] ans  = {};

  int[] cummaltiveSum = new int[n];
  cummaltiveSum[0] = arr[0];
  for( i = 1; i < n; i++ ) {
    cummaltiveSum[i]= cummaltiveSum[i-1] + arr[i];
  }

  for( int i = 0;  i < q.length; i++ ) {
    int l = q[i][0];
    int r = q[i][1];
    if ( l == 0) {
      ans[i] = cummaltiveSum[r];
    }
    else {
      ans[i] = cummaltiveSum[r] - cummaltiveSum[l-1];
    }

  }

  l,r -> l == 0 cummaltiveSum[r];
         else 
         cummaltiveSum[r] - cummaltiveSum[l-1];


  //
  6 
  8
   -> 14
  14 - 6 = 8;

  6, 15, 25, 31, 42, 57, 69
}


1 , 2, 3, 4, 5, 6
1, 3, 6, 10, 15, 21


// Equillibrium Index 
// Given N array of elements, count no of equillibrium index, index i is considered equillibrium index sum of all elments before ith index == sum all elemets after ith index 

arr[4] = { -3, 2, 4, -1 };