package com.lexmatos.codewars;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.lexmatos.features.StreamList;
import com.lexmatos.features.SwitchExpressions;
import com.lexmatos.features.SwitchExpressions.Country;

public class StreamListTest {
	   @Test
	   void test() {
		   String[] elements = new String[]{"a","b","c","d","e"};
		   Assertions.assertEquals("[a, b, c, d, e]", StreamList.oldStyle(elements).toString());
		   Assertions.assertEquals("[a, b, c, d, e]", StreamList.newStyle(elements).toString());
	   }
}
