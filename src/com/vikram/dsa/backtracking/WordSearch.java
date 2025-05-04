package com.vikram.dsa.backtracking;

import java.util.LinkedList;
import java.util.Queue;

public class WordSearch {

  public static void main( String[] args ) {
    char[][] ch = {{'A','B','C','E'}, {'S','F','E','S'}, {'A','D','E','E'} };
    WordSearch search = new WordSearch();
    System.out.println(search.exist(ch, "ABCESEEEFS"));
  }

  
   public static final int[][] DIRS = {{-1, 0}, {0, -1}, {1, 0}, { 0,1} };
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        int l = word.length();
        boolean ans = false;
        for( int i = 0; i < n; i++ ) {
            for( int j = 0; j < m; j++ ){
                if( board[i][j] == word.charAt(0) ) {
                    board[i][j] = '.';
                    ans = ans | search( board, i, j, word, 1, n, m);
                    board[i][j] = word.charAt(0);
                }
            }
        }
    
        return ans;
    }

    private boolean search( char[][] board, int i, int j, String word, int index , int n, int m) {
        if ( index == word.length() ){
            return true;
        }
        
        boolean ans = false;
        for( int[] dir: DIRS ) {
            int x = i + dir[0];
            int y = j + dir[1];
            if( x >= 0 && y >= 0 && x < n && y < m && board[x][y] != '.' && word.charAt(index) == board[x][y] ) {
                board[x][y] = '.';
                ans = ans | search( board, x, y, word, index+1, n, m);
                board[x][y] = word.charAt(index);
            }
        }
        return ans;
    }
       
}