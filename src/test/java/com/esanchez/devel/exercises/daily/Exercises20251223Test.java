package com.esanchez.devel.exercises.daily;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class Exercises20251223Test {

	private static final Exercises20251223 exercises20251223 = new Exercises20251223();
	
	@Test
	void validateSortArray() {
		
		int[] input1 = {3, 6, 12, 1, 9, 32, 20, 8};
		int[] input2 = {4, 2, 0, 98, 32, 21, 3, 5, 1};
		
		int[] result1 = exercises20251223.sortArray(input1);
		int[] result2 = exercises20251223.sortArray(input2);
		
		int[] expected1 = {1, 3, 6, 8, 9, 12, 20, 32};
		assertNotNull(result1);
		assertEquals(8, result1.length);
		for (int i = 0; i < expected1.length; i++) assertEquals(expected1[i], result1[i]);
		
		int[] expected2 = {0, 1, 2, 3, 4, 5, 21, 32, 98};
		assertNotNull(result2);
		assertEquals(9, result2.length);
		for (int i = 0; i < expected2.length; i++) assertEquals(expected2[i], result2[i]);
	}
	
	@Test
	void validateParenthesesBalance() {
		boolean result1 = exercises20251223.checkParentheses("()");
		boolean result2 = exercises20251223.checkParentheses("(())");
		boolean result3 = exercises20251223.checkParentheses("()()");
		boolean result4 = exercises20251223.checkParentheses("(()");
		boolean result5 = exercises20251223.checkParentheses(")(");
		boolean result6 = exercises20251223.checkParentheses("())(()");
		boolean result7 = exercises20251223.checkParentheses("");
		
		assertTrue(result1);
		assertTrue(result2);
		assertTrue(result3);
		assertFalse(result4);
		assertFalse(result5);
		assertFalse(result6);
		assertTrue(result7);
	}
	
	@Test
	void validateReverse() {
		String result1 = exercises20251223.reverse("Hello");
		String result2 = exercises20251223.reverse("It is a test");
		String result3 = exercises20251223.reverse("Defect");
		
		assertEquals("olleH", result1);
		assertEquals("tset a si tI", result2);
		assertEquals("tcefeD", result3);
	}
}
