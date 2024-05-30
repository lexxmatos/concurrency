package com.lexmatos.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FactorialTailTest {

  @Test
  void factorialTail() {
    Assertions.assertEquals(1, FactorialTail.factorialTail(1));
    Assertions.assertEquals(2, FactorialTail.factorialTail(2));
    Assertions.assertEquals(6, FactorialTail.factorialTail(3));
    Assertions.assertEquals(24, FactorialTail.factorialTail(4));
    Assertions.assertEquals(120, FactorialTail.factorialTail(5));
    Assertions.assertEquals(720, FactorialTail.factorialTail(6));
  }

  @Test
  void factorialStream() {
    Assertions.assertEquals(1, FactorialTail.factorialStream(1));
    Assertions.assertEquals(2, FactorialTail.factorialStream(2));
    Assertions.assertEquals(6, FactorialTail.factorialStream(3));
    Assertions.assertEquals(24, FactorialTail.factorialStream(4));
    Assertions.assertEquals(120, FactorialTail.factorialStream(5));
    Assertions.assertEquals(720, FactorialTail.factorialStream(6));
  }
}
