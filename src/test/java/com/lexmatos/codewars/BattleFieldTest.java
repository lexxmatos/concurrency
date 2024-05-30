package com.lexmatos.codewars;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BattleFieldTest {

	  private static int[][] battleField = {{1, 0, 0, 0, 0, 1, 1, 0, 0, 0},
              {1, 0, 1, 0, 0, 0, 0, 0, 1, 0},
              {1, 0, 1, 0, 1, 1, 1, 0, 1, 0},
              {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
              {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
              {0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
              {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
              {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
              {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
              {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

//	  @Test
	  public void SampleTest() {
		  Assertions.assertEquals(true, BattleField.fieldValidator(battleField));
	  }
}
