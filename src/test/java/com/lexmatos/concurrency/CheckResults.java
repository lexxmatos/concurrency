package com.lexmatos.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.jupiter.api.Test;

public class CheckResults {

	private static int counter = 0;
	
	@Test
	void main () throws Exception {
		ExecutorService service = Executors.newSingleThreadExecutor();
		
		try {
			Future<?> result = service.submit(() -> {
				for(int i =0; i < 1_000_000; i++) counter++;
			});
			result.get(10, TimeUnit.SECONDS);
			
			System.out.println("Reached!");
		} catch (TimeoutException e) {
			System.out.println("Not reached in time");
		} finally {
			service.shutdown();
		}
	}
}
