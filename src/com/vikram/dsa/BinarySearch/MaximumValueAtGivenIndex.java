package com.vikram.dsa.BinarySearch;

public class MaximumValueAtGivenIndex {


  public static void main( String[] args ) {
    MaximumValueAtGivenIndex atGivenIndex = new MaximumValueAtGivenIndex();
    System.out.println( atGivenIndex.maxValue(7,0, 8));
  }

  public int maxValue(int n, int index, int maxSum) {
    long l = 1;
    long h = maxSum;
    long ans = 0;
    while( l <= h ) {
      long m = (l+h)/2;
      long left = index;
      long right = n - index -1;
      long sum = m*(m-1)/2;
      long rightSum = sum;
      long leftSum = sum;
      if( m-1 < right ) {
        rightSum  += ( right - m + 1 );
      }
      if( m-1 < left  ) {
        leftSum += ( left - m + 1 );
      }
      if( m-1 > right ) {
        rightSum -= (m-1-right)*(m-right)/2;
      }
      if ( m - 1 > left ) {
        leftSum -= (m-1-left)*(m-left)/2;
      }

      if( leftSum + m + rightSum > maxSum ) {
        h = m-1;
      }
      else {
        l = m+1;
        ans = m;
      }
    }
    return (int)ans;
}
  
}
