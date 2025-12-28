package com.esanchez.devel.exercises;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CacheInMemoryTest {

	@Test
	void validateCacheInMemory() throws Exception {
		CacheInMemory.add("key1", "test");
		
		assertTrue(CacheInMemory.get("key1").isPresent());
		assertEquals("test", CacheInMemory.get("key1").get());
		
		Thread.sleep(11000);
		
		assertTrue(CacheInMemory.get("key1").isEmpty());
	}
	
}
