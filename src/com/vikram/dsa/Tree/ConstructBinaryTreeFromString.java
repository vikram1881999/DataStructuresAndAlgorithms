package com.vikram.dsa.Tree;

public class ConstructBinaryTreeFromString {
  public static void main( String[] args ) {
    ConstructBinaryTreeFromString.treeFromString("4(2(3)(1))(6(5))");
  }

  static Node preOrder(int i, String s) {
        
    // If substring is empty, return null.
    if (s.charAt(i) == ')') return null;
    
    // Find the value of root node.
    int val = 0;
    while (i < s.length() && s.charAt(i) != '(' && s.charAt(i) != ')') {
        int digit = s.charAt(i) - '0';
        i++;
        val = val * 10 + digit;
    } 
    
    // Create the root node.
    Node root = new Node(val);
    
    // If left subtree exists
    if (i < s.length() && s.charAt(i) == '(') {
        i++;
        root.left = preOrder(i, s);
        i++;
    }
    
    // If right subtree exists
    if (i < s.length() && s.charAt(i) == '(') {
        i++;
        root.right = preOrder(i, s);
        i++;
    }
    
    // Return the root node.
    return root;
}

static Node treeFromString(String s) {
    int i = 0;
    return preOrder(i, s);
}
}
