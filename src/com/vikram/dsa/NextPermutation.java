package com.vikram.dsa;

import java.util.ArrayList;
import java.util.List;

public class NextPermutation {

  public static void main( String[] args ) {
    NextPermutation nextPermutation  = new NextPermutation();
    int[] arr = {2,1,4,5,3,0,0};
    nextPermutation.nextPermutation(arr);
  }


  public void nextPermutation(int[] nums) {
        int n = nums.length;
        int index = -1;
        for( int i = n-2; i >= 0; i-- ) {
            if( nums[i] >= nums[i+1] ) {
                continue;
            }
            else {
                index = i;
                break;
            }
        }

        List<Integer> elementsAfterPivot = new ArrayList<>();
        boolean swapped = false;
        for( int i = n-1; i > index; i-- ) {
            if( index >= 0 && !swapped && nums[i] > nums[index] ) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                swapped = true;
            }
            elementsAfterPivot.add( nums[i] );
        }

        for( int i = index + 1; i < n; i++ ) {
            nums[i] = elementsAfterPivot.get( i - index-1);
        }

    }
  
}
