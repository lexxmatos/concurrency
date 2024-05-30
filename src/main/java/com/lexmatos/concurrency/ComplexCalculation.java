package com.lexmatos.concurrency;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


/**
	In this exercise we will efficiently calculate the following result = base1 ^ power1 + base2 ^ power2
	Where a^b means: a raised to the power of b.
	For example 10^2 = 100
	We know that raising a number to a power is a complex computation, so we we like to execute:
	result1 = x1 ^ y1
	result2 = x2 ^ y2
	In parallel.
	and combine the result in the end : result = result1 + result2
	This way we can speed up the entire calculation.
	Note :
	base1 >= 0, base2 >= 0, power1 >= 0, power2 >= 0
 */
public class ComplexCalculation {
	public BigInteger calculateResult(BigInteger base1, BigInteger power1, BigInteger base2, BigInteger power2) {
		BigInteger result = BigInteger.ZERO;
		
		List<PowerCalculatingThread> threads = new ArrayList<>();
		threads.add(new PowerCalculatingThread(base1, power1));
		threads.add(new PowerCalculatingThread(base2, power2));
		//reads.forEach(t -> t.start() && t.join(2000));
		
		threads.forEach(t -> t.start());
		threads.forEach(t -> {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		for (PowerCalculatingThread thread : threads) {
			result = result.add(thread.getResult());
		}

		return result;
	}

	private class PowerCalculatingThread extends Thread {
		
		private BigInteger result = BigInteger.ONE;
		private BigInteger base;
		private BigInteger power;

		public PowerCalculatingThread(BigInteger base, BigInteger power) {
			this.base = base;
			this.power = power;
		}

		@Override
		public void run() {
			for (int i = 0; i < power.intValue(); i++) {
				result = result.multiply(base);
			}
		}

		public BigInteger getResult() {
			return result;
		}
	}
}
