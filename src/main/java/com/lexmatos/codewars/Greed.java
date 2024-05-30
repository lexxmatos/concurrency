package com.lexmatos.codewars;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

//https://www.codewars.com/kata/5270d0d18625160ada0000e4/train/java
/**
Greed is a dice game played with five six-sided dice. Your mission, should you choose to accept it, is to score a throw according to these rules. 
You will always be given an array with five six-sided dice values.

 Three 1's => 1000 points
 Three 6's =>  600 points
 Three 5's =>  500 points
 Three 4's =>  400 points
 Three 3's =>  300 points
 Three 2's =>  200 points
 One   1   =>  100 points
 One   5   =>   50 point

A single die can only be counted once in each roll. For example, a given "5" can only count as part of a triplet (contributing to the 500 points) or as a single 50 points, 
but not both in the same roll.

Example scoring

 Throw       Score
 ---------   ------------------
 5 1 3 4 1   250:  50 (for the 5) + 2 * 100 (for the 1s)
 1 1 1 3 1   1100: 1000 (for three 1s) + 100 (for the other 1)
 2 4 4 5 4   450:  400 (for three 4s) + 50 (for the 5)
 
 1 1 1 1 1  
 
 1 3 1000 x
 2 3 200  
 3 3 300
 4 3 400 
 5 3 500 
 6 3 600 
 1 1 100
 5 1 50
 
 
 5,1,3,4,1
 */
public class Greed {
	
	public static int greedy(int[] dice){
		
		int[][] values = new int[][]{{1,3,1000}
									,{2,3,200}
									,{3,3,300}
									,{4,3,400}
									,{5,3,500}
									,{6,3,600}
									,{1,1,100}
									,{5,1,50}
									,{2,1,0}
									,{3,1,0}
									,{4,1,0}
									,{6,1,0}
									};
		Map<Integer,Integer> numbersDuplicated = new HashMap<>();
		int result = 0;

		for (int element =0; element < dice.length; element++) {
			if(!Objects.isNull(numbersDuplicated.get(dice[element]))) {
				numbersDuplicated.replace(dice[element], numbersDuplicated.get(dice[element])+1);
			} else 
				numbersDuplicated.put(dice[element], 1);
		} 
		
		while (!numbersDuplicated.isEmpty()) {
			for (int diceNumber =0; diceNumber< values.length; diceNumber ++) {
				if(!Objects.isNull(numbersDuplicated.get(values[diceNumber][0]))) {
					int rollduplicate = numbersDuplicated.get(values[diceNumber][0]);
					if (rollduplicate >= values[diceNumber][1]) {
						rollduplicate -= values[diceNumber][1];
						result +=  values[diceNumber][2];
						
						if (rollduplicate==0) 
							numbersDuplicated.remove(values[diceNumber][0]);
						else 
							numbersDuplicated.replace(values[diceNumber][0], rollduplicate);
					}
				}
			}
		}
	    return result;
	}
}
