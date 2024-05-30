package com.lexmatos.concurrency;

public class InventoryCounter {

  public InventoryCounter() throws InterruptedException {
    InventoryCounterInterface inventoryCounterSyn = new InventoryCounterSynchronized();
    InventoryCounterInterface inventoryCounterLock = new InventoryCounterSynchronized();
    IncrementingThread incrementingThread1 = new IncrementingThread(inventoryCounterSyn);
    DecrementingThread decrementingThread1 = new DecrementingThread(inventoryCounterSyn);
    IncrementingThread incrementingThread2 = new IncrementingThread(inventoryCounterLock);
    DecrementingThread decrementingThread2 = new DecrementingThread(inventoryCounterLock);

    incrementingThread1.start();
    decrementingThread1.start();
    incrementingThread2.start();
    decrementingThread2.start();


    incrementingThread1.join();
    decrementingThread1.join();
    incrementingThread2.join();
    decrementingThread2.join();

    System.out.println("We currently have " + inventoryCounterSyn.getItems() + " items");
    System.out.println("We currently have " + inventoryCounterLock.getItems() + " items");
  }
}

interface InventoryCounterInterface {
  void increment();
  void decrement();
  int getItems();
}
class DecrementingThread extends Thread {

  private InventoryCounterInterface inventoryCounter;

  public DecrementingThread(InventoryCounterInterface inventoryCounter) {
    this.inventoryCounter = inventoryCounter;
  }

  @Override
  public void run() {
    for (int i = 0; i < 10000; i++) {
      inventoryCounter.decrement();
    }
  }
}
class IncrementingThread extends Thread {

  private InventoryCounterInterface inventoryCounter;

  public IncrementingThread(InventoryCounterInterface inventoryCounter) {
    this.inventoryCounter = inventoryCounter;
  }

  @Override
  public void run() {
    for (int i = 0; i < 10000; i++) {
      inventoryCounter.increment();
    }
  }
}

class  InventoryCounterLock implements InventoryCounterInterface{
  private int items = 0;

  Object lock = new Object();

  public void increment() {
    synchronized (this.lock) {
      items++;
    }
  }

  public void decrement() {
    synchronized (this.lock) {
      items--;
    }
  }

  public int getItems() {
    return items;
  }
}

class  InventoryCounterSynchronized implements InventoryCounterInterface{
  private int items = 0;

  Object lock = new Object();

  public synchronized void increment() {
      items++;
  }

  public synchronized void decrement() {
      items--;
  }

  public int getItems() {
    return items;
  }
}