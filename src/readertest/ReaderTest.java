package readertest;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ReaderTest {
	
/*	
	void ReaderTest(String) {
		System.out.println(text);
		
	}
	
	*/

	public static void main (String[] args) throws Exception {
		
		
	//ReaderTest myObject = new ReaderTest();  
		
	/*System.out.println("Write your filename here.");
	Scanner input = new Scanner(System.in);
	String filename = input.nextLine();
	System.out.println("Your filename is" + filename);
	File myFile = new File (filename);
	 if (!myFile.exists()) {
         System.out.println("Not Found");
         Thread.sleep(2000);
     }
	    
	System.out.println("Would you like to copy the first file data to another file?");
	System.out.println("Yes: Please write another output.");
	System.out.println("No. Just press the enter.");
	Scanner input2 =new Scanner(System.in);
	String filename2 = input2.nextLine();
	System.out.println("Your filename is "+ filename2);
	//String filename = "C:/Hegga/sample.txt";
	//String filename2 = "";
	/*ReaderMethod(filename, filename2);
	
	ReaderMethod("C:/Hegga/sample.txt", "");
	ReaderMethod("", "");
	ReaderMethod("C:/Hegga/sample1.txt", "C:/Hegga/342342.txt");
	ReaderMethod("C:/Hegga/tara1.txt", ""); */
	}

public void ReaderMethod(String filename, String filename2) {
	
	if(filename2.length()==0) {
			File myFile = new File (filename);
			Scanner myReader;
			try {
					myReader = new Scanner (myFile);
	
					while (myReader.hasNextLine()) {
						String text = myReader.nextLine();
						System.out.println(text);
					}
					myReader.close();
				} catch (FileNotFoundException e) {
		
					System.out.println("File not found.");
				}

	}else {
		File myFile = new File (filename);
		Scanner myReader;		
		try {
			myReader = new Scanner (myFile);
			while(myReader.hasNextLine()) {
				String text = myReader.nextLine();									
				try { 
				      FileWriter myWriter = new FileWriter(filename2);
				      myWriter.write(text);
				      myWriter.close();
				      System.out.println("Success.");
				    } catch (IOException e) {
				      System.out.println("IO-Error");
				      e.printStackTrace();
				    }				
			}
		
		}catch (FileNotFoundException e) {
			System.out.println("File not found."); 
		}				 
	}
}
}
