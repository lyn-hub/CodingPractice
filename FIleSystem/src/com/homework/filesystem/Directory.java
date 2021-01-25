package com.homework.filesystem;

import java.util.*;

public class Directory extends Entry {
	private List<Entry> contents;
	
	public Directory (String n, Directory p) {
		super(n, p);
		contents = new ArrayList<Entry>();
	}
	
	protected List<Entry> getContents() {
		return contents;
	}
	
	public int size() {
		int size = 0;
		for (Entry e : contents) {
			size += e.size();
		}
		return size;
	}
	
	public int numberOfFiles() {
		int count = 0;
		for (Entry e : contents) {
			if (e instanceof Directory) {
				count++;
				Directory d = (Directory) e;
				count+= d.numberOfFiles();
			} else if (e instanceof File) {
				count++;
			}
		}
		return count;
	}
	
	public boolean deleteEntry(Entry entry) {
		return contents.remove(entry);
	}
	
	public void addEntry (Entry entry) {
		contents.add(entry);
	}

	public Entry getChild(String component) {
		// TODO Auto-generated method stub
		for (Entry entry : contents) {
			if (entry.name.equals(component)) {
				return entry;
			}
		}
		return null;
	}
}
