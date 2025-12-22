package com.esanchez.devel.exercises;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MapMethodsTest {

	private static MapMethods mapMethods = new MapMethods();
	
	@Test
	void validateFindFirstRepeatedElement() {
		
		int[] array1 = {2, 1, 3, 5, 3, 2};
		int[] array2 = {1, 2, 3, 4};
		int[] array3 = {5, 1, 5, 1};
 		
		int result1 = mapMethods.findFirstRepeatedElement(array1);
		int result2 = mapMethods.findFirstRepeatedElement(array2);
		int result3 = mapMethods.findFirstRepeatedElement(array3);
		
		assertEquals(3, result1);
		assertEquals(-1, result2);
		assertEquals(5, result3);
	}
	
	@Test
	void validateFindFirstNonRepeatedCharacter() {
		
		char result1 = mapMethods.findFirstNonRepeatedCharacter("swiss");
		char result2 = mapMethods.findFirstNonRepeatedCharacter("this is a test");
		char result3 = mapMethods.findFirstNonRepeatedCharacter("another test of string");
		
		assertEquals('w', result1);
		assertEquals('h', result2);
		assertEquals('a', result3);
	}
}
