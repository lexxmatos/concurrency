package com.lexmatos.codewars;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PhoneWordsTest {

	@Test
	void edgeCasesTest(){
		Assertions.assertEquals("", PhoneWords.phoneWords(""));
		Assertions.assertEquals("", PhoneWords.phoneWords("111"));
		Assertions.assertEquals("", PhoneWords.phoneWords(null));
	}	   
	@Test
	void basicTest() {
		Assertions.assertEquals("hello how are you", PhoneWords.phoneWords("443355555566604466690277733099966688"));
		Assertions.assertEquals("kata", PhoneWords.phoneWords("55282"));
		Assertions.assertEquals("im a tester", PhoneWords.phoneWords("44460208337777833777"));
		Assertions.assertEquals("codewars", PhoneWords.phoneWords("22266631339277717777"));
		Assertions.assertEquals("null", PhoneWords.phoneWords("66885551555"));
		Assertions.assertEquals("text", PhoneWords.phoneWords("833998"));
		Assertions.assertEquals("   ", PhoneWords.phoneWords("000"));
		Assertions.assertEquals("java", PhoneWords.phoneWords("528882"));
		Assertions.assertEquals("kumite", PhoneWords.phoneWords("55886444833"));
		Assertions.assertEquals("apple", PhoneWords.phoneWords("271755533"));
	}		
}
