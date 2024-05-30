package com.lexmatos.codewars;

import java.util.HashMap;
import java.util.Map;

public class StockListOriginal {
	public static String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
		
		if (lstOfArt.length ==0 || lstOf1stLetter.length==0 ) return "";
		
		Map<Character,Integer> firsts = new HashMap<>();
		for (int i = 0; i < lstOf1stLetter.length; i++) {
			firsts.put(lstOf1stLetter[i].charAt(0),0);
		}
		for  (int i = 0; i < lstOfArt.length; i++) {
			
			Character first = Character.valueOf(lstOfArt[i].charAt(0)); 
			if (firsts.containsKey(first)) {
				firsts.replace(first, firsts.get(first) + Integer.valueOf(lstOfArt[i].split(" ")[1]));
			}
		}
		StringBuffer output = new StringBuffer();
		for (Character character : firsts.keySet()) {
			if (output.length()==0)
				output.append(String.format("(%c : %d)",character,firsts.get(character)));
			else {
				output.append(" - "+ String.format("(%c : %d)",character,firsts.get(character)));
			}
		}
		return output.toString();
	}
}
