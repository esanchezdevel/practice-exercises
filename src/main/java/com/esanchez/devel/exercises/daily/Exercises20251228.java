package com.esanchez.devel.exercises.daily;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class Exercises20251228 {

	private static final ConcurrentHashMap<String, Record> accessControl = new ConcurrentHashMap<>();
	
	private static final int MAX_NUMBER_OF_ACCESS = 5;
	private static final int PERIOD_RANGE = 10;
	
	public int[] sortArray(int[] input) {
		
		if (input.length == 0 || input.length == 1) return input;
		
		int middle = input.length / 2;
		
		int[] left = Arrays.copyOfRange(input, 0, middle);
		int[] right = Arrays.copyOfRange(input, middle, input.length);
		
		left = sortArray(left);
		right = sortArray(right);
		
		return merge(left, right);
	}
	
	private int[] merge(int[] left, int[] right) {
		
		int[] result = new int[left.length + right.length];
		
		int i = 0, j = 0, k = 0;
		
		while (i < left.length && j < right.length) {
			
			if (left[i] <= right[j]) {
				result[k++] = left[i++];
			} else {
				result[k++] = right[j++];
			}
		}
		
		while (i < left.length) result[k++] = left[i++];
		while (j < right.length) result[k++] = right[j++];
		
		return result;
	}
	
	public int[] sortArrayWithStream(int[] input) {
		return Arrays.stream(input).sorted().toArray();
	}
	
	public boolean isAllowed(String userId) {
		
		AtomicBoolean allowed = new AtomicBoolean(true);
		
		long now = System.currentTimeMillis() / 1000;
		
		accessControl.compute(userId, (k, v) -> {
			if (v == null) {
				return new Record(1, now);
			}
			
			boolean isWithinPeriodTime = now - v.getFirstAccess() < PERIOD_RANGE;
			
			if (!isWithinPeriodTime) {
				v.setCount(1);
				v.setFirstAccess(now);
			} else if (v.getCount() < MAX_NUMBER_OF_ACCESS) {
				v.setCount(v.getCount() + 1);
			} else if (v.getCount() >= MAX_NUMBER_OF_ACCESS) {
				allowed.set(false);
			}
			return v;
		});
		
		return allowed.get();
	}
	
	private static class Record {
		private int count;
		private long firstAccess;
		
		public Record(int count, long firstAccess) {
			this.count = count;
			this.firstAccess = firstAccess;
		}
		
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
		public long getFirstAccess() {
			return firstAccess;
		}
		public void setFirstAccess(long firstAccess) {
			this.firstAccess = firstAccess;
		}

		@Override
		public String toString() {
			return "Record [count=" + count + ", firstAccess=" + firstAccess + "]";
		}
	}
}
