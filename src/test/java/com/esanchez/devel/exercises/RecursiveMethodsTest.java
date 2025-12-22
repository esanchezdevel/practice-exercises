package com.esanchez.devel.exercises;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
	
	@Test
	void validatePower() {
		double result1 = recursiveMethods.power(2, 3);
		double result2 = recursiveMethods.power(5, 0);
		double result3 = recursiveMethods.power(10, 1);
		double result4 = recursiveMethods.power(2, -2);
		double result5 = recursiveMethods.power(4, -1);
		
		assertEquals(8.0, result1);
		assertEquals(1.0, result2);
		assertEquals(10.0, result3);
		assertEquals(0.25, result4);
		assertEquals(0.25, result5);
	}
	
	@Test
	void validateSumNaturalNumbers() {
		int result1 = recursiveMethods.calculateSumOfNaturalNumbers(0);
		int result2 = recursiveMethods.calculateSumOfNaturalNumbers(1);
		int result3 = recursiveMethods.calculateSumOfNaturalNumbers(3);
		int result4 = recursiveMethods.calculateSumOfNaturalNumbers(5);
		
		assertEquals(0, result1);
		assertEquals(1, result2);
		assertEquals(6, result3);
		assertEquals(15, result4);
	}
	
	@Test
	void validateFactorial() {
		int result1 = recursiveMethods.calculateFactorial(0);
		int result2 = recursiveMethods.calculateFactorial(1);
		int result3 = recursiveMethods.calculateFactorial(5);
		
		assertEquals(1, result1);
		assertEquals(1, result2);
		assertEquals(120, result3);
	}
}
