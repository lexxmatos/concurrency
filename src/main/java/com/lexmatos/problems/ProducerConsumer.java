package com.lexmatos.problems;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class ProducerConsumer {

  private final Consumer consumer;
  private final Producer producer;

  private final Queue<Number> queue = new ConcurrentLinkedQueue<>();

  public ProducerConsumer(){
    this.consumer = new Consumer(queue);
    this.producer = new Producer(queue);

    this.consumer.consumer();
    this.producer.producer();
  }

}

/*
  If the data buffer is empty, then the producer produces one product (by adding it to the data buffer).
  If the data buffer is not empty, then the consumer consumes one product (by removing it from the data buffer).
  As long as the data buffer is not empty, the producer waits.
  As long as the data buffer is empty, the consumer waits.
 */
class Consumer {
  private final Queue<Number> queue;
  Consumer(Queue<Number> queue){
    this.queue = queue;
  }

  public void consumer(){
    new Thread(() -> {
      while (true){
        if (!queue.isEmpty()){
          try {
            Thread.sleep(200);
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
          System.out.println("Removeu: " + queue.remove());
          System.out.println("Tamanho: " + queue.size());
        }
      }
    }).start();
  }
}

class Producer {
  private final Queue<Number> queue;
  private AtomicInteger element = new AtomicInteger(0);

  Producer(Queue<Number> queue){
    this.queue = queue;
  }

  public void producer(){
    new Thread(() -> {
      while(true){
        if (queue.size() < 10){
          try {
            Thread.sleep(100);
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
          queue.add(element.incrementAndGet());
          System.out.println("Adicionou: " + element.get());
          System.out.println("Tamanho: " + queue.size());
        }
      }
    }).start();
  }

}