package com.lexmatos.coding;

import java.util.Base64;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("BasicAutentication")
public class BasicAutentication {
	
	@Test
	public void createEncript() {
		
	    String originalInput = "interloc"+":"+12345;
	    String encodedString = "Basic "+Base64.getEncoder().encodeToString(originalInput.getBytes());
	    
	    Assert.assertEquals(encodedString, "Basic aW50ZXJsb2M6MTIzNDU=");
	}
}
