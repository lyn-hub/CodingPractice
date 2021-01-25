package hashMap;

import hashMap.MyHashMap.Node;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyHashMaptest {
	
	private static MyHashMap<String, Integer> hashMap = new MyHashMap <String, Integer>();

	@BeforeEach
	void setUp() throws Exception {
		hashMap.clear();
	}

	@Test
	void testSize() {
		hashMap.put("a", 1);
		assertEquals(1, hashMap.size());
	}

	@Test
	void testIsEmpty() {
		assertEquals(true, hashMap.isEmpty());
	}

	@Test
	void testClear() {
		hashMap.put("a", 1);
		hashMap.put("b", 1);
		hashMap.clear();
		assertEquals(0, hashMap.size());
	}

	@Test
	void testContainsValue() {
		hashMap.put("a", 1);
		assertEquals(true, hashMap.containsValue(1));
		assertEquals(false, hashMap.containsValue(2));
	}

	@Test
	void testContainsKey() {
		hashMap.put("a", 1);
		assertEquals(true, hashMap.containsKey("a"));
		assertEquals(false, hashMap.containsKey("b"));
	}

	@Test
	void testGet() {
		hashMap.put("a", 1);
		assertEquals(1, hashMap.get("a"));
		assertEquals(null, hashMap.get("b"));
	}

	@Test
	void testPut() {
		hashMap.put("a", 1);
		assertEquals(1, hashMap.put("a", 2));
		assertEquals(null, hashMap.put("b", 1));
		assertEquals(2, hashMap.size());
		for (int i = 0; i < 17; i++) {
			hashMap.put(String.valueOf((char)(97 + i)), 1);
		}
		assertEquals(17, hashMap.size());
	}

	@Test
	void testRemove() {
		hashMap.put("a", 1);
		hashMap.put("b",2);
		assertEquals(2, hashMap.remove("b"));
		assertEquals(1, hashMap.size());
	}	
	
	@Test
	void testEntrySet() {
		hashMap.put("a", 1);
		Set<Node<String, Integer>> set = hashMap.entrySet(); 
		for(Node<String, Integer> node : set) {
		    assertEquals(1, node.getValue());
		    assertEquals("a", node.getKey());
		}
		
	}

}
