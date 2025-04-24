package com.vikram.dsa.arrays.twodimensionalarrays;

public class SumAllSubMatrices {

  public static void main( String[] args ) {
    int[][] mat1= {{1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}};
    SumAllSubMatrices sumAllSubMatrices = new SumAllSubMatrices();
    System.out.println(sumAllSubMatrices.getSumAllSubMatrices(mat1));
  }

  public int getSumAllSubMatrices(int[][] arr ) {
    int n = arr.length;
    int m = arr[0].length;
    int ans = 0;
    for( int i = 0; i < n; i++ ) {
      for( int j = 0; j < m; j++ ) {
        int contributionOfCurr = arr[i][j] * (i+1) * (j+1) * (n-i) * (n-j);
        ans = ans + contributionOfCurr;
      }
    }
    return ans;
  }
  
}
