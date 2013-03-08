package com.open.perf.main;

import com.open.perf.domain.Loader;
import org.apache.commons.cli.*;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

public class Main {

    private static Logger logger;
    private static Options options;

    static {
        logger = Logger.getLogger(Main.class);
        options = new Options();

        Option fileOption = new Option("f", "jobFile", true, "File containing Json representing the performance run");
        fileOption.setRequired(true);
        options.addOption(fileOption);

        options.addOption(new Option("j", "jobId", true, "Unique Job Id. By default it would be Random UUID"));
        options.addOption(new Option("s", "statsFolder", true, "Path where stats will be stored. Default is /var/log/loader/"));
    }

    /**
     * -f jobJsonFile -j jobId -l statsFolder
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        CommandLineParser parser = new GnuParser();

        try {
            CommandLine line = parser.parse(options, args);
            if(line.hasOption('h')) {
                help();
                return;
            }

            System.setProperty("BASE_PATH", statsFolder(line));
            buildLoader(jobJsonFile(line)).
                    setJobId(jobId(line)).
                    start();
        }
        catch (Exception e) {
            logger.error(e);
            help();
        }
    }

    private static Loader buildLoader(String jobJsonFile) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new FileInputStream(jobJsonFile), Loader.class);
    }

    private static String jobId(CommandLine line) {
        return line.getOptionValue('j', UUID.randomUUID().toString());
    }

    private static String statsFolder(CommandLine line) {
        return line.getOptionValue('s',"/var/log/loader/");
    }

    private static String jobJsonFile(CommandLine line) {
        if(!line.hasOption('f')) {
            help();
            System.exit(1);
        }
        return line.getOptionValue('f');
    }

    private static void help() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("Main", options );
    }
}