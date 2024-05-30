package com.lexmatos.codewars;

import java.util.Arrays;
import java.util.stream.Collectors;

import java.util.List;

// https://www.digitalocean.com/community/tutorials/java-stream-collect-method-examples
class StockList {
	static String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {

		if (lstOfArt.length > 0 && lstOf1stLetter.length > 0) {
			var counts = Arrays.stream(lstOfArt)
					.collect(Collectors.groupingBy(s -> s.substring(0, 1), 
								Collectors.summingInt(s -> Integer.parseInt(s.split(" ")[1]))
								)
							);
			counts.forEach((key, value) -> System.out.println(key + ":" + value));
			return Arrays.stream(lstOf1stLetter)
					.map(s -> "(" + s + " : " + counts.getOrDefault(s, 0) + ")")
					.collect(Collectors.joining(" - "));
		}
		return "";
	}
	
	static String getVowels() {
		List<String> vowels = List.of("a", "e", "i", "o", "u");

		// sequential stream - nothing to combine
		StringBuilder result = vowels.stream().collect(StringBuilder::new, (x, y) -> x.append(y),(a, b) -> a.append(",").append(b));
		return result.toString();
	}
}