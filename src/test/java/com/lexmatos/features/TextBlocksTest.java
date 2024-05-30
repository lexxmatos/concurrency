package com.lexmatos.features;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TextBlocksTest {
	   @Test
	   void test() {
		   System.out.println(TextBlocks.oldStyle());
		   System.out.println(TextBlocks.newStyle());
		   Assertions.assertEquals(TextBlocks.oldStyle(), TextBlocks.newStyle());
	   }	
}
