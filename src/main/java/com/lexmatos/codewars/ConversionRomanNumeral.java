package com.lexmatos.codewars;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//https://www.codewars.com/kata/51b62bf6a9c58071c600001b/train/java
/**
 * Create a function taking a positive integer as its parameter and returning a string containing the Roman Numeral representation of that integer.
 * Modern Roman numerals are written by expressing each digit separately starting with the left most digit and skipping any digit with a value of zero. 
 * In Roman numerals 1990 is rendered: 1000=M, 900=CM, 90=XC; resulting in MCMXC. 2008 is written as 2000=MM, 8=VIII; or MMVIII. 1666 uses each Roman 
 * symbol in descending order: MDCLXVI.
 * 	
 * Symbol    Value
 * I          1
 * V          5
 * X          10
 * L          50
 * C          100
 * D          500
 * M          1,000
 *
 */
public class ConversionRomanNumeral {
	Map<Integer, String> roman = Arrays.asList("1:I","5:V","10:X","50:L","100:C","500:D","1000:M")
										.stream()
										.map(elem -> elem.split(":"))
										.collect(Collectors.toMap(elem -> Integer.valueOf(elem[0]), elem -> elem[1]));
	List<String> unities = Arrays.asList("I","X","C","M");
	
	public String solution(int n) {
		StringBuilder result = new StringBuilder();  
		int places = Integer.toString(n).length();
		
		for (int i=1; i <= places; i++) {

			int numberAlone = Integer.valueOf(Integer.toString(n).substring(i-1,i));
			int pow = Double.valueOf(Math.pow(10,  (places-i))).intValue();
			result.append(solutionByUnity(numberAlone, pow));
		}

		return result.toString();
	}
	
	private String solutionByUnity(int n, int pow) {
		if (n==0) return "";
		
		int places = Integer.toString(pow).length();
		int diff = (n>5) ? 3: 2;

		for (int i = n-diff; i<=n+1;i++) {
			if(roman.containsKey(Integer.valueOf(i*pow))) { 
				StringBuilder back = new StringBuilder();
				StringBuilder front = new StringBuilder();
				if (n>i) 
					Stream.iterate(0, x -> x +1).limit(n-i).forEach(x -> back.append(unities.get(places-1)));
				else 
					Stream.iterate(0, x -> x +1).limit(i-n).forEach(x -> front.append(unities.get(places-1)));
				
				return front.append(roman.get(Integer.valueOf(i*pow))).append(back.toString()).toString();
			}
		}
						
		return "NÃO ENCONTRADO";
	}
}
