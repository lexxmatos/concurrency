package com.lexmatos.problems;

/**
 * Find the greatest common divisor between numbers A and B  
 * 10/2=5 rest of 0, 22/6 =3 rest of 4, 6/4 = 1 rest of 2, 4/2=2 rest of 0  
 * */
public class EuclidAlgorith {
	public static int greatestDivisor(int a, int b) {
		int restOf = a % b;
		while (restOf > 0)  {
			a = b;
			b = restOf;
			restOf = a % b;
		}
		return b;
	}
}
