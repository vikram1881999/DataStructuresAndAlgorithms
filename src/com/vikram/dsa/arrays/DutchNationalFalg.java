package com.vikram.dsa.arrays;

public class DutchNationalFalg {

  public static void main( String[] args  ){
    DutchNationalFalg dutchNationalFalg =  new DutchNationalFalg();
    int[] arr = {2,0,2,1,1,0};
    dutchNationalFalg.sortColors(arr);
  }


  public void sortColors(int[] nums) {
    int n = nums.length;
    int[] ans = new int[n];
    int i = 0;
    int j = n-1;
    for( int num: nums ) {
        if( num == 0 ) {
            ans[i] = num;
            i++; 
        }
        else if( num == 2 ) {
            ans[j] = num;
            j--;
        }
    }

    for( int k = i; k <= j; k++ ) {
        ans[k] = 1;
    }

    nums = ans;
}
  
}
