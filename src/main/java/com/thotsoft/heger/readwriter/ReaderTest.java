package com.thotsoft.heger.readwriter;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ReaderTest {

    public static void main (String[] args) throws Exception {
//args
        try {
            if (args[0].length() == 0) {
            System.out.println("Not a parameter.");
            } else {
                if (!args[0].contains("--source")) {
                    System.out.println("Wrong Command!");
                } else {
                    if (!args[1].contains(".txt")) {
                        System.out.println("Wrong extension!");
                    } else {
                        if (args[2]!= "--target"){
                            read(args[1],"");
                            Thread.sleep(3000);
                            System.out.println("Wrong/Missing target Command!");
                            Thread.sleep(3000);
                            System.out.println("Do you want to copy? Yes/No");
                            Scanner sc = new Scanner(System.in);
                            String choice = sc.nextLine();
                                if (choice.contains("Yes") || choice.contains("yes")) {
                                    System.out.println("Type your file location");
                                    String target = sc.nextLine();
                                    
                                    sc.close();
                                } else {
                                    System.out.println("Thanks");
                                    read(args[1], "");
                                }
                            read(args[1], args[3]);
                        } else {
                            if (!args[3].contains(".txt")) {
                                System.out.println("Wrong extension!");
                                Thread.sleep(3000);
                                System.out.println("You can write it manually, if you want..");
                                Scanner fileinput = new Scanner(System.in);
                                String addtargetpath = fileinput.nextLine();
                                
                                fileinput.close();
                                read(args[1], addtargetpath);
                            } else {
                                read(args[1], args[3]);
                            }
                        }
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("You didn't type a parameter.");
        } 
}

    public static void read(String source, String target) throws IOException {

        if (target.length() == 0) {
            File myFile = new File (source);
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
        } else {
            File myFile= new File (source);
            Scanner myReader;
            try {
                myReader = new Scanner (myFile);
                FileWriter myWriter = new FileWriter(target);
                while (myReader.hasNextLine()) {
                    String text = myReader.nextLine();
                    
                    myWriter.write(text);
                    myWriter.write(System.getProperty("line.separator"));
                    myWriter.flush();
                } System.out.println("Success.");
                  myWriter.close();  
            } catch (FileNotFoundException e) {
                System.out.println("File not found."); 
            }
        } 
    }
}