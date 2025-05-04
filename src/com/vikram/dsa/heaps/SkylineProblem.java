package com.vikram.dsa.heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class SkylineProblem {

  public static void main(String[] args  ){
    int[][] buildings = {{0,2,3}, {2,5,3}};
    SkylineProblem skylineProblem = new SkylineProblem();
    System.out.println(skylineProblem.getSkyline(buildings));
  }
  
  public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>>  coordinates = new ArrayList<>();
        if( buildings == null ||  buildings.length < 1 ) {
            return Collections.emptyList();
        } 
        List<Pair> heightAtPointList = new ArrayList<>();
        TreeMap<Integer,Integer> treeMap = new TreeMap<>( new Comparator<Integer>() {
            @Override
            public int compare( Integer A, Integer B ) {
                return B-A;
            }
        });
        for( int i = 0; i < buildings.length; i++ ) {
            int s = buildings[i][0];
            int e = buildings[i][1];
            int h = buildings[i][2];
            Pair p1 = new Pair(s, -h);
            Pair p2 = new Pair(e, h);
            heightAtPointList.add(p1);
            heightAtPointList.add(p2);
        }

        Collections.sort(heightAtPointList, new Comparator<Pair>() {
            @Override
            public int compare( Pair a, Pair b ) {
                if( a.x == b.x ) {
                    return a.h - b.h;
                }
                return a.x - b.x;
            }
        });

        treeMap.put(0, 1);
        for( int i = 0; i < heightAtPointList.size(); i++ ) {
            Pair p = heightAtPointList.get(i);
            if( p.h < 0 ) {
                int currentHeight = treeMap.firstEntry().getKey();
                if( treeMap.containsKey(Math.abs(p.h)) ) {
                  int c = treeMap.get(Math.abs(p.h));
                  c += 1;
                  treeMap.put(Math.abs(p.h), c);
                } 
                else {
                  treeMap.put(Math.abs(p.h), 1);
                }
                
                if( treeMap.firstEntry().getKey() > currentHeight ) {
                  List<Integer> currCordinate = new ArrayList<>();
                  currCordinate.add(p.x);
                  currCordinate.add( Math.abs(p.h));
                  coordinates.add(currCordinate);
                }
            }
            else if ( p.h > 0 ) {
              int currentHeight = treeMap.firstEntry().getKey();
              int c = treeMap.get(p.h);
              if( c < 2 ) {
                treeMap.remove(p.h);
              }
              else {
                c -= 1;
                treeMap.put(p.h, c);
              }
              if( currentHeight != treeMap.firstEntry().getKey() ) {
                 List<Integer> currCordinate = new ArrayList<>();
                  currCordinate.add(p.x);
                  currCordinate.add( treeMap.firstEntry().getKey());
                  coordinates.add(currCordinate);
              }
            }
        }

        return coordinates;

    }
}

class Pair {
    int x;
    int h;
    public Pair( int x, int h ) {
        this.x = x;
        this.h = h;
    }
}