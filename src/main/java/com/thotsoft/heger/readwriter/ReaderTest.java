package com.thotsoft.heger.readwriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ReaderTest {

    public static void main(String[] args) throws Exception {

        String targetpath = "";

        if (args.length < 4) {
            throw new IllegalArgumentException("Exactly 4 parameters required !");
        }
        if (!args[0].contains("--source") && args[0].equalsIgnoreCase("--source")) {
            // source command
            System.out.println("Wrong Command!");
        } else if (!args[1].contains(".txt")) {
            System.out.println("Wrong extension!");
        } else if (args[2] != "--target") {
            read(args[1], "");
            Thread.sleep(3000);
            System.out.println("Wrong/Missing target Command!");
            Thread.sleep(3000);
            System.out.println("Do you want to copy? Yes/No");
            Scanner sc = new Scanner(System.in);
            String choice = sc.nextLine();
            try {
                if (choice.equalsIgnoreCase("yes")) {
                    System.out.println("Type your file location");
                    String target = sc.nextLine();
                    targetpath = target;
                } else {
                    System.out.println("Thanks");
                    read(args[1], "");
                }
            } finally {
                sc.close();
            }
            read(args[1], targetpath);
        } else if (!args[3].contains(".txt")) {
            // target--wrong extension
            System.out.println("Wrong extension!");
            Thread.sleep(3000);
            System.out.println("You can write it manually, if you want..");
            Scanner fileinput = new Scanner(System.in);
            try {
                String addtargetpath = fileinput.nextLine();
                read(args[1], addtargetpath);
            } finally {
                fileinput.close();
            }
        } else {
            read(args[1], args[3]);
        }
    }

    public static void read(String source, String target) throws IOException {

        if (target.length() == 0) {
            File myFile = new File(source);
            if (myFile.isFile()) {
                Scanner myReader = null;
                try {
                    myReader = new Scanner(myFile);
                    while (myReader.hasNextLine()) {
                        String text = myReader.nextLine();
                        System.out.println(text);
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("File not found.");
                } finally {
                    myReader.close();
                }
            } else
                System.out.println("Not a file");

        } else {
            File myFile = new File(source);
            if (myFile.isFile()) {
                Scanner myReader = null;
                FileWriter myWriter = null;
                try {
                    myReader = new Scanner(myFile);
                    myWriter = new FileWriter(target);
                    while (myReader.hasNextLine()) {
                        String text = myReader.nextLine();
                        myWriter.write(text);
                        myWriter.write(System.getProperty("line.separator"));
                        myWriter.flush();
                    }
                    System.out.println("Success.");
                    myWriter.close();
                } catch (FileNotFoundException e) {
                    System.out.println("File not found.");
                } finally {
                    myReader.close();
                    myWriter.close();
                }
            } else
                System.out.println("Not a file");
        }
    }
}
