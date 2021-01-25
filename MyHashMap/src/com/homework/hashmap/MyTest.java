package com.homework.hashmap;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;


public class MyTest {
	
	MyHashMap<String, Integer> hashMap = new MyHashMap <String, Integer>();

	@BeforeEach
	public void setUp() throws Exception {
		hashMap.clear();
	}

	@Test
	public void testSize() {
		Thread t1 = new Thread() {
			@Override 
			public void run() {
				hashMap.put("a", 1);
			}
		};
		t1.start();
		assertEquals(hashMap.size() == 0? 0 : 1, hashMap.size());
	}

	@Test
	public void testIsEmpty() {
		Thread t1 = new Thread() {
			@Override 
			public void run() {
				hashMap.put("a", 1);
			}
		};
		t1.start();
		assertEquals(hashMap.size() == 0? true : false, hashMap.isEmpty());
	}

	@Test
	public void testClear() {
		hashMap.put("a", 1);
		Thread t1 = new Thread() {
			@Override 
			public void run() {
				hashMap.clear();
			}
		};
		t1.start();
		assertEquals(hashMap.size() == 0? 0 : 1, hashMap.size());
	}

	@Test
	public void testPut() {
		hashMap.put("a", 1);
		Thread t1 = new Thread() {
			@Override 
			public void run() {
				hashMap.put("b", 2);
			}
		};
		t1.start();
		assertEquals(hashMap.size() == 1? 1 : 2, hashMap.size());
	}

	@Test
	public void testGet() {
		hashMap.put("a", 1);
		Thread t1 = new Thread() {
			@Override 
			public void run() {
				hashMap.put("b", 2);
			}
		};
		t1.start();
		assertEquals(hashMap.size() == 1? null : 2, hashMap.get("b"));
	}

	@Test
	public void testContainsKey() {
		hashMap.put("a", 1);
		Thread t1 = new Thread() {
			@Override 
			public void run() {
				hashMap.put("b", 2);
			}
		};
		t1.start();
		assertEquals(hashMap.size() == 1? false : true, hashMap.containsKey("b"));
	}

	@Test
	public void testContainsValue() {
		hashMap.put("a", 1);
		Thread t1 = new Thread() {
			@Override 
			public void run() {
				hashMap.put("b", 2);
			}
		};
		t1.start();
		assertEquals(hashMap.size() == 1? false : true, hashMap.containsValue(2));
	}

	@Test
	public void testRemove() {
		hashMap.put("a", 1);
		Thread t1 = new Thread() {
			@Override 
			public void run() {
				hashMap.remove("a");
			}
		};
		t1.start();
		assertEquals(hashMap.size() == 0? null : 1, hashMap.remove("a"));
	}

}

