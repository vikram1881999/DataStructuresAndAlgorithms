package com.vikram.dsa.BinarySearch;

public class Hindex {

  public static void main( String[] args ) {
    int[] nums = {0,1,3,5,6};
    Hindex hindex = new Hindex();
    System.out.println( hindex.hIndex(nums));
  }

  public int hIndex(int[] citations) {
        int l = 0;
        int h = citations.length - 1;
        int ans = 0;
        while( l <= h ) {
            int m = (l+h)/2;
            if( citations[m] <= h-m+1 ) {
                ans = citations[m];
                l = m+1;
            }
            else {
                h = m-1;
            }
        }
        return ans;
    }
  
}
