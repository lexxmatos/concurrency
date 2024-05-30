package com.lexmatos.features;

import java.text.NumberFormat;
import java.util.Locale;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberFormatTest {
	   @Test
	   void newStyleTest() {
		   NumberFormat fmt = NumberFormat.getCompactNumberInstance(Locale.forLanguageTag("pt-br"), NumberFormat.Style.LONG);
		   Assertions.assertEquals("1 mil",fmt.format(1000)); 
		   Assertions.assertEquals("100 mil",fmt.format(100000));
		   Assertions.assertEquals("1 milhão",fmt.format(1000000));
		   
		   fmt = NumberFormat.getCompactNumberInstance(Locale.forLanguageTag("en"), NumberFormat.Style.LONG);
		   Assertions.assertEquals("1 thousand",fmt.format(1000));
		   Assertions.assertEquals("100 thousand",fmt.format(100000)); 
	       Assertions.assertEquals("1 million",fmt.format(1000000));
	   }	
}
