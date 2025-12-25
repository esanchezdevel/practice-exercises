package com.esanchez.devel.exercises;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class RateLimiterTest {

	private static final RateLimiter rateLimiter = new RateLimiter();
	
	@Test
	void validateRateLimiter() {
		
		String userId = "01";
		
		boolean isAllowed = rateLimiter.allowRequest(userId);
		assertTrue(isAllowed);
		isAllowed = rateLimiter.allowRequest(userId);
		assertTrue(isAllowed);
		isAllowed = rateLimiter.allowRequest(userId);
		assertTrue(isAllowed);
		isAllowed = rateLimiter.allowRequest(userId);
		assertTrue(isAllowed);
		isAllowed = rateLimiter.allowRequest(userId);
		assertTrue(isAllowed);
		isAllowed = rateLimiter.allowRequest(userId);
		assertFalse(isAllowed);
		try {
			Thread.sleep(11000);
		} catch (Exception e) {
			e.printStackTrace();
			Thread.interrupted();
		}
		isAllowed = rateLimiter.allowRequest(userId);
		assertTrue(isAllowed);
	}
}
