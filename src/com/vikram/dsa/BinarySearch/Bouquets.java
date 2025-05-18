package com.vikram.dsa.BinarySearch;

public class Bouquets {

  public static void main( String[] args ) {
    Bouquets bouquets = new Bouquets();
    int[] arr = {1,10,3,10,2};
    System.out.println( bouquets.minDays(arr, 3, 2));
  }


  public int minDays(int[] bloomDay, int m, int k) {
    Pair minMaxP = getMinMax( bloomDay);
    int l = minMaxP.min;
    int h = minMaxP.max;
    int ans = h;
    while( l <= h ) {
        int mid = (l+h)/2;
        int bouqets = getBouquets(bloomDay, mid, k );
        if( bouqets >= m ) {
            ans = bouqets;
            h = mid-1;
        }
        else {
            l = mid+1;
        }
    }

    return ans;
}

private int getBouquets(int[] bloomDay, int day, int k ) {
    int c = 0;
    int sum = 0;
    for( int i = 0; i < k; i++ ) {
        if( bloomDay[i] <= day ) {
            sum += 1;
        }
    }
    if( sum == k ) {
        c++;
    }
    for( int i = 1; i <= bloomDay.length - k; i++ ) {
        if( bloomDay[i-1] <= day) {
            sum -= 1;
        }
        if( bloomDay[i+k-1] <= day ) {
            sum += 1;
        }
        if( sum == k ) {
            c++;
        }
    }

    return c;
}   

private Pair getMinMax( int[] bloomDay ) {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for( int i = 0; i < bloomDay.length; i++ ) {
        min = Math.min( bloomDay[i], min);
        max = Math.max( bloomDay[i], max );
    }

    return new Pair( min, max );
}
  
}


class Pair {
  int min;
  int max;
  public Pair( int min, int max ) {
      this.min = min;
      this.max = max; 
  }
}