package com.lexmatos.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EuclidAlgorithTest {
	@Test
	void test() {
		   Assertions.assertEquals(2, EuclidAlgorith.greatestDivisor(10, 2));
		   Assertions.assertEquals(2, EuclidAlgorith.greatestDivisor(22, 6));
		   Assertions.assertEquals(1, EuclidAlgorith.greatestDivisor(5, 2));
		   Assertions.assertEquals(1, EuclidAlgorith.greatestDivisor(11, 13));
		   Assertions.assertEquals(30000, EuclidAlgorith.greatestDivisor(240000, 30000));
	}
}
