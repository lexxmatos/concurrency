package com.lexmatos.codewars;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Stock list by category")
public class StockListTest {
	
	@Test
	public void firstLetter() { 
		String art[] = new String[]{"ABAR 200", "CDXE 500", "BKWR 250", "BTSQ 890", "DRTY 600"};
   		String cd[] = new String[] {"A", "B"};
   		
   		Assert.assertEquals("(A : 200) - (B : 1140)", StockListOriginal.stockSummary(art, cd));
   		Assert.assertEquals("(A : 200) - (B : 1140)", StockList.stockSummary(art, cd));
   		Assert.assertEquals("(A : 200) - (B : 1140)", StockList2.stockSummary(art, cd));
	}
	
	@Test
	public void secundLetter() { 
		String art[] = new String[]{"ABAR 200", "CDXE 500", "BKWR 250", "BTSQ 890", "DRTY 600"};
   		String cd[] = new String[] {};
   		
   		Assert.assertEquals("", StockListOriginal.stockSummary(art, cd));
   		Assert.assertEquals("", StockList.stockSummary(art, cd));
   		Assert.assertEquals("", StockList2.stockSummary(art, cd));
	}
}
