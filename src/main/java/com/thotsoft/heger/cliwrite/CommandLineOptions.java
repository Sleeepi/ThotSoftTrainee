package main.java.com.thotsoft.heger.cliwrite;

import java.util.ArrayList;
import java.util.List;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.Option;

public class CommandLineOptions {

    @Option(name = "-s", aliases = { "--source" }, required = true,
        usage = "Input File", metaVar = "<some/directory/file.txt>")
    private String source;

    @Option(name = "-o", aliases = { "--output" },
        usage = "Output File", metaVar = "<some/directory/file.txt>")
    private String output;

    @Option(name = "-h", aliases = { "--help" },
        usage = "helper")

    @Argument
    private List<String> arguments = new ArrayList<String>();

    private boolean errorFree = false;

    public boolean isErrorFree() {
        return errorFree;
    }

    public String getSource() {
        return source;
    }

    public String getOutput() {
        return output;
    }
}
