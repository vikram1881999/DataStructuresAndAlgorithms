package com.vikram.dsa.Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordSubsets {

  public static void main( String[] args ) {
    String[] word1 = {"amazon","apple","facebook","google","leetcode"};
    String[] word2 = {"lo","eo"};
    WordSubsets subsets = new WordSubsets();
    System.out.println( subsets.wordSubsets(word1, word2) );
  }

  public List<String> wordSubsets(String[] words1, String[] words2) {
    int[] maxCharFreq = new int[26];
    int[] tempCharFreq = new int[26];

    for (String word : words2) {
        Arrays.fill(tempCharFreq, 0);
        for (char ch : word.toCharArray()) {
            tempCharFreq[ch - 'a']++;
        }
        for (int i = 0; i < 26; ++i) {
            maxCharFreq[i] = Math.max(maxCharFreq[i], tempCharFreq[i]);
        }
    }

    List<String> universalWords = new ArrayList<>();

    for (String word : words1) {
        Arrays.fill(tempCharFreq, 0);
        for (char ch : word.toCharArray()) {
            tempCharFreq[ch - 'a']++;
        }

        boolean isUniversal = true;
        for (int i = 0; i < 26; ++i) {
            if (maxCharFreq[i] > tempCharFreq[i]) {
                isUniversal = false;
                break;
            }
        }
        if (isUniversal) {
            universalWords.add(word);
        }
    }

    return universalWords;
}
}
