package com.lexmatos.features;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NullPointerTest {
	   
	   void oldStyleTest() {
		   NullPointer pointer = new NullPointer();
		   Assertions.assertEquals("hello", pointer.lowerCase());
	   }
}
      