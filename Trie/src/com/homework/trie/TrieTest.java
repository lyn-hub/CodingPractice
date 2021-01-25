package com.homework.trie;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;


public class TrieTest {
	
	private Trie trie = new Trie();

	
	@Test
	public void testSearch() {
		trie.insert("that");
		assertEquals(true, trie.search("that"));
		assertEquals(false, trie.search("we"));
	}

	@Test
	public void testInsert() {
		trie.insert("we");
		assertEquals(true, trie.search("we"));
	}

	@Test
	public void testDelete() {
		trie.delete("we");
		assertEquals(false, trie.search("we"));
	}

}
