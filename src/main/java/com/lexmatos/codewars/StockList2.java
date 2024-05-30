package com.lexmatos.codewars;

import java.util.stream.Stream;
import java.util.stream.Collectors;

public class StockList2 {
	public static String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
		if (lstOfArt.length == 0) return "";
		
		return Stream.of(lstOf1stLetter)
				.map(letter -> letter + " : "
						+ Stream.of(lstOfArt).filter(art -> letter.equals(art.subSequence(0, 1)) )
								.map(art -> art.substring(art.indexOf(" ") + 1))
								.mapToInt(Integer::parseInt)
								.sum())
				.map(s -> "(" + s + ")").collect(Collectors.joining(" - "));
	}
}