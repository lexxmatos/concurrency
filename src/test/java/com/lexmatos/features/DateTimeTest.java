package com.lexmatos.features;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DateTimeTest {
	   @Test
	   void newStyleTest() {
		   DateTimeFormatter fmt = DateTimeFormatter.ofPattern("B");
		   Assertions.assertEquals("da manhã",fmt.format(LocalTime.of(8,0))); 
		   Assertions.assertEquals("da tarde",fmt.format(LocalTime.of(13,0))); 
		   Assertions.assertEquals("da noite",fmt.format(LocalTime.of(20,0)));
		   Assertions.assertEquals("meia-noite",fmt.format(LocalTime.of(0,0)));
	   }	
}
