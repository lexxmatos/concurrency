package com.lexmatos.codewars;

public class Greed2 {
	  public static int greedy(int[] dice){
	        int res = 0;
	        int[] count = new int[]{0, 0, 0, 0, 0, 0};
	        int[] weight = new int[]{100, 0, 0, 0, 50, 0};
	        int[] weight3 = new int[]{1000, 200, 300, 400, 500, 600};

	        for (int die : dice) count[die-1]++;

	        for (int i = 0; i < count.length; i++) res+=(count[i]/3*weight3[i]) + (count[i]%3 * weight[i]);

	        return res;
	  }	
}
