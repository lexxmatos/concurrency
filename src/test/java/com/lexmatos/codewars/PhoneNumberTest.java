package com.lexmatos.codewars;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// Write a function that accepts an array of 10 integers (between 0 and 9), that returns a string of those numbers in the form of a phone number.
@DisplayName("Create Phone Number")
public class PhoneNumberTest {
	
	public String formatePhoneNumber(String format, int[] numbers) {
		//Integer[] numberI = Arrays.stream(numbers).boxed().toArray( Integer[]::new);
		
		for (int i = 0; i < numbers.length; i++) {
			Integer ni = Integer.valueOf(numbers[i]);
			format = format.replaceFirst("#", ni.toString());
		}
		return format;
	}
	
	@Test
	public void testResponde() {
		
		int[] numbers = new int[] {1,2,3,4,5,6,7,8,9,0};
		String format = "(###) ###-####";
		Assert.assertEquals(formatePhoneNumber(format,numbers), "(123) 456-7890");
	}
	
	@Test
	public void testRespondeStream() {
		
		Integer[] numbers = new Integer[] {1,2,3,4,5,6,7,8,9,0};

		String format = "(###) ###-####";

		for (int i = 0; i < numbers.length; i++) {
			format = format.replaceFirst("#", numbers[i].toString());
		}

		Assert.assertEquals(format, "(123) 456-7890");
	} 	
}
