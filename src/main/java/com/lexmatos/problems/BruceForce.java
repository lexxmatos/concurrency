package com.lexmatos.problems;

/*
 * Find a pattern in a String */
public class BruceForce  {
	public static boolean findPattern(String sentece, String pattern) {

		char[] sentenceChar = sentece.toCharArray();
		char[] patternChar = pattern.toCharArray();
		boolean findIt = false;
		int indexPattern = 0;
		for (int s = 0; s < sentece.length() - pattern.length() - 1; s++) {
			if (sentenceChar[s] == patternChar[indexPattern]) {
				findIt = true;
				for (int p = indexPattern +1; p < patternChar.length; p++) {
					findIt = findIt && sentenceChar[s+p] == patternChar[p];
				}
			}
		}
		return findIt;
	}
}
