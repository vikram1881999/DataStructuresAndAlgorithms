package com.vikram.dsa.BinarySearch;

import java.util.HashMap;
import java.util.Map;

public class OnlineElection {

  public static void main( String[] args ) {
    int[] p = {0, 1, 1, 0, 0, 1, 0};
    int[] t = {0, 5, 10, 15, 20, 25, 30};
    OnlineElection election = new OnlineElection(p, t);
    System.out.println(election.q(8));
  }
  

  int[] persons;
    int[] times;
    int[] majority;
    public OnlineElection(int[] persons, int[] times) {
        this.persons = persons;
        this.times = times;
        this.majority = calculateMajority( persons );
    }

    public int[] calculateMajority( int[] persons ) {
        int majority = -1;
        int[] winner = new int[persons.length];
        Map<Integer, Integer> countMap = new HashMap<>();
        countMap.put(majority, -1);
        for( int i = 0; i < persons.length; i++ ){
            countMap.put(persons[i], countMap.getOrDefault(persons[i], 0) + 1);
            int c = countMap.get(persons[i]);
            if( c >= countMap.get(majority) ) {
                majority = persons[i];
            }
            winner[i] = majority;
        }

        return winner;
    }
    
    public int q(int t) {
        int l = 0;
        int h = majority.length-1;
        int winner = 0;
        while( l <= h ) {
            int m = (l+h)/2;
            if( times[m] <= t ) {
                winner = majority[m];
                l = m+1;
            }
            else {
                h = m-1;
            }
        }

        return winner;
    }
}
