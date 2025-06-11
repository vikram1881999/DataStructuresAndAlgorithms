package com.vikram.dsa.Tree;

import java.util.LinkedList;
import java.util.Queue;



public class CheckCompleteBinaryTree {

  public static void main( String[] args ) {
    TreeNode root = new TreeNode(1);
    TreeNode node1 = new TreeNode(2);
    TreeNode node2 = new TreeNode(3);
    TreeNode node3 = new TreeNode(4);
    TreeNode node4 = new TreeNode(5);    
    TreeNode node5 = new TreeNode(6);
    root.left = node1;
    root.right = node2;
    node1.left = node3;
    node1.right = node4;
    node2.left = node5;

    CheckCompleteBinaryTree binaryTree = new CheckCompleteBinaryTree();
    System.out.println(binaryTree.isCompleteTree(root));
  }




  public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int expectedElement = 1;
        int c = 0;
        while( !queue.isEmpty() ) {
            int elementInCurrentLevel = 0;
            boolean isNullExists = false;
            int size = queue.size();
            for( int i = 0; i < size; i++ ) {
                TreeNode node = queue.remove();
                if( isNullExists && node != null ) {
                    return false;
                }
                if( node == null ) {
                    isNullExists = true;
                    continue;
                }
                elementInCurrentLevel++;
                if( node.left == null && node.right != null ) {
                    return false;
                }
                queue.add(node.left);
                queue.add(node.right);
            }
            if (elementInCurrentLevel != expectedElement && !queue.isEmpty()) {
                c++;
            }
            if( c > 1 ) {
              return false;
            }
            expectedElement *= 2;
        }

        return true;
    }
  
}

class TreeNode {
  TreeNode left;
  TreeNode right;
  int value;
  public TreeNode( int value ) {
    this.value = value;
    this.left = null;
    this.right = null;
  }
}
