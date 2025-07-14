package com.vikram.dsa.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class VideoStiching {

  public static void main( String[] args ) {

    int[][] arr = {{0,0},{9,9},{2,10},{0,3},{0,5},{3,4},{6,10},{1,2},{4,7},{5,6}};
    VideoStiching videoStiching = new VideoStiching();
    System.out.println( videoStiching.videoStitchingOptimized(arr, 5));
  }

  public int videoStitching(int[][] clips, int time) {
        List<int[]> filteredList = new ArrayList<>();
        Arrays.sort(clips, new Comparator<int[]>() {
          @Override
          public int compare( int[] a, int[] b ) {
            if( a[0] == b[0] ) {
              return b[1] - a[1];
            }
            return a[0] - b[0];
          }
        });

        int[] curr = clips[0];
        for( int i = 1; i < clips.length; i++ ) {
          if( clips[i][0] >= curr[0] && clips[i][1] <= curr[1] ) {
            continue;
          }
          else {
            filteredList.add(curr);
            curr = clips[i];
          }
        }

        filteredList.add(curr);
        HashMap<String, Integer> cache = new HashMap<>();

        if( filteredList.get(0)[0] != 0 || filteredList.get(filteredList.size()-1)[1] < time ) {
          return 0;
        }
        return videoStitching(filteredList, 1, cache, time, filteredList.get(0))+1;
  }

  private int videoStitching(List<int[]> filteredList, int i, HashMap<String, Integer> cache, int time, int[] clip ) {
    if(  i >= filteredList.size() && clip[1] == time ) {
      return 0;
    }
    if(i >= filteredList.size() ) {
      return Integer.MAX_VALUE/2;
    }

    String key = Arrays.toString(clip)+"_" + i;
    if(cache.containsKey(key)) {
      return cache.get(key);
    }
    int[] currClip = filteredList.get(i);
    int minClips = videoStitching(filteredList, i+1, cache, time, clip);
    if( currClip[0] <= clip[1] ) {
      minClips = Math.min( minClips, videoStitching( filteredList, i+1, cache, time, currClip) + 1);
    }

    cache.put(key, minClips);
    return minClips;
  }


  public int videoStitchingOptimized(int[][] clips, int time) {
        int n = clips.length;
        Arrays.sort(clips, new Comparator<int[]>() {
          @Override
          public int compare( int[] a, int[] b ) {
            if( a[0] == b[0] ) {
              return b[1] - a[1];
            }
            return a[0] - b[0];
          }
        });

        int currEnd = 0;
        int used = 0;   
        int i = 0;
        int nextEnd = currEnd;
        while( i < n && currEnd <= time ) {

            while( i < n && clips[i][0] <= currEnd ) {
                nextEnd = Math.max(nextEnd, clips[i][1]);
                i++;
            }

            if( nextEnd == currEnd ) {
                return -1;
            }

            currEnd = nextEnd;
            used++;
        }

        if( currEnd < time ) {
            return -1;
        }

        return used;
  }
  
}


