package com.vikram.dsa.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class CarFleet {

  public static void main( String[] args ) {
    CarFleet carFleet = new CarFleet();
    int[] car = {6,8};
    int[] speed = {3,2};
    System.out.println(carFleet.carFleet(10, car, speed));
  }


  public int carFleet(int target, int[] position, int[] speed) {
        List<Pair> carDistanceSpeed = new ArrayList<>();
        List<Double> speedToDestination = new ArrayList<>();
        Stack<Double> highway = new Stack<>();
        for( int i = 0; i < speed.length; i++ ){
            carDistanceSpeed.add( new Pair( position[i], speed[i]));
        }
        Collections.sort( carDistanceSpeed, new Comparator<Pair>() {
          @Override
          public int compare( Pair a, Pair b ){
                if( a.post == b.post ) {
                    return (int)(a.speed - b.speed);
                }
                return (int)(a.post - b.post);
            }
        });
        for( int i = 0; i < carDistanceSpeed.size(); i++ ) {
            Pair car = carDistanceSpeed.get(i);
            speedToDestination.add( (target - car.post)/car.speed );
        }
        for( int i = carDistanceSpeed.size()-1; i >= 0; i-- ) {
            double speedToDest = speedToDestination.get(i);
            if( highway.isEmpty() ) {
                highway.push(speedToDest);
            }
            else {
                if( highway.peek() < speedToDest ) {
                    highway.push(speedToDest);
                }
            }
        }

        return highway.size();
    }
  
}

class Pair {
    double post;
    double speed;
    public Pair( int post, int speed ) {
        this.post = post;
        this.speed = speed;
    }
}
