package com.thotsoft.heger.readwriter;


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
		
		
	read(args[0],args[1]);
	
		

	}
public static void read(String filename, String filename2) {
	
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
				} //ArrayIndexOutOfBound exception

	}else {
		File myFile = new File (filename);
		Scanner myReader;		
		try {
			myReader = new Scanner (myFile);
			while(myReader.hasNextLine()) {
				String text = myReader.nextLine();									
				try  { 
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
