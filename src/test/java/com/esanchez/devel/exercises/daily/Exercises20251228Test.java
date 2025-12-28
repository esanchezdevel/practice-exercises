package com.esanchez.devel.exercises.daily;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class Exercises20251228Test {

	private static final Exercises20251228 exercises20251228 = new Exercises20251228();
	
	@Test
	void validateSortArray() {
		
		int[] input1 = {3, 6, 12, 1, 9, 32, 20, 8};
		int[] input2 = {4, 2, 0, 98, 32, 21, 3, 5, 1};
		
		int[] result1 = exercises20251228.sortArray(input1);
		int[] result2 = exercises20251228.sortArray(input2);
		
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
	void validateSortArrayWithStream() {
		
		int[] input1 = {3, 6, 12, 1, 9, 32, 20, 8};
		int[] input2 = {4, 2, 0, 98, 32, 21, 3, 5, 1};
		
		int[] result1 = exercises20251228.sortArrayWithStream(input1);
		int[] result2 = exercises20251228.sortArrayWithStream(input2);
		
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
	void validateRateLimiter() {
		
		String userId = "01";
		
		boolean isAllowed = exercises20251228.isAllowed(userId);
		assertTrue(isAllowed);
		isAllowed = exercises20251228.isAllowed(userId);
		assertTrue(isAllowed);
		isAllowed = exercises20251228.isAllowed(userId);
		assertTrue(isAllowed);
		isAllowed = exercises20251228.isAllowed(userId);
		assertTrue(isAllowed);
		isAllowed = exercises20251228.isAllowed(userId);
		assertTrue(isAllowed);
		isAllowed = exercises20251228.isAllowed(userId);
		assertFalse(isAllowed);
		try {
			Thread.sleep(11000);
		} catch (Exception e) {
			e.printStackTrace();
			Thread.interrupted();
		}
		isAllowed = exercises20251228.isAllowed(userId);
		assertTrue(isAllowed);
	}
}
