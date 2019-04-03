package com.thotsoft.heger.readwriterTest;

import org.junit.jupiter.api.Test;

import com.thotsoft.heger.readwriter.ReaderTest;

import junit.framework.TestCase;
import junit.runner.Version;


class ReadTester extends TestCase {
	
	
/*	@Before
	public void setUp() {
		ReaderTest tester = new ReaderTest();
	} */
	ReaderTest tester = new ReaderTest();
	
	@Test
	public void testReaderMethod() {
	   /*
		String name = "";
		assertNull("Result", tester.ReaderMethod(name,"" )); */
		ReaderTest.read("C:/Hegga/sample.txt", "");
		ReaderTest.read("", "");
		ReaderTest.read("C:/Hegga/sample1.txt", "C:/Hegga/342342.txt");
		ReaderTest.read("C:/Hegga/tara1.txt", "");
		ReaderTest.read("C:/asdas","");
		System.out.println("JUnit version is: " + Version.id());
		
    }
	@Test
	public void testReaderMethodWithEmptyString() {
	    String name = "";
	    
	    ReaderTest.read(name, name);
	    
	}
	@Test
	public void testReaderMethodWithNotText() {
		String szam = "34234234234";
		ReaderTest.read(szam, szam);
		ReaderTest.read("653535", "3253234");
	}
}

