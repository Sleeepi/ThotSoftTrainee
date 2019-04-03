package readertest;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

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
		tester.ReaderMethod("C:/Hegga/sample.txt", "");
		tester.ReaderMethod("", "");
		tester.ReaderMethod("C:/Hegga/sample1.txt", "C:/Hegga/342342.txt");
		tester.ReaderMethod("C:/Hegga/tara1.txt", "");
		tester.ReaderMethod("C:/asdas","");
		
    }
	
	public void testReaderMethodWithEmptyString() {
	    String name = "";
	    
	    tester.ReaderMethod(name, name);
	    
	}
	
	public void testReaderMethodWithNotText() {
		String szam = "34234234234";
		tester.ReaderMethod(szam, szam);
		tester.ReaderMethod("653535", "3253234");
	}
}

