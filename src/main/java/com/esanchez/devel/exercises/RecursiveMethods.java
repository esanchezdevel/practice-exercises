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
			System.out.println("finalizing recursion");
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
	 *A string is a palindrome if it reads the same forwards and backwards.
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
}
