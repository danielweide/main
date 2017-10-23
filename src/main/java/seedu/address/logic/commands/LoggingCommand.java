package seedu.address.logic.commands;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
/**
 * Method to Keep Track of User Activity Log
 */
public class LoggingCommand {
    /**
     *
     */
    public void keepLog(String logtext) {

        try (FileWriter fileWrite = new FileWriter("src/test/data/XMLUtilTest/ConnectUsLog.txt", true);
            BufferedWriter buffWriter = new BufferedWriter(fileWrite);
            PrintWriter out = new PrintWriter(buffWriter)) {
            out.println(logtext + "\t" + LocalDateTime.now());
        } catch (IOException e) {
            System.out.println("Error With ConnectUs.txt Logging");
        }
    }
}

