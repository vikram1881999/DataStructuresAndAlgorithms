package com.vikram.dsa.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class SpecialOffers {


  public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return shoppingOffers( price, special, needs, special.size()-1 );
    }

    public int shoppingOffers( List<Integer> price, List<List<Integer>> special, List<Integer> needs, int i ) {
        if( i < 0 ) {
            int cost = 0;
            for( int j = 0; j < price.size(); j++ ) {
                cost += price.get(j) * needs.get(j);
            }
            return cost;
        }

        boolean canApplyOffer = true;
        List<Integer> currentOffer = special.get(i);
        int n = currentOffer.size();
        List<Integer> updatedNeeds = new ArrayList<>();
        for( int j = 0; j < needs.size(); j++ ) {
            if( currentOffer.get(j) > needs.get(j) ) {
                canApplyOffer = false;
                break;
            }
            updatedNeeds.add(needs.get(j) - updatedNeeds.get(j));
        }
        int minCost = shoppingOffers( price, special, needs, i-1 );
        if( canApplyOffer ){
            minCost = Math.min( minCost, shoppingOffers( price, special, updatedNeeds, i-1) + currentOffer.get(n-1));
        }

        return minCost;
    }
  
}
