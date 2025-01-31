package com.vikram.dsa.arrays.twodimensionalarrays;

public class PrintAllDiagonals {

    public static void main( String[] args ) {
        PrintAllDiagonals printAllDiagonals = new PrintAllDiagonals();
        int arr[][] = {{1,2,3,4,5},
                        {6,7,8,9,10},
                    {11,12,13,14,15}};
        printAllDiagonals.printAllDiagonals(arr);

    }

    public void printAllDiagonals( int[][] arr ) {
        int n = arr.length;
        int m = arr[0].length;
        for( int i = m-1; i >= 0; i-- ) {
            int j = 0;
            int k = i;
            while( j < n && k >= 0 ) {
                System.out.print(arr[j][k]);
                j++;
                k--;
            }
            System.out.println();
        }

        for( int i = 1; i < n; i++) {
            int j = i;
            int k = m-1;
            while( j < n && k > 0 ) {
                System.out.print(arr[j][k]);
                j++;
                k--;
            }
            System.out.println();
        }
    }
}
