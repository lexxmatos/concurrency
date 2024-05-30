package com.lexmatos.codewars;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

// https://www.codewars.com/kata/513e08acc600c94f01000001/java

public class RgbToHexConversion {
	
	public static String rgb(int first, int second, int third) {
		
		return new StringBuilder().append(RgbToHexConversion.decimalToHex(first))
								  .append(RgbToHexConversion.decimalToHex(second))
								  .append(RgbToHexConversion.decimalToHex(third)).toString();
	}
	
	/**
    	- Divide the decimal number by 16. Treat the division as an integer division.  
    	- Write down the remainder (in hexadecimal).
    	- Divide the result again by 16.  Treat the division as an integer division.  
    	- 200/16 = 12 || 200 %16 = 8 -> C8 
    	
 	 * @param decimal
	 * @return Hexadecimal number
	 */
	private static String decimalToHex(int decimal) {
		int newDecimal = decimal;
		Map<Integer, String> decimalToHexadecimal = Arrays.asList("0:0","1:1","2:2","3:3","4:4","5:5","6:6","7:7","8:8","9:9","10:A","11:B","12:C","13:D","14:E","15:F")
														.stream()
														.map(elem -> elem.split(":"))
														.collect(Collectors.toMap(elem -> Integer.valueOf(elem[0]), elem -> elem[1])); 
		if (decimal > 255)  newDecimal = 255;
		if (decimal < 0)  newDecimal = 0;
		
		String first = decimalToHexadecimal.get(newDecimal / 16);
		String second = decimalToHexadecimal.get(newDecimal % 16);
		
		return new StringBuilder().append(first).append(second).toString();
	}
}
