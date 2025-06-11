package com.vikram.dsa.Hashing;

import java.util.HashMap;
import java.util.Map;

public class TupleWithSameProduct {

  public static void main( String[] args ) {
    int[] arr = {2,3,4,6,8,12};
    TupleWithSameProduct tupleWithSameProduct = new TupleWithSameProduct();
    System.out.println(tupleWithSameProduct.tupleSameProduct(arr));
  }

  public int tupleSameProduct(int[] nums) {
        int ans = 0;
        int n = nums.length;
        if (n < 4) {
            return 0;
        }

        Map<Integer, Integer> productCountMap = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int product = nums[i] * nums[j];
                productCountMap.put(product, productCountMap.getOrDefault(product, 0) + 1);
            }
        }

        for (int count : productCountMap.values()) {
            if (count > 1) {
                ans += count * (count - 1) * 4;
            }
        }

        return ans;
    }
}
