package com.vikram.dsa.Tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class FindCommonNodesBST {

   public static ArrayList<Integer> findCommon(Node r1, Node r2) {
        Set<Integer> set = new HashSet<>();
        traverseNodeAndStore( r1, set );
        ArrayList<Integer> ans  = new ArrayList<>();
        traverseNodeCheckAndStore( r2,set, ans);
        return ans;
    }
    
    private static void traverseNodeAndStore( Node root, Set<Integer> set ) {
        if( root == null ) {
            return;
        }
        traverseNodeAndStore(root.left,set);
        set.add( root.data );
        traverseNodeAndStore(root.right, set);
    }
    
    private static void traverseNodeCheckAndStore( Node root, Set<Integer> set, ArrayList<Integer> ans ) {
        if( root == null ) {
            return;
        }
        traverseNodeCheckAndStore(root.left, set, ans);
        if( set.contains(root.data) ) {
            ans.add( root.data );
        }
        traverseNodeCheckAndStore(root.right, set, ans);
    }
  
}
class Node {
  int data;
  Node left;
  Node right;
  public Node( int data) {
    this.data = data;
  }
}