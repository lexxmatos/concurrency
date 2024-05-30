package com.lexmatos.codewars;
//https://www.codewars.com/kata/635b8fa500fba2bef9189473/train/java

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class PhoneWords {
	private	static Map<String, String> codes = Arrays.asList("2:a","22:b","222:c",
															"3:d","33:e","333:f",
															"4:g","44:h","444:i",
															"5:j","55:k","555:l",
															"6:m","66:n","666:o",
															"7:p","77:q","777:r", "7777:s",
															"8:t","88:u","888:v",
															"9:w","99:x","999:y", "9999:z",
															"1:#","11:#","111:#",
															"0: ","00:  ", "000:   ")
			.stream()
			.map(elem -> elem.split(":"))
			.collect(Collectors.toMap(elem -> elem[0], elem -> elem[1]));
	
	public static String phoneWords(String str) {
		if ("".equals(str) || "null".equals(str) || Objects.isNull(str)) {
			return "";
		}
		List<String> listSplitedNumbers = splitSet(str);
		
		String listSplitedLetters = listSplitedNumbers
				.stream()
				.map(y -> codes.get(y))
				.map(z -> z.equals("#") ? "" : z)
				.collect(Collectors.joining());
		
		return listSplitedLetters;
	} 

	private static List<String> splitSet(String str) {
		List<String> listSplited = new ArrayList<String>();
		char[] letters = str.toCharArray();
		int begin = 0;
		for (int end = 0; end < letters.length; end++) {
			int splitSize = letters[begin] == '7' || letters[begin] == '9' ? 4 : 3; 
			if (letters[begin]!=letters[end] || end - begin == splitSize ) {
				listSplited.add(str.substring(begin, end));
				begin = end;
			}
		}
		listSplited.add(str.substring(begin, letters.length));

		return listSplited;
	}
	
}
