package com.esanchez.devel.exercises;

/**
 * In this class I will perform exercises where it's needed to use
 * recursive methods
 */
public class RecursiveMethods {

	/**
	 * Exercise 1
	 * Write a recursive method that checks whether a given string of parentheses is balanced.
	 * A string is considered balanced if:
	 * 	- Every opening parenthesis '(' has a matching closing parenthesis ')'
	 *  - Parentheses are closed in the correct order
	 */
	public boolean checkParenthesesBalance(String text) {
		
		int position = 0;
		int currentNumberOfOpeningCharacters = 0;
		return recursiveCheck(text, position, currentNumberOfOpeningCharacters);
	}
	
	private boolean recursiveCheck(String text, int position, int currentNumberOfOpeningCharacters) {
		
		if (text.length() == position) {
			return currentNumberOfOpeningCharacters == 0;
		}
		
		char c = text.charAt(position);
		
		if (c == '(') {
			currentNumberOfOpeningCharacters++;
		} else if (c == ')' && currentNumberOfOpeningCharacters == 0) {
			return false; // not needed to check more, because there is one wrong close character )
		} else if(c == ')') {
			currentNumberOfOpeningCharacters--;
		}
		
		return recursiveCheck(text, position + 1, currentNumberOfOpeningCharacters);
	}
	
	/**
	 * Exercise 2
	 * Write a recursive method that checks whether a given string is a palindrome.
	 * A string is a palindrome if it reads the same forwards and backwards.
	 */
	public boolean isPalindrome(String text) {
		int position = 0;
		return recursiveCheckPalindrome(text, position);
	}
	
	private boolean recursiveCheckPalindrome(String text, int position) {
		
		if (text.length() == 0 || text.length() == 1)
			return true; // special cases when the string is empty or it has only one character we consider them as palindrome
		
		if (text.length() / 2 == position) {
			return true; // reached the middle of the text, so it's a palindrome
		}
		
		char cFromStart = text.charAt(position);
		char cFromEnd = text.charAt(text.length() - (position + 1));
		
		if (cFromStart == cFromEnd) {
			position++;
			return recursiveCheckPalindrome(text, position);
		} else {
			return false; // it's not a palindrome
		}
	}
	
	/**
	 * Exercise 3
	 * Power Funtion: Write a recursive method that computes the value of a number raised to a power.
	 * Assume that base ≠ 0 when exponent < 0 (no need to handle division by zero)
	 */
	public double power(double base, int exponent) {
		double aggregate = base;
		return recursivePower(base, aggregate, exponent);
	}
	
	private double recursivePower(double base, double aggregate, int exponent) {
		
		if (exponent == 0)
			return 1.0;
		
		if (exponent == 1)
			return aggregate;
		
		if (exponent > 0) {
			aggregate = aggregate * base;
			exponent--;
			return recursivePower(base, aggregate, exponent);
		} else {
			return (1.0 / recursivePower(base, aggregate, -exponent));
		}
	}
	
	/**
	 * Exercise 4
	 * Write a recursive function that calculates the sum of the first n natural numbers.
	 * Examples:
	 * sum(1) → 1
	 * sum(3) → 1 + 2 + 3 = 6
	 * sum(5) → 15
	 */
	public int calculateSumOfNaturalNumbers(int n) {
		return recursiveSum(n);
	}
	
	private int recursiveSum(int n) {
		
		if (n == 0)
			return n;
		
		return n + recursiveSum(n - 1);
	}
	
	/**
	 * Exercise 5
	 * Write a recursive function that calculates the factorial of a non-negative integer n.
	 * Examples:
	 * factorial(0) → 1
	 * factorial(1) → 1
	 * factorial(5) → 5 × 4 × 3 × 2 × 1 = 120
	 */
	public int calculateFactorial(int n) {
		return recursiveFactorial(n);
	}
	
	private int recursiveFactorial(int n) {
		
		if (n < 0)
			throw new IllegalArgumentException("The value of n must be non-negative");
		
		if (n == 0)
			return 1;
		
		return n * recursiveFactorial(n - 1);
	}
}
