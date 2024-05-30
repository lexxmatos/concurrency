package com.lexmatos.codewars;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

@DisplayName("MorseCodeDecoder teste")
class MorseCodeDecoderTest {

	@Test
	void morseCode() {
		Assertions.assertEquals("HEY", MorseCodeDecoder.decode(".... . -.--")); 
		Assertions.assertEquals("HEY JUDE", MorseCodeDecoder.decode(".... . -.--   .--- ..- -.. ."));
		Assertions.assertEquals("SOS", MorseCodeDecoder.decode("...---..."));
		Assertions.assertEquals("E E", MorseCodeDecoder.decode("    .   .  "));
		
		Assertions.assertEquals("HEY", MorseCodeDecoder2.decode(".... . -.--")); 
		Assertions.assertEquals("HEY JUDE", MorseCodeDecoder2.decode(".... . -.--   .--- ..- -.. ."));
		Assertions.assertEquals("SOS", MorseCodeDecoder2.decode("...---..."));
		Assertions.assertEquals("E E", MorseCodeDecoder2.decode("    .   .  ")); 		
	}
}
