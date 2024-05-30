package com.lexmatos.codewars;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

//https://www.codewars.com/kata/55c6126177c9441a570000cc/java

// https://www.codewars.com/kata/54b724efac3d5402db00065e
// https://brasilescola.uol.com.br/geografia/codigo-morse.htm
/**
 * The Morse code encodes every character as a sequence of "dots" and "dashes". For example, the letter A is coded as ·−, letter Q is coded as −−·−, and digit 1 is coded as ·−−−−. 
 * The Morse code is case-insensitive, traditionally capital letters are used. When the message is written in Morse code, a single space is used to separate the character codes 
 * and 3 spaces are used to separate words. For example, the message HEY JUDE in Morse code is ···· · −·−−   ·−−− ··− −·· ·.
 * 
 * NOTE: Extra spaces before or after the code have no meaning and should be ignored.
 */
public class MorseCodeDecoder {
	static Map<String, String> codes = Arrays.asList("A:.-","B:-...","C:-.-.","D:-..","E:.","F:..-.","G:--.","H:....","I:..",
			                                   "J:.---","K:-.-","L:.-..","M:--","N:-.","O:---","P:.--.","Q:--.-","R:.-.",
			                                   "S:...","T:-","U:..-","V:...-","W:.--","X:-..-","Y:-.--","Z:--.."," :   ", "SOS:...---...",
			                                   "?:..--..","/:-..-.",".:.-.-.-",",:--..--","!:-.-.--")
									.stream()
									.map(elem -> elem.split(":"))
									.collect(Collectors.toMap(elem -> elem[1], elem -> elem[0]));
	
	public static String decode(String morse) {
		
		String[] letter = morse.trim().split(" ");
		StringBuilder word = new StringBuilder();

		for (int i = 0; i < letter.length; i++) {
			if(letter[i].length()==0 && letter[i+1].length()==0) {
				word.append(codes.get("   "));
			} else if(letter[i].length()!=0)
				word.append(codes.get(letter[i]));
		}
		return word.toString();
	}
}
