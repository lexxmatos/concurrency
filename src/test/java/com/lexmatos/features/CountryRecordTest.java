package com.lexmatos.features;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountryRecordTest {
	   @Test
	   void oldStyleTest() {
		   CountryLombok brasil = new CountryLombok("Brasil", 8516, "Portugues");
		   Assertions.assertEquals("CountryLombok(name=Brasil, size=8516, idiom=Portugues)", brasil.toString());
		   
		   CountryLombok portugal =CountryLombok.builder()
				   					.name("Portugal")
				   					.size(92)
				   					.idiom("Portugues")
				   					.build();
		   Assertions.assertEquals("CountryLombok(name=Portugal, size=92, idiom=Portugues)", portugal.toString());
		   
		   CountryLombok france =CountryLombok.builder()
  					.name("France")
  					.size(551)
  					.idiom("French")
  					.build();
		   Assertions.assertEquals("CountryLombok(name=France, size=551, idiom=French)", france.toString());		   
		   
	   }
	   @Test
	   void newStyleTest() {
		   CountryRecord countryRecord = new CountryRecord("Brasil", 8516, "Portugues");
		   Assertions.assertEquals("CountryRecord[name=Brasil, size=8516, idiom=Portugues]", countryRecord.toString());
		   
		   CountryRecord france =CountryRecord.builder()
 					.name("France")
 					.size(551)
 					.idiom("French")
 					.build();
		   Assertions.assertEquals("CountryRecord[name=France, size=551, idiom=French]", france.toString());		   
	   }	   
}
