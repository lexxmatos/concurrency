package com.lexmatos.concurrency;

import java.util.ArrayList;
import java.util.List;

public class MultiExecutor {

  // Add any necessary member variables here
  private List<Runnable> tasks;
  /*
   * @param tasks to executed concurrently
   */
  public MultiExecutor(List<Runnable> tasks) {
    this.tasks = tasks;
  }

  /**
   * Starts and executes all the tasks concurrently
   */
  public void executeAll() {
    List<Thread> list = new ArrayList<>();

    for(Runnable runnable : tasks){
      list.add(new Thread(runnable));
    }
    for(Thread li : list){
      li.start();
    }

    // complete your code here
  }
}
