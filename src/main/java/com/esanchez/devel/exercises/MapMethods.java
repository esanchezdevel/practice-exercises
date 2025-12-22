package com.esanchez.devel.exercises;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapMethods {

	/**
	 * Exercise 1
	 * Find the first repeated element in one array.
	 * If there are no repeated elements, it must return -1
	 * Example:
	 * Input:  [2, 1, 3, 5, 3, 2]
	 * Output: 3
	 * 
	 * This solution has a complexity of O(n)
	 */
	public int findFirstRepeatedElement(int[] input) {
		
		if (input.length == 0 || input.length == 1) return -1;
		
		Set<Integer> processed = new HashSet<>();
		
		for (int i = 0; i < input.length; i++) {
			if (!processed.contains(input[i])) processed.add(input[i]);
			else return input[i]; // found
		}
		return -1;
	}
	
	/**
	 * Exercise 2
	 * Find the first NON repeated character in one String
	 * Example:
	 * Input:  "swiss"
	 * Output: 'w'
	 */
	public char findFirstNonRepeatedCharacter(String text) {
		
		char[] chars = text.toCharArray();
		
		Map<Character, Integer> uniqueCharsMap = createUniqueCharsMap(chars);
		
		for (char c : chars) {
			if (!isCharRepeated(c, uniqueCharsMap)) return c;
		}
		
		return '\0';
	}
	
	private Map<Character, Integer> createUniqueCharsMap(char[] chars) {
		Map<Character, Integer> uniqueChars = new HashMap<>();
		
		for (char c : chars) {
			if (uniqueChars.containsKey(c)) uniqueChars.put(c, uniqueChars.get(c) + 1);
			else uniqueChars.put(c, 1);
		}
		
		return uniqueChars;
	}
	
	private boolean isCharRepeated(char originalChar, Map<Character, Integer> uniqueCharsMap) {
		return uniqueCharsMap.containsKey(originalChar) && 
				uniqueCharsMap.get(originalChar) > 1;
	}
}
