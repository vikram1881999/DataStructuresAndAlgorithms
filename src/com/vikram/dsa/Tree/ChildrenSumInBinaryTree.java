package com.vikram.dsa.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class ChildrenSumInBinaryTree {

  public static void main( String[] args ) {
    Node node = new Node(35);
    Node node1 = new Node(20);
    Node node2 = new Node(15);
    Node node3 = new Node(15);
    Node node4 = new Node(5);
    Node node5 = new Node(10);
    Node node6 = new Node(5);
  }

  public static int isSumProperty(Node root) {
       if( root == null ) {
           return 1;
       }
        Queue<Node> queue = new LinkedList<>();
        queue.add( root);
        while( !queue.isEmpty() ) {
            Node parent = queue.remove();
            int childSum = 0;
            if( parent.left != null ) {
                queue.add( parent.left );
                childSum += parent.left.data;
            }
            if( parent.right != null ){
                queue.add( parent.right );
                childSum += parent.right.data;
            }
            
            if( parent.data != childSum ) {
                return 0;
            }
        }
        
        return 1;
    }
  
}


class Node{
  int data;
  Node left,right;

  Node(int key)
  {
      data = key;
      left = right = null;
  }
}