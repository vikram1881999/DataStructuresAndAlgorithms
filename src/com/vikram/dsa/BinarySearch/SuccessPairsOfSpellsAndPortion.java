package com.vikram.dsa.BinarySearch;

public class SuccessPairsOfSpellsAndPortion {

  public static void main( String[] args  ){
    int[] spells = {5,1,3};
    int[] potions = {1,2,3,4,5};
    SuccessPairsOfSpellsAndPortion pairsOfSpellsAndPortion = new SuccessPairsOfSpellsAndPortion();
    System.out.println(pairsOfSpellsAndPortion.successfulPairs(spells, potions, 7));
  }

  public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = potions.length;
        int[] ans = new int[spells.length];
        for( int i = 0; i < spells.length; i++ ){
            ans[i] = getSuccessFullPair( potions, (int) Math.ceil((double) success / spells[i]));
        }
        return ans;
    }

    public int getSuccessFullPair( int[] potions, int k ) {
        int l = 0;
        int h = potions.length-1;
        int index = potions.length;
        while( l <= h ) {
            int m = (l+h)/2;
            if( potions[m] >= k ) {
                index = m;
                h = m-1;
            }
            else {
                l = m+1;
            }
        }

        return index;
    }
  
}
