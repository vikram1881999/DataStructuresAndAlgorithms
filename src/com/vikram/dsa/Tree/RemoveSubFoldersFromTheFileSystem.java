package com.vikram.dsa.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoveSubFoldersFromTheFileSystem {

  public static void main( String[] args ) {
    RemoveSubFoldersFromTheFileSystem fileSystem  = new RemoveSubFoldersFromTheFileSystem();
    String[] arr = {"/a/b/c","/a/b/ca","/a/b/d"};
    System.out.println( fileSystem.removeSubfolders(arr) );
  }


  public List<String> removeSubfolders(String[] folder) {
        List<String> ans = new ArrayList<>();
        FileSystemNode root = new FileSystemNode("/");
        for( String directory : folder ) {
            String[] subFolders = directory.split("/");
            insertFolder(subFolders, root);
        }

        for( String directory : folder ) {
            String[] subFolders = directory.split("/");
            if( !isSubFolder(subFolders, root) ) {
                ans.add(directory);
            }
        }

        return ans;
    }

    public void insertFolder( String[] folders, FileSystemNode root ) {
        FileSystemNode t = root;
        for( int i = 1; i < folders.length; i++ ){
            String folder = folders[i];
            if( t.subFolders.containsKey(folder) ){
                t = t.subFolders.get(folder);
            }
            else {
                FileSystemNode node = new FileSystemNode(folder);
                t.subFolders.put( folder, node );
                t = node;
            }
        }

        t.isEnd = true;
    }


    public boolean isSubFolder( String[] folders, FileSystemNode root ) {
        FileSystemNode t = root;
        for( int i = 1; i < folders.length; i++ ){
            String folder = folders[i];
            if( t.isEnd ) {
                t.subFolders.remove(folder);
                return true;
            }
            t = t.subFolders.get(folder);
        }

        return false;
    }


}

class FileSystemNode {
    String name;
    Map<String, FileSystemNode> subFolders;
    boolean isEnd;

    public FileSystemNode( String name ) {
        this.name = name;
        subFolders = new HashMap<>();
        this.isEnd = false;
    }
}
