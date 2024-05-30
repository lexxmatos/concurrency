package com.lexmatos.codewars;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GreedTest {
	   @Test
	   void testExample() {
		   Assertions.assertEquals(1200, Greed.greedy(new int[]{1,1,1,1,1}));
		   Assertions.assertEquals(250, Greed.greedy(new int[]{5,1,3,4,1}));
		   Assertions.assertEquals(1100, Greed.greedy(new int[]{1,1,1,3,1}));
		   Assertions.assertEquals(450, Greed.greedy(new int[]{2,4,4,5,4}));
	   }	
}
