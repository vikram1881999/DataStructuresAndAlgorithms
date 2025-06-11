package com.vikram.dsa.arrays;

public class PartitionArrayAccordingToPivot {

  public static void main( String[] args ) {
    PartitionArrayAccordingToPivot partitionArrayAccordingToPivot = new PartitionArrayAccordingToPivot();
    int[] arr = {9,12,5,10,14,3,10};
    System.out.println( partitionArrayAccordingToPivot.pivotArray(arr, 10));
  }

  public int[] pivotArray(int[] nums, int pivot) {
    int n = nums.length;
    int[] ans = new int[n];

    int countLess = 0;
    int pivotCount = 0;
    for( int num: nums ) {
        if( num < pivot) {
            countLess++;
        }
        if( num == pivot ) {
            pivotCount++;
        }
    }

    for( int i = 1; i <= pivotCount; i++) {
        int index = countLess;
        ans[index] = pivot;
        countLess++;
    }

    int lessIndex = 0;
    int greaterIndex = countLess;
    for( int num: nums ) {
        if( num < pivot ) {
            ans[lessIndex] = num;
            lessIndex++;
        }
        else if( num > pivot ) {
            ans[greaterIndex] = num;
            greaterIndex++;
        }
    }

    return ans;
}
  
}
