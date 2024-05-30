package com.lexmatos.features;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InstanceOfPatternTest {
	   @Test
	   void oldStyleTest() {
		   Assertions.assertEquals("InstanceOfPattern.Country(name=Portugal, idiom=Portugueses)", InstanceOfPattern.oldOne(new InstanceOfPattern.Country("Portugal","Portugueses")));
		   Assertions.assertEquals("1", InstanceOfPattern.oldOne(1l));
	   }
	   
	   @Test
	   void newStyleTest() {
		   Assertions.assertEquals("InstanceOfPattern.Country(name=Brazil, idiom=Portugueses)", InstanceOfPattern.newOne(new InstanceOfPattern.Country("Brazil","Portugueses")));
		   Assertions.assertEquals("PORTUGAL", InstanceOfPattern.newOne(new InstanceOfPattern.Country("Portugal","Portugueses")));
		   Assertions.assertEquals("1", InstanceOfPattern.newOne(1l));
	   }
	   
}
