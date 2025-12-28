package com.esanchez.devel.exercises;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class CacheInMemory {

	private static final ConcurrentHashMap<String, Object> CACHE = new ConcurrentHashMap<>();
	private static final ConcurrentHashMap<String, Long> CACHE_TTL = new ConcurrentHashMap<>();
	
	private static final long MAX_TTL = 10000;
	
	public static void add(String key, Object value) {
		long now = System.currentTimeMillis();
		if (value instanceof String) {
			CACHE.put(key, (String) value);
			CACHE_TTL.put(key, now);
		}
	}
	
	public static Optional<Object> get(String key) {
		AtomicBoolean isAllowed = new AtomicBoolean(true);
		long now = System.currentTimeMillis();
		CACHE_TTL.compute(key, (k, v) -> {
			if (v == null || now - v >= MAX_TTL) {
				isAllowed.set(false);
				CACHE.remove(k);
				v = null;
			}
			return v;
		});
		
		if (isAllowed.get()) return Optional.ofNullable(CACHE.get(key));
		else return Optional.empty();
	}
}
