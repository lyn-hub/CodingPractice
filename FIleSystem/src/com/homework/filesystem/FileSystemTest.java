package com.homework.filesystem;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;


import org.junit.jupiter.api.Test;

public class FileSystemTest {	

    FileSystem f1 = new FileSystem() ;	

	@Test
	public void testMkdir() {
		f1.mkdir("/dir1");
		assertEquals(1, f1.count());	
	}

	@Test
	public void testCreateFile() {
		f1.mkdir("/dir1");		
		f1.createFile("/dir1/file2");
		assertEquals(2, f1.count());
	}

	@Test
	public void testDelete() {
		f1.mkdir("/dir1");		
		f1.createFile("/dir1/file2");
		f1.delete("/dir1/file2");
		assertEquals(1, f1.count());
	}

	@Test
	public void testList() {
		f1.mkdir("/dir1");		
		f1.createFile("/dir1/file2");		
		List<Entry> list1 = f1.list("/dir1");
		assertEquals(1, list1.size());
	}

	@Test
	public void testCount() {
		f1.mkdir("/dir1");		
		f1.createFile("/dir1/file2");
		assertEquals(2, f1.count());
	}

}
