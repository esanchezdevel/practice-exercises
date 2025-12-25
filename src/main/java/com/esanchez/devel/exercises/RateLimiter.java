package com.esanchez.devel.exercises;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class RateLimiter {

	private static final int MAX_NUMBER_OF_PETITIONS = 5;
	private static final int TIME_RANGE = 10;
	
	private static final ConcurrentHashMap<String, Record> requestsTracker = new ConcurrentHashMap<>();
	
	/**
	 * Exercise:
	 * Control the access of users allowing only users that makes 5 or less requests in the 
	 * last 10 seconds.
	 * The method has to be thread safe, and consider that multiple users can access at same time.
	 */
	public boolean allowRequest(String userId) {
		
		// use atomic boolean to be able to modify it inside the concurrent map compute method.
		AtomicBoolean isAllowed = new AtomicBoolean(true);
		
		long now = System.currentTimeMillis() / 1000;

		// compute method is used to access to the Concurrent map in a 
		// thread safe mode.
		requestsTracker.compute(userId, (key, value) -> {
			
			if (value == null) {
				return new Record(1, now);
			}
			
			boolean inTimeRange = now - value.getFirstRequest() <= TIME_RANGE;
			
			if (!inTimeRange) {
				value.setCount(1);
				value.setFirstRequest(now);
			} else if (value.getCount() < MAX_NUMBER_OF_PETITIONS) {
				value.setCount(value.getCount() + 1);
			} else if (value.getCount() >= MAX_NUMBER_OF_PETITIONS) {
				isAllowed.set(false);
			}
			
			return value;
		});
		return isAllowed.get();
	}
	
	private class Record {
		
		private int count;
		private long firstRequest;

		public Record(int count, long firstRequest) {
			this.count = count;
			this.firstRequest = firstRequest;
		}
		
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
		public long getFirstRequest() {
			return firstRequest;
		}
		public void setFirstRequest(long firstRequest) {
			this.firstRequest = firstRequest;
		}
		@Override
		public String toString() {
			return "record [count=" + count + ", firstRequest=" + firstRequest + "]";
		}
	}
}