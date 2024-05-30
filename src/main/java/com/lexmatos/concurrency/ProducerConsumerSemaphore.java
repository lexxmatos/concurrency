package com.lexmatos.concurrency;

import java.util.concurrent.Semaphore;

public class ProducerConsumerSemaphore {
  private static final int BUFFER_SIZE = 5;
  private static int[] buffer = new int[BUFFER_SIZE];
  private static final Semaphore mutex = new Semaphore(1); // Controls access to the buffer
  private static final Semaphore empty = new Semaphore(BUFFER_SIZE); // Counts empty slots in the buffer
  private static final Semaphore full = new Semaphore(0); // Counts filled slots in the buffer

  public static void main(String[] args) {
    Thread producer = new Thread(new Producer(BUFFER_SIZE, buffer, mutex, empty, full));
    Thread consumer = new Thread(new Consumer(BUFFER_SIZE, buffer, mutex, empty, full));

    producer.start();
    consumer.start();
  }
}

class Producer implements Runnable {
  private final int bufferSize;
  private final int[] buffer;
  private final Semaphore mutex;
  private final Semaphore empty;
  private final Semaphore full;

  Producer(final int bufferSize,
           final int[] buffer,
           final Semaphore mutex,
           final Semaphore empty,
           final Semaphore full) {
    this.bufferSize = bufferSize;
    this.buffer = buffer;
    this.mutex = mutex;
    this.empty = empty;
    this.full = full;
  }

  @Override
  public void run() {
    try {
      for (int i = 0; i < 10; i++) {
        empty.acquire(); // Wait for an empty slot in the buffer
        mutex.acquire(); // Acquire exclusive access to the buffer
        // Produce an item and add it to the buffer
        int item = i + 1;
        System.out.println("Producing item: " + item);
        buffer[i % bufferSize] = item;
        Thread.sleep(1000); // Simulate some work
        mutex.release(1); // Release access to the buffer
        full.release(); // Signal that a slot in the buffer is filled
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

class Consumer implements Runnable {
  private final int bufferSize;
  private final int[] buffer;
  private final Semaphore mutex;
  private final Semaphore empty;
  private final Semaphore full;

  Consumer(final int bufferSize,
           final int[] buffer,
           final Semaphore mutex,
           final Semaphore empty,
           final Semaphore full) {
    this.bufferSize = bufferSize;
    this.buffer = buffer;
    this.mutex = mutex;
    this.empty = empty;
    this.full = full;
  }

  @Override
  public void run() {
    try {
      for (int i = 0; i < 10; i++) {
        full.acquire(); // Wait for a filled slot in the buffer
        mutex.acquire(); // Acquire exclusive access to the buffer
        // Consume an item from the buffer
        int item = buffer[i % bufferSize];
        System.out.println("Consuming item: " + item);
        Thread.sleep(2000); // Simulate some work
        mutex.release(); // Release access to the buffer
        empty.release(); // Signal that a slot in the buffer is empty
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
