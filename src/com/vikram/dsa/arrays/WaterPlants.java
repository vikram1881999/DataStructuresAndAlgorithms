package com.vikram.dsa.arrays;

public class WaterPlants {
  
  public static void main( String[] args ) {
    WaterPlants plants = new WaterPlants();
    int[] arr = {7,7,7,7,7,7,7};
    System.out.println( plants.minimumRefill(arr, 8, 7));
  }

  public int minimumRefill(int[] plants, int capacityA, int capacityB) {
    int A = capacityA;
    int B = capacityB;
    int fill = 0;
    int i = 0;
    int j = plants.length-1;
    while( i <= j ) {
        if( A >= plants[i] ) {
            A -= plants[i];
            plants[i] = 0;
        }
        else {
            A = capacityA;
            plants[i] = 0;
            fill++;
        }
        if( B >= plants[j] ) {
            B -= plants[j];
            plants[j] = 0;
        }
        else {
            B = capacityB;
            plants[j] = 0;
            fill++;
        }
        i++;
        j--;
    }


    return fill;
}

}
