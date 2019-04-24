package main.java.com.thotsoft.heger.cliwrite;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

public class Cliwrite {

    public static void main(String[] args) throws IOException {
        CommandLineOptions values = new CommandLineOptions();
        CmdLineParser parser = new CmdLineParser(values);

        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            System.err.println("Invalid Argument");
            parser.printUsage(System.err);
            return;
        }
        if (values.getOutput() == null) {
            read(values.getSource(), "");
        } else {
            read(values.getSource(), values.getOutput());
        }

    }

    public static void read(String source, String output) throws IOException {

        if (output.length() == 0) {
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
                    myWriter = new FileWriter(output);
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
