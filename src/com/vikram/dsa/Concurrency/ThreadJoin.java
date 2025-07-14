package com.vikram.dsa.Concurrency;

public class ThreadJoin {

  public static class ThreadJoinRUnnable implements Runnable {

    @Override
    public void run() {
      for( int i = 0; i < 5; i++ ) {
        sleep(1000);
        System.out.println("Running");
      }
    }

    private void sleep( int time) {
      try {
        Thread.sleep(time);
      }
      catch( InterruptedException e ) {
        e.printStackTrace();
      }
    }
    
  }

  public static void main( String[] args ) {
    ThreadJoinRUnnable joinRUnnable = new ThreadJoinRUnnable();
    
    Thread thread = new Thread(joinRUnnable);
    thread.setDaemon(true);
    thread.start();

    try {
      thread.join();
    } catch ( InterruptedException e  ) {
      e.printStackTrace();
    }
  }
  
}
