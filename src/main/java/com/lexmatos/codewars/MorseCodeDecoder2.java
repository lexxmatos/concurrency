package com.lexmatos.codewars;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

// https://www.codewars.com/kata/54b724efac3d5402db00065e
// https://brasilescola.uol.com.br/geografia/codigo-morse.htm
/**
 * The Morse code encodes every character as a sequence of "dots" and "dashes". For example, the letter A is coded as ·−, letter Q is coded as −−·−, and digit 1 is coded as ·−−−−. 
 * The Morse code is case-insensitive, traditionally capital letters are used. When the message is written in Morse code, a single space is used to separate the character codes 
 * and 3 spaces are used to separate words. For example, the message HEY JUDE in Morse code is ···· · −·−−   ·−−− ··− −·· ·.
 * 
 * NOTE: Extra spaces before or after the code have no meaning and should be ignored.
 */
public class MorseCodeDecoder2 {
	static Map<String, String> codes = Arrays.asList("A:.-","B:-...","C:-.-.","D:-..","E:.","F:..-.","G:--.","H:....","I:..",
			                                   "J:.---","K:-.-","L:.-..","M:--","N:-.","O:---","P:.--.","Q:--.-","R:.-.",
			                                   "S:...","T:-","U:..-","V:...-","W:.--","X:-..-","Y:-.--","Z:--.."," :   ", "SOS:...---...",
			                                   "?:..--..","/:-..-.",".:.-.-.-",",:--..--","!:-.-.--")
									.stream()
									.map(elem -> elem.split(":"))
									.collect(Collectors.toMap(elem -> elem[1], elem -> elem[0]));
	
    public static String decode(String morseCode) {
        return Arrays.stream(morseCode.trim().split("   "))
                .map(MorseCodeDecoder2::decodeWord)
                .collect(Collectors.joining(" "));
    }

    private static String decodeWord(String word) {
        return Arrays.stream(word.split(" ")).map(codes::get).collect(Collectors.joining());
    }
}
