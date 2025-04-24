package com.vikram.dsa.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class lexicographicalSubsets {

  public static void main( String[] args ) {

    lexicographicalSubsets lexicographicalSubsets = new lexicographicalSubsets();
    System.out.println(lexicographicalSubsets.subsets(new ArrayList<>(List.of(1,2,3))));
  }

   public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        Collections.sort(A);
        ArrayList<Integer>  B = new ArrayList<>();
        ArrayList<ArrayList<Integer>> subSets = new  ArrayList<ArrayList<Integer>>();
        addSubsets(A, 0, 0, B, subSets);
        return subSets;
    }
    public void addSubsets( ArrayList<Integer> A, int j, int k, ArrayList<Integer> B, ArrayList<ArrayList<Integer>> subSets  ) {

        if( j == A.size() ) {
            subSets.add(B);
            return;
        }
        subSets.add(B);
        for( int i = j; i < A.size(); i++) {
            B.add(A.get(i));
            addSubsets( A, i+1, k+1, new ArrayList<Integer>(B), subSets );
            B.remove(k);
        }
    }
  
}
