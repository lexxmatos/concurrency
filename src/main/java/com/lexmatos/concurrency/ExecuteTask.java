package com.lexmatos.concurrency;

import lombok.extern.java.Log;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Log
public class ExecuteTask {
  private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(ExecuteTask.class.getName());
  public void runnableExample() {
    // Runnable example
    Thread t = new Thread(() -> {
      log.info("Entered Runnable");
      // Perform some computation
      try {
        Thread.sleep(2000);
      } catch (InterruptedException ex) {
        Thread.currentThread().interrupt();
        log.severe(() -> "Exception: " + ex);
      }
      log.info("Hello from Runnable");
    });
    t.start();
  }

  public void callableExample() throws InterruptedException, ExecutionException {
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    Callable<String> callable = () -> {
      log.info("Entered Callable");
      // Perform some computation
      Thread.sleep(2000);
      return "Hello from Callable";
    };

    log.info("Submitting Callable");
    Future<String> future = executorService.submit(callable);
    // This line executes immediately
    log.info("Do something else while callable is getting executed");
    log.info("Retrieve the result of the future");

    // Future.get() blocks until the result is available
    String result = future.get();
    log.info(result);
    executorService.shutdown();
  }
}
