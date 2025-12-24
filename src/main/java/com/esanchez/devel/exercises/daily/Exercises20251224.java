package com.esanchez.devel.exercises.daily;

import java.util.Arrays;

public class Exercises20251224 {

	/**
	 * Exercise 1
	 * Implement the Merge Sort algorithm to sort one array
	 * Divide & Conquer
	 */
	public int[] sortArray(int[] input) {
		
		// in this case the array is already ordered
		if (input.length == 0 || input.length == 1) return input;
		
		// calculate the middle of the array to divide the array
		int middle = input.length / 2;
		
		// create the two arrays dividing the input in 2
		int[] left = Arrays.copyOfRange(input, 0, middle);
		int[] right = Arrays.copyOfRange(input, middle, input.length);
		
		// order each array recursively
		left = sortArray(left);
		right = sortArray(right);
		
		// return the merge of both ordered arrays
		return merge(left, right);
	}
	
	private int[] merge(int[] left, int[] right) {
		int[] result = new int[left.length + right.length];
		
		// create 3 index, one per array
		int i = 0, j = 0, k = 0;
		
		while (i < left.length && j < right.length) {
			if (left[i] <= right[j]) result[k++] = left[i++];
			else result[k++] = right[j++];
		}
		
		// in case there are more elements in any of the arrays, we 
		// copy in the array, because they are already ordered
		while (i < left.length) result[k++] = left[i++];
		while (j < right.length) result[k++] = right[j++];
		
		return result;
	}
}
