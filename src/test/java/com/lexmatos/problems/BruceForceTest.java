package com.lexmatos.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BruceForceTest {
	@Test
	void test() {
		   Assertions.assertEquals(true, BruceForce.findPattern("Alexandre dos Santos Matos", "M"));
		   Assertions.assertEquals(false, BruceForce.findPattern("Alexandre dos Santos Matos", "K"));
		   Assertions.assertEquals(true, BruceForce.findPattern("Alexandre dos Santos Matos", "Ma"));
		   Assertions.assertEquals(false, BruceForce.findPattern("Alexandre dos Santos Matos", "ka"));
		   Assertions.assertEquals(true, BruceForce.findPattern("Alexandre dos Santos Matos", "Mat"));
		   Assertions.assertEquals(true, BruceForce.findPattern("Alexandre dos Santos Matos", "Alex"));
		   Assertions.assertEquals(true, BruceForce.findPattern("Alexandre dos Santos Matos", "Alexandre dos Santos M"));
		   Assertions.assertEquals(false, BruceForce.findPattern("Alexandre dos Santos Matos", "Alexandre dos Santo M"));
		   Assertions.assertEquals(false, BruceForce.findPattern("Alexandre dos Santos Matos", "Alexandre dos Santos Mo"));
		   Assertions.assertEquals(false, BruceForce.findPattern("Alexandre dos Santos Matos", "dys"));
		   
	}
}
