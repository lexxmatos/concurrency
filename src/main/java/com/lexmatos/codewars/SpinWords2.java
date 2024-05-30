package com.lexmatos.codewars;

import java.util.stream.*;
import java.util.Arrays;

public class SpinWords2 {

  public String spinWords(String sentence) {
    return Arrays.stream(sentence.split(" "))
                 .map(i -> i.length() > 4 ? new StringBuilder(i).reverse().toString() : i)
                 .collect(Collectors.joining(" "));
  }
}