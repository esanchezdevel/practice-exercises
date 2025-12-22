package com.esanchez.devel.exercises;

/**
 * In this class I will practice exercises with sort algorithms
 */
public class SortMethods {

	/**
	 * Exercise 1 - Bubble Sort (Not Efficient)
	 * Implement the Bubble Sort algorithm to sort an array of integers in ascending order.
	 * Example:
	 * Input:  [5, 1, 4, 2, 8]
	 * Output: [1, 2, 4, 5, 8]
	 */
	public int[] bubbleSort(int[] input) {
		
		boolean changes = false;
		
		do {
			changes = false;
			int previous = input[0];
			for (int i = 1; i < input.length; i++) {
				previous = input[i - 1];
				if (input[i] < previous) {
					
					input[i -1] = input[i];
					input[i] = previous;
					changes = true;
				}
			}
		} while(changes);
		return input;
	}
}
