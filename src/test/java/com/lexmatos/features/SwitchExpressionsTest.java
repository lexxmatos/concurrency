package com.lexmatos.features;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.lexmatos.features.SwitchExpressions.Country;

public class SwitchExpressionsTest {
	   @Test
	   void oldStyleTest() {
		   Assertions.assertEquals("Spanish", SwitchExpressions.oldOne(Country.SPAIN));
		   Assertions.assertEquals("Portuguese", SwitchExpressions.oldOne(Country.BRAZIL));
		   Assertions.assertEquals("Chinese", SwitchExpressions.oldOne(Country.ENGLAND));
		   Assertions.assertEquals("Chinese", SwitchExpressions.oldOne(Country.OTHER));
		   
	   }
	   
	   void newStyleTest() {
		   Assertions.assertEquals("Spanish", SwitchExpressions.oldOne(Country.SPAIN));
		   Assertions.assertEquals("Portuguese", SwitchExpressions.oldOne(Country.BRAZIL));
		   Assertions.assertEquals("English", SwitchExpressions.oldOne(Country.ENGLAND));
		   Assertions.assertEquals("Chinese", SwitchExpressions.oldOne(Country.OTHER));

	   }	
	   
}
