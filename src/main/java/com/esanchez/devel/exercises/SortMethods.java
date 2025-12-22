package com.esanchez.devel.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * In this class I will practice exercises with sort algorithms
 */
public class SortMethods {

	/**
	 * Exercise 1 - Bubble Sort (Not Efficient) O(n2)
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
	
	/**
	 * Exercise 2 - Merge sort (Efficient) O(n log n)
	 * Implement the Merge Sort algorithm to sort an array of integers in ascending order.
	 * Example:
	 * Input:  [5, 1, 2, 8]
	 * Output: [1, 2, 5, 8]
	 */
	public int[] mergeSort(int[] input) {
		
		// In this case the array is already sorted
		if (input.length == 0 || input.length == 1)
			return input;
		
		// calculate the middle of the array
		int middle = input.length / 2;
		
		// Create two arrays dividing the original array in 2 chunks
		int[] left = Arrays.copyOfRange(input, 0, middle);
		int[] right = Arrays.copyOfRange(input, middle, input.length);
		
		// divide again the chunks until we get the smaller arrays possible (with 1 element)
		left = mergeSort(left);
		right = mergeSort(right);
		
		// merge the two arrays ordering them
		return merge(left, right);
	}
	
	private int[] merge(int[] array1, int[] array2) {
		// create the array where we will merge the two arrays, with the size of the two arrays
		int[] result = new int[array1.length + array2.length];
		
		// initialize the needed variables to go through each array
		int i = 0; // index for array1
		int j = 0; // index for array2
		int k = 0; // index for result
		
		while (i < array1.length && j < array2.length) {
			if (array1[i] <= array2[j]) {
				result[k++] = array1[i++];
			} else {
				result[k++] = array2[j++];
			}
		}
		
		// copy the other elements
		while (i < array1.length) result[k++] = array1[i++];
		while (j < array2.length) result[k++] = array2[j++];
		
		return result;
	}
	
	/**
	 * Repeat Exercise 2 of Merge sort, but this time do it without help
	 * Divide & Conquer
	 */
	public int[] mergeSort2(int[] input) {
		
		if (input.length == 0 || input.length == 1) return input;
		
		int middle = input.length / 2;
		
		int[] left = Arrays.copyOfRange(input, 0, middle);
		int[] right = Arrays.copyOfRange(input, middle, input.length);
		
		left = mergeSort2(left);
		right = mergeSort2(right);
		
		return merge2(left, right);
	}
	
	private int[] merge2(int[] left, int[] right) {
		int[] result = new int[left.length + right.length];
		
		int i = 0, j = 0, k = 0; //i for left, j for right, k for result
		
		while (i < left.length && j < right.length) {
			if (left[i] <= right[j]) result[k++] = left[i++];
			else result[k++] = right[j++];
		}
		
		while (i < left.length) result[k++] = left[i++];
		while (j < right.length) result[k++] = right[j++];
		
		return result;
	}

	private void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) System.out.print(array[i] + ",");
		System.out.println("");
	}
}
