package com.esanchez.devel.exercises;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class RecursiveMethodsTest {

	private RecursiveMethods recursiveMethods = new RecursiveMethods();
	
	@Test
	void validateParenthesesBalance() {
		boolean result1 = recursiveMethods.checkParenthesesBalance("()");
		boolean result2 = recursiveMethods.checkParenthesesBalance("(())");
		boolean result3 = recursiveMethods.checkParenthesesBalance("()()");
		boolean result4 = recursiveMethods.checkParenthesesBalance("(()");
		boolean result5 = recursiveMethods.checkParenthesesBalance(")(");
		boolean result6 = recursiveMethods.checkParenthesesBalance("())(()");
		boolean result7 = recursiveMethods.checkParenthesesBalance("");
		
		assertTrue(result1);
		assertTrue(result2);
		assertTrue(result3);
		assertFalse(result4);
		assertFalse(result5);
		assertFalse(result6);
		assertTrue(result7);
	}
	
	@Test
	void validatePalindrome() {
		boolean result1 = recursiveMethods.isPalindrome("abba");
		boolean result2 = recursiveMethods.isPalindrome("racecar");
		boolean result3 = recursiveMethods.isPalindrome("a");
		boolean result4 = recursiveMethods.isPalindrome("");
		boolean result5 = recursiveMethods.isPalindrome("abc");
		boolean result6 = recursiveMethods.isPalindrome("abca");
		
		assertTrue(result1);
		assertTrue(result2);
		assertTrue(result3);
		assertTrue(result4);
		assertFalse(result5);
		assertFalse(result6);
	}
}
