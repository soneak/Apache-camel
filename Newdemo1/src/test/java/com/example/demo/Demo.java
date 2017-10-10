package com.example.demo;

import static org.junit.Assert.*;

import java.io.File;
import org.apache.cxf.helpers.FileUtils;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class Demo {

	@Rule
	public TemporaryFolder folder = new TemporaryFolder();

	@Test
	public void testXYZ() throws Exception {
	    final File expected = new File(".txt");
	    final File output = folder.newFile(".txt");
	    final File expected1 = new File(".xml");
	    final File output1 = folder.newFile(".xml");
	    File file = new File("D:/Extension");
		assertTrue(file.exists());
	    //TestClass.xyz(output);
	   Assert.assertEquals(FileUtils.readLines(expected), FileUtils.readLines(output));
	    
	   		
		
	}
}

