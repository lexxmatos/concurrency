package com.lexmatos.concurrency;

import java.math.BigInteger;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class ComplexCalculationTest {

	@Test
	void complexCalculationTest() throws InterruptedException {
		
		ComplexCalculation complexCalculation =  new ComplexCalculation();
		BigInteger bin = complexCalculation.calculateResult(BigInteger.TWO, BigInteger.valueOf(3l), BigInteger.TWO, BigInteger.valueOf(3l));
		
		Assert.assertEquals(new BigInteger("16"), bin);
	}
}
