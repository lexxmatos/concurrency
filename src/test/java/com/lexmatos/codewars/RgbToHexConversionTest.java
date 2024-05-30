package com.lexmatos.codewars;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class RgbToHexConversionTest {
	
	@Test
	void Rgb() {
		Assertions.assertEquals("FFFFFF",RgbToHexConversion.rgb(255,255,255));
		Assertions.assertEquals("FFFFFF",RgbToHexConversion.rgb(255,255,300));
		Assertions.assertEquals("010203",RgbToHexConversion.rgb(1,2,3));
		Assertions.assertEquals("000000",RgbToHexConversion.rgb(0,0,0));
		Assertions.assertEquals("00FF7D",RgbToHexConversion.rgb(-20,275,125));
		Assertions.assertEquals("9400D3",RgbToHexConversion.rgb(148,0,211));
	}
}
