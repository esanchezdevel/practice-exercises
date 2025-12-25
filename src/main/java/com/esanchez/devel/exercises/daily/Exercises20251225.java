package com.esanchez.devel.exercises.daily;

import java.util.Arrays;

public class Exercises20251225 {

	public int[] sortArray(int[] input) {
		
		if (input.length == 0 || input.length == 1) return input;
		
		int middle = input.length / 2;
		
		int[] left = Arrays.copyOfRange(input, 0, middle);
		int[] right = Arrays.copyOfRange(input, middle, input.length);
		
		left = sortArray(left);
		right = sortArray(right);
		
		return merge(left, right);
	}
	
	public int[] merge(int[] left, int[] right) {
		int[] result = new int[left.length + right.length];
		
		int i = 0, j = 0, k = 0;
		
		while (i < left.length && j < right.length) {
			if (left[i] <= right[j]) result[k++] = left[i++];
			else result[k++] = right[j++];
		}
		
		while (i < left.length) result[k++] = left[i++];
		while (j < right.length) result[k++] = right[j++];
		
		return result;
	}
}
