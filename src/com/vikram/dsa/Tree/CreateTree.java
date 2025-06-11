package com.vikram.dsa.Tree;

import java.util.HashMap;
import java.util.Map;

public class CreateTree {

  public static void main( String[] args)  {
    CreateTree out = new CreateTree();
    int[] arr = {1,13, 31, 7, 17, 33, 27, 1, 5, 15, 19, 3 ,33, 17, 19, 21, 23, 25, 31, 11, 29, 13, 27, 7, 25, -1, 23, 15, 3, 11, 21, 5, 9, 9};
    System.out.println( out.createTree(arr));
  }

  public Node createTree(int parent[]) {
        // Your code here
        int n = parent.length;
        Map<Integer, Node> map = new HashMap<>();
        Node globalRoot = null;
        for( int i = n-1; i >= 0; i-- ) {
            Node node = new Node(i);
            if( map.containsKey(i) ) {
                node = map.get(i);
            }
            if( parent[i] == -1 ) {
                globalRoot = node;
                map.put(parent[i], node );
                continue;
            }
            map.put(i, node);
            if( map.containsKey(parent[i]) ) {
                Node root = map.get(parent[i]);
                root.right = root.left;
                root.left = node;
                map.put(parent[i], root );
            }
            else {
                Node root = new Node(parent[i]);
                root.left = node;
                map.put(parent[i], root );
            }
        }
        
        return globalRoot;
        
    }
  
}

class Node {
  Node left;
  Node right;
  int value;
  public Node( int value ) {
    this.value = value;
    this.left = null;
    this.right = null;
  }
}
