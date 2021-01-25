package com.homework.filesystem;

import java.util.*;

public class FileSystem {
	private final Directory root;
	
	public FileSystem() {
		root = new Directory("/", null);
	}
	
	private List<Entry> resolve(String path) {
		assert path.startsWith("/");
		String[] components = path.substring(1).split("/");
		List<Entry> entries = new ArrayList<Entry> (components.length + 1);
		entries.add(root);
		
		Entry entry = root;
		for (String component : components) {
			if (entry == null || !(entry instanceof Directory)) {
				throw new IllegalArgumentException("invalid path: " + path);
			}
			if  (!component.isEmpty()) {
				entry = ((Directory) entry).getChild(component);
				entries.add(entry);
			}
		}
		return entries;
		
	}
	
	public void mkdir(String path) {
		List<Entry> entries = resolve(path);
		if (entries.get(entries.size() - 1) != null) {
			throw new IllegalArgumentException("Directory already exists: " + path);
		}
		String[] components = path.split("/");
		final String dirName = components[components.length - 1];
		final Directory parent = (Directory) entries.get(entries.size() - 2);
		Directory newDir = new Directory(dirName, parent);	
		parent.addEntry(newDir);
	}
	
	public void createFile(String path) {
		assert !path.endsWith("/");
		List<Entry> entries = resolve(path);
		if (entries.get(entries.size() - 1) != null) {
			throw new IllegalArgumentException("File already exists: " + path);
		}
		final Directory parent = (Directory)entries.get(entries.size() - 2);
		final String fileName = path.substring(path.lastIndexOf("/") + 1);		
		File file = new File(fileName, parent, 0);
		parent.addEntry(file);		
	}
	
	public void delete(String path) {
		assert !path.endsWith("/");
		List<Entry> entries = resolve(path);
		if (entries.get(entries.size() - 1) == null) {
			throw new IllegalArgumentException("File / Dictionary doesn't exists: " + path);
		}
		final Directory parent = (Directory)entries.get(entries.size() - 2);
		final String fileName = path.substring(path.lastIndexOf("/") + 1);
		Entry target = null;
		for (Entry entry : parent.getContents()) {
			if (entry.name.equals(fileName)) {
				target = entry;
				break;
			} 
		}
		if (target != null) {
			parent.deleteEntry(target);
		}		
	}
	
	public List<Entry> list(String path) {
		List<Entry> entries = resolve(path);
		if (entries.get(entries.size() - 1) == null) {
			throw new IllegalArgumentException("Dictionary doesn't exists: " + path);
		}
		if (entries.get(entries.size() - 1) instanceof File) {
			return null;
		}		
		return ((Directory)entries.get(entries.size() - 1)).getContents();	
	}

	public int count() {
		if (root == null) {
			return 0;
		}
		int[] count = new int[1];
		count(root, count);
		return count[0];
	}
	private void count(Directory root, int[] count) {
		//base case
		if (root == null) {
			return;
		}
		for (Entry entry : root.getContents()) {
			if (entry instanceof File) {
				count[0]++;
			} else {
				count[0]++;
				count((Directory)entry, count);
			}
		}			
		
	}
}
