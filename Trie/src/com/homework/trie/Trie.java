package com.homework.trie;

import java.util.*;


public class Trie {
	private TrieNode root;
	
	public static class TrieNode {
		char c;
		Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
		boolean isWord;
		int count;
		public TrieNode() {};
		public TrieNode(char c) {
			this.c = c;
		}
		
	}
	public Trie() {
		root = new TrieNode();
	}
	
	public boolean search (String word) {
		TrieNode cur = root;
		for (int i = 0; i < word.length(); i++) {
			TrieNode next = cur.children.get(word.charAt(i));
			if (next == null) {
				return false;
			}
			cur = next;
		}
		return cur.isWord;
	}
	
	public boolean insert(String word) {
		if (search(word)) {
			return false;
		}
		TrieNode cur = root;
		for (int i = 0; i < word.length(); i++) {
			TrieNode next = cur.children.get(word.charAt(i));
			if (next == null) {
				next = new TrieNode();
				cur.children.put(word.charAt(i), next);
			}
			cur = next;
			cur.count++;
		}
		cur.isWord = true;
		return true;
	}
	
	public boolean delete(String word) {
		if (!search(word)) {
			return false;
		}
		TrieNode cur = root;
		for (int i = 0; i < word.length(); i++) {
			TrieNode next = cur.children.get(word.charAt(i));
			next.count--;
			if (next.count == 0) {
				cur.children.remove(word.charAt(i));
				return true;
			}
			cur = next;
		}
		cur.isWord = false;
		return true;
	}

}
