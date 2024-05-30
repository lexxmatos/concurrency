package com.lexmatos.concurrency.thread;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Thread capabilities and debugging")
public class ThreadCreation {

	/*
	 # Sleep depois
		We are in thread: main before starting a new thread
		We are in thread: main after starting a new thread
		we are now in thread New Worker Thread
		Current thread priority is 10
		
	 # Sleep no meio	
		We are in thread: main before starting a new thread
		we are now in thread New Worker Thread
		Current thread priority is 10
		We are in thread: main after starting a new thread
	 */
	@Test
	void creationThread() throws InterruptedException {
		    Thread thread = new Thread(() -> {
                //Code that will run in  a new thread
                System.out.println("we are now in thread "+Thread.currentThread().getName());
                System.out.println("Current thread priority is " + Thread.currentThread().getPriority());
			});

	        thread.setName("New Worker Thread");
	        thread.setPriority(Thread.MAX_PRIORITY);

	        System.out.println("We are in thread: " + Thread.currentThread().getName()+ " before starting a new thread");
	        thread.start();
	        thread.sleep(1000);
	        System.out.println("We are in thread: " + Thread.currentThread().getName()+ " after starting a new thread");
	        
	        
	}

}
