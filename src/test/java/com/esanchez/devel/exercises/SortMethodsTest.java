package com.esanchez.devel.exercises;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class SortMethodsTest {

	private static SortMethods sortMethods = new SortMethods();
	
	@Test
	void validateBubbleSort() {
		int[] input = {5, 1, 4, 2, 8};
		int[] output = sortMethods.bubbleSort(input);
		
		int[] expected = {1, 2, 4, 5, 8};
		
		assertNotNull(output);
		assertEquals(5, output.length);
		for (int i = 0; i < output.length; i++) {
			assertEquals(input[i], output[i]);
		}
	}
}
