package com.lexmatos.concurrency;

import java.util.Random;

public class Deadlocks {

  public Deadlocks() throws InterruptedException {
    Intersection intersection = new Intersection();
    Thread trainAThread = new Thread(new TrainA(intersection));
    Thread trainBThread = new Thread(new TrainB(intersection));
    trainAThread.setDaemon(true);
    trainBThread.setDaemon(true);
    trainAThread.start();
    trainBThread.start();
  }
}
class TrainB implements Runnable {
  private final Intersection intersection;
  private final Random random = new Random();

  public TrainB(Intersection intersection) {
    this.intersection = intersection;
  }

  @Override
  public void run() {
    while (true) {
      long sleepingTime = random.nextInt(5);
      try {
        Thread.sleep(sleepingTime);
      } catch (InterruptedException e) {
      }

      intersection.takeRoadB();
    }
  }
}

class TrainA implements Runnable {
  private final Intersection intersection;
  private final Random random = new Random();

  public TrainA(Intersection intersection) {
    this.intersection = intersection;
  }

  @Override
  public void run() {
    while (true) {
      long sleepingTime = random.nextInt(5);
      try {
        Thread.sleep(sleepingTime);
      } catch (InterruptedException e) {
      }

      intersection.takeRoadA();
    }
  }
}

class Intersection {
  private final Object roadA = new Object();
  private final Object roadB = new Object();

  public void takeRoadA() {
    synchronized (roadA) {
      System.out.println("Road A is locked by thread " + Thread.currentThread().getName());

      synchronized (roadB) {
        System.out.println("Train is passing through road B");
        try {
          Thread.sleep(1);
        } catch (InterruptedException e) {
        }
      }
    }
  }

  public void takeRoadB() {
    synchronized (roadB) {
      System.out.println("Road A is locked by thread " + Thread.currentThread().getName());

      synchronized (roadA) {
        System.out.println("Train is passing through road B");

        try {
          Thread.sleep(1);
        } catch (InterruptedException e) {
        }
      }
    }
  }
}