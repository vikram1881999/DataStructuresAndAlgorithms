package com.vikram.dsa.arrays.carryforward;

/**
 * Given an array count pairs such that i < j  s[i] = 'a' and s[j] = 'g'
 */
public class PairCarryForward {

    public static void main(String[] args) {
        PairCarryForward obj = new PairCarryForward();
        String str = "adgagagfg";
        System.out.println(obj.countPairs(str));
        System.out.println(obj.countPairs2(str));
        System.out.println(obj.countPairs3(str));
    }

    // TC -> O(N^2)
    // SC -> O(N)
    // Brute Force
    public int countPairs(String str) {
        int c = 0;
        for( int i = 0; i < str.length(); i++) {
            if( str.charAt(i) == 'a' ) {
                for( int j = i + 1; j < str.length(); j++) {
                    if( str.charAt(i) == 'a' && str.charAt(j) == 'g') {
                        c++;
                    }
                }
            }
        }
        return c;
    }

    // TC-> O(N)
    // IDEA -> carry forward
    public int countPairs2(String str) {
        int c = 0;
        int sum = 0;
        for( int i = 0; i < str.length(); i++) {
            if( str.charAt(i) == 'a' ) {
                c++;
            }
            if( str.charAt(i) == 'g' ) {
                sum = sum + c;
            }
        }
        return sum;
    }

    // TC-> O(N)
    // IDEA -> carry forward
    public int countPairs3(String str) {
        int c = 0;
        int sum = 0;
        for( int i = str.length()-1; i >= 0; i--) {
            if( str.charAt(i) == 'a' ) {
                sum = sum + c;
            }
            if( str.charAt(i) == 'g' ) {
                c++;
            }
        }
        return sum;
    }
}
