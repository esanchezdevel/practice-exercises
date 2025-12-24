package com.esanchez.devel.exercises.daily;

import java.util.Arrays;

public class Exercises20251223 {

	/**
	 * Exercise 1
	 * Sort an array using the Merge Sort algorithm
	 */
	public int[] sortArray(int[] input) {
		
		if (input.length == 0 || input.length == 1) return input;
		
		int middle = input.length / 2;
		
		int[] left = Arrays.copyOfRange(input, 0, middle);
		int[] right = Arrays.copyOfRange(input, middle, input.length);
		
		left = sortArray(left);
		right = sortArray(right);
		
		return merge(left, right);
	}
	
	private int[] merge(int[] left, int[] right) {
		
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
	
	/**
	 * Exercise 2
	 * Write a recursive method that checks whether a given string of parentheses is balanced.
	 * A string is considered balanced if:
	 * 	- Every opening parenthesis '(' has a matching closing parenthesis ')'
	 *  - Parentheses are closed in the correct order
	 */
	public boolean checkParentheses(String text) {
		
		if (text == null) throw new IllegalArgumentException("Invalid text received");
		
		int position = 0;
		int openParentheses = 0;
		return recursiveCheckParentheses(text, position, openParentheses);
	}
	
	private boolean recursiveCheckParentheses(String text, int position, int openParentheses) {
		
		if (position == text.length()) return openParentheses == 0;
		
		if (text.length() == 0 || (text.length() == 1 && !text.equals(")") && !text.equals("("))) return true;
		
		if (text.charAt(position) == '(') openParentheses++;
		
		if (text.charAt(position) == ')' && openParentheses > 0) openParentheses--;
		else if (text.charAt(position) == ')' && openParentheses == 0) return false;
		
		position++;
		return recursiveCheckParentheses(text, position, openParentheses);
	}
	
	/**
	 * Exercise 3
	 * Return a reverse string
	 * Example
	 * input: hello
	 * output: olleh
	 */
	public String reverse(String text) {
		char[] chars = text.toCharArray();
		char[] result = new char[text.length()];

		int positionOriginal = text.length() - 1;
		int positionResult = 0;
		
		return String.valueOf(recursiveReverseText(chars, result, positionOriginal, positionResult));
	}
	
	private char[] recursiveReverseText(char[] chars, char[] result, int positionOriginal, int positionResult) {
				
		if (positionOriginal < 0) return result;
		
		result[positionResult++] = chars[positionOriginal--];
		
		return recursiveReverseText(chars, result, positionOriginal, positionResult);
	}
}









