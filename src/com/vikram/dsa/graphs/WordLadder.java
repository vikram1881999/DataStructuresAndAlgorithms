package com.vikram.dsa.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

  public static void main( String[] args ) {
    WordLadder ladder = new WordLadder();
    List<String> wordList = List.of("hot","dot","dog","lot","log","cog");
    System.out.println(ladder.ladderLength("hit", "cog", wordList));
  }

  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = beginWord.length();
        Set<String> wordsSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        Set<Character> adjList[] = new HashSet[n];
        for( String word: wordList ) {
            wordsSet.add(word);
            for( int i = 0; i < n; i++ ) {
                if( adjList[i] == null ) {
                    adjList[i] = new HashSet<>();
                }
                adjList[i].add(word.charAt(i));
            }
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.add( new Pair( beginWord, 1));
        visited.add(beginWord);
        while( !queue.isEmpty() ) {
            Pair p = queue.remove();
            String word = p.word;
            int length = p.transformation;
            if( word.equals(endWord)) {
                return length;
            }
            char[] charArr = word.toCharArray();
            for( int i = 0; i < n; i++ ) {
                for( char ch:  adjList[i] ) {
                    char temp = charArr[i];
                    charArr[i] = ch;
                    String str = new String( charArr );
                    if( wordsSet.contains(str) && !visited.contains(str)) {
                        visited.add(str);
                        queue.add( new Pair(str, length+1));
                    }
                    charArr[i] = temp;
                }
            }
        }

        return -1;
    }

    private class Pair {
        String word;
        int transformation;
        public Pair( String word, int transformation ) {
            this.word = word;
            this.transformation = transformation;
        }
    } 
  
}
