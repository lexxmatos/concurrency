package com.lexmatos.codewars;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class ConversionRomanNumeralTest {
	
    private ConversionRomanNumeral conversion = new ConversionRomanNumeral();

    @Test
    public void shouldConvertToRoman() {
        Assert.assertEquals("solution(1) should equal to I", "I", conversion.solution(1));
//        Assert.assertEquals("solution(2) should equal to II", "II", conversion.solution(2));
//        Assert.assertEquals("solution(3) should equal to III", "III", conversion.solution(3));
        Assert.assertEquals("solution(4) should equal to IV", "IV", conversion.solution(4));
//        Assert.assertEquals("solution(5) should equal to I", "V", conversion.solution(5));
        Assert.assertEquals("solution(6) should equal to VI", "VI", conversion.solution(6));
/*        Assert.assertEquals("solution(7) should equal to VII", "VII", conversion.solution(7));
        Assert.assertEquals("solution(8) should equal to VIII", "VIII", conversion.solution(8));
        Assert.assertEquals("solution(9) should equal to IX", "IX", conversion.solution(9));
    	Assert.assertEquals("solution(10) should equal to X", "X", conversion.solution(10));
    	Assert.assertEquals("solution(30) should equal to XXX", "XXX", conversion.solution(30));
    	Assert.assertEquals("solution(33) should equal to XXXIII", "XXXIII", conversion.solution(33));
        Assert.assertEquals("solution(2008) should equal to MMVIII", "MMVIII", conversion.solution(2008));
        Assert.assertEquals("solution(1990) should equal to MCMXC", "MCMXC", conversion.solution(1990));
        */
    }
}
