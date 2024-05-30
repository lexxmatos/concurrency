package com.lexmatos.coding;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;


public class ExceptionTest {

	@Test
	public void whenExceptionThrown_thenAssertionSucceeds() {
	    Exception exception = Assertions.assertThrows(NumberFormatException.class, () -> {
	        Integer.parseInt("1a");
	    });

	    String expectedMessage = "For input string";
	    String actualMessage = exception.getMessage();

	    Assert.assertTrue(actualMessage.contains(expectedMessage));
	}	
}
