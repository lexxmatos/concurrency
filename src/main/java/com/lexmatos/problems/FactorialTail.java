package com.lexmatos.problems;

import java.util.stream.LongStream;

public class FactorialTail {
  public static long factorialTail(long n){
    return factorial(1, n);
  }
  private static long factorial(long acc, long v){
    return v == 1 ? acc : factorial (acc * v, v -1);
  }

  public static long factorialStream(long n){
    return LongStream.rangeClosed(1,n).reduce(1, (n1, n2) -> n1 * n2);
  }
}
