package com.lexmatos.codewars;

import java.util.Arrays;
import java.util.stream.Collectors;

//https://www.codewars.com/kata/5264d2b162488dc400000001/train/java
public class SpinWords {
	  public String spinWords(String sentence) {

		  StringBuilder stringBuild = Arrays.stream(sentence.split(" "))
				  .map(w -> spin(w))
				  .collect(Collectors.toList())
				  .parallelStream()
				  .collect(StringBuilder::new, (x, y) -> x.append(y),(a, b) -> a.append(" ").append(b));
		  return stringBuild.toString();
	  }
	  
	  private String spin(String word) {
		  
		  if(word.length() < 5) return word;

		  return new StringBuilder().append(word).reverse().toString();
	  }
}
