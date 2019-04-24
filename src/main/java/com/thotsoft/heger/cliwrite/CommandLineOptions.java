package main.java.com.thotsoft.heger.cliwrite;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

public class CommandLineOptions {

    @Option(name = "-s", aliases = { "--source" }, required = true,
        usage = "Input File", metaVar = "<some/directory/file.txt>")
    private String source;

    @Option(name = "-o", aliases = { "--output" },
        usage = "Output File", metaVar = "<some/directory/file.txt>")
    private String output;
    
    @Option(name = "-h", aliases = { "--help" },
            usage = "Output File", metaVar = "<some/directory/file.txt>")

    private boolean errorFree = false;

    public void CommandLineValues(String... args) {
        CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);

            errorFree = true;
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            parser.printUsage(System.err);
        }
    }

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
