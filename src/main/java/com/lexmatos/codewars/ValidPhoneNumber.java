package com.lexmatos.codewars;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://www.codewars.com/kata/525f47c79f2f25a4db000025/java
 * https://www.regextester.com/
 * ^\([0-9]{3}\)\s[0-9]{3}-[0-9]{4}$
 */
/**
 * Write a function that accepts a string, and returns true if it is in the form of a phone number.
 * Assume that any integer from 0-9 in any of the spots will produce a valid phone number.

 * Only worry about the following format:
 * (123) 456-7890 (don't forget the space after the close parentheses) */

public class ValidPhoneNumber {
	
	public static boolean valid(String number) {
		Pattern pattern = Pattern.compile("^\\(\\d{3}\\)\\s\\d{3}-\\d{4}$");
	    Matcher matcher = pattern.matcher(number);
		
		return matcher.find();
	}
}
