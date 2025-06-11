package com.vikram.dsa.dynamicprogramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BestTeamScore {


  public static void main( String[] args ) {
    BestTeamScore bestTeamScore = new BestTeamScore();
    int[] scores = {1,3,7,3,2,4,10,7,5};
    int[] ages = {4,5,2,1,1,2,4,1,4};
    System.out.println( bestTeamScore.bestTeamScore(scores, ages));
  }

  public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        List<ScorePair> pairs = new ArrayList<>();
        int bestScore = 0;
        for( int i = 0; i < n; i++ ) {
            pairs.add( new ScorePair( ages[i], scores[i]));
        }
        Collections.sort( pairs, new Comparator<ScorePair> () {
            @Override
            public int compare( ScorePair A, ScorePair B ) {
                if( A.age == B.age  ){
                  return B.score - A.score;
                }
                return B.age - A.age;
            }
        });
        int[] dp = new int[n];
        for( int i = 0; i < n; i++ ) { 
          ScorePair p = pairs.get(i);
            dp[i] = p.score;
            int currentScore = p.score;
            int currAge = p.age;
            for( int j = 0; j < i; j++ ) {    
              ScorePair cp = pairs.get(j);
                int score = cp.score;
                int age = cp.age;
                if( age == currAge || score >= currentScore ) {
                    dp[i] = Math.max( dp[i], currentScore + dp[j]);
                }
            }
        }


        for( int i = 0; i < n; i++ ) {
            bestScore = Math.max( bestScore, dp[i] );
        }

        return bestScore;
    }
  
}

class ScorePair {
  int age;
  int score;

  public ScorePair( int age, int score ) {
      this.age = age;
      this.score = score;
  }
}