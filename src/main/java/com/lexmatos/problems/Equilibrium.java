package com.lexmatos.problems;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Equilibrium {
	private int[] integers;
	private int point;
	
	public Integer sum(int first, int last) {
		int sum = Arrays.stream(integers).reduce(0,(a,b)->  a + b);
		return sum;
	}
	
	
}
