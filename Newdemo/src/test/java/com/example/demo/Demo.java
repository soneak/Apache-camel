package com.example.demo;

import static org.junit.Assert.assertTrue;

import java.io.File;
import org.junit.Rule;
import org.junit.Test;

import org.junit.rules.TemporaryFolder;

public class Demo {
	
	@Rule
	public TemporaryFolder folder = new TemporaryFolder();

	@Test
	public void testtask() throws Exception {
	   
	    //final File output = folder.newFile("task.txt");
	    
	    File file = new File("c://outputFolder");
	    final File expected = new File("task.txt");
		assertTrue(file.exists());
	  
	}

}
