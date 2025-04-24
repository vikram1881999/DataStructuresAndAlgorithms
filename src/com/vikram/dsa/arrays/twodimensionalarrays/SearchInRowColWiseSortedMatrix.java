package com.vikram.dsa.arrays.twodimensionalarrays;

public class SearchInRowColWiseSortedMatrix {

  public static void main(String[] args ) {
    SearchInRowColWiseSortedMatrix colWiseSortedMatrix = new SearchInRowColWiseSortedMatrix();
    int[][] arr = {{5,6,11,12,14}, {7,8, 13, 15, 16}, {9,10,14,18,21}, {17, 25, 34, 42, 50}, {20, 29, 40, 47, 51}, {22, 30, 41, 48, 52}, {24, 31, 42, 49, 53}};
    System.out.println(colWiseSortedMatrix.findElement(arr, 22));
  }


  public boolean findElement( int[][] arr, int k  ) {
    int i = 0;
    int j = arr[0].length-1;
    while( i < arr.length && j >= 0 ) {
      if( arr[i][j] == k ) {
        return true;
      }
      if( arr[i][j] < k)  {
        i++;
      }
      else if( arr[i][j] > k ) {
        j--;
      }
    }

    return false;
  }
  
}
