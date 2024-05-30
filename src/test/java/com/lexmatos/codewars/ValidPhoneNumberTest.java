package com.lexmatos.codewars;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Valid phone number test")
class ValidPhoneNumberTest {
	
	@Test
	void phoneNumberValid() {
		
		Assertions.assertEquals(true, ValidPhoneNumber.valid("(123) 456-7890"));
		Assertions.assertEquals(false, ValidPhoneNumber.valid("a(123) 456-7890b"));
		Assertions.assertEquals(false, ValidPhoneNumber.valid("(123)456-7890"));
		Assertions.assertEquals(true,  ValidPhoneNumber.valid("(123) 456-7890"));
		Assertions.assertEquals(false, ValidPhoneNumber.valid("(1111)555 2345"));
		Assertions.assertEquals(false, ValidPhoneNumber.valid("(098) 123 4567"));
		
	}

}
