package com.tello.logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Logger class for managing all warnings, errors, and information
 */
public class Logger {
    /**
     * Default Logger instance
     */
    public static final Logger INSTANCE = new Logger(true);

    private static final String WARNING_PREFIX = "[Warning] ";
    private static final String ERROR_PREFIX = "[Error] ";
    private static final String INFORMATION_PREFIX = "[Info] ";
    private static final String DEBUG_PREFIX = "[Debug] ";

    private final boolean debug; // Should debug messages be printed
    private ArrayList<String> messages;

    /**
     * @param debug When set to TRUE debug messages are printed to the console
     */
    public Logger(boolean debug) {
        this.messages = new ArrayList<>();
        this.debug = debug;
    }

    public Logger() {
        this(false);
    }

    /**
     * Prints out an optional debug message IF debug mode is enabled
     * @param message Provides more information
     * @return the printed message
     */
    public String debug(String message) {
        if(!this.debug) return null;
        var output = DEBUG_PREFIX + message;
        output = output.replace("\n", "\n" + Logger.repeat(ERROR_PREFIX.length(), " "));
        System.out.println(output);
        return output;
    }
    /**
     * Prints out an error message
     * @param message Provides more information
     * @return the printed message
     */
    public String error(String message) {
        var output = ERROR_PREFIX + message;
        output = output.replace("\n", "\n" + Logger.repeat(ERROR_PREFIX.length(), " "));
        System.err.println(output);
        this.messages.add(LocalDateTime.now().toString() + " : " + output);
        return output;
    }

    /**
     * Prints out an error message and provides more information on the stacktrace
     * @param message Provides more information
     * @param exception Caught exception
     * @return the printed message
     */
    public String error(String message, Exception exception) {
        var output = ERROR_PREFIX + message + "\nMore infos on the printed stacktrace: " + exception.getMessage();
        output = output.replace("\n", "\n" + Logger.repeat(ERROR_PREFIX.length(), " "));
        System.err.println(output);
        this.messages.add(LocalDateTime.now().toString() + " : " + output);
        return output;
    }

    /**
     * Prints out an information message
     * @param message Provides more information
     * @return the printed message
     */
    public String information(String message) {
        var output = INFORMATION_PREFIX + message;
        output = output.replace("\n", "\n" + Logger.repeat(INFORMATION_PREFIX.length(), " "));
        System.out.println(output);
        this.messages.add(LocalDateTime.now().toString() + " : " + output);
        return output;
    }

    /**
     * Prints out a warning message
     * @param message Provides more information
     * @return the printed message
     */
    public String warning(String message) {
        var output = WARNING_PREFIX + message;
        System.out.println(output);
        this.messages.add(LocalDateTime.now().toString() + " : " + output);
        return output;
    }

    /**
     * Saves all messages from the current session to file
     * @param log File to save the information to
     * @return Was the save successful
     */
    public boolean save(File log) {
        try {
            FileWriter logWriter = new FileWriter(log);
            for(String message : messages) {
                logWriter.append(message);
            }
            return true;
        } catch (IOException e) {
            this.error("There was an error while saving the log to file! [" + e.getMessage() + "]");
            return false;
        }
    }

    /**
     * Getter for messages
     * @return all temporary stored messages
     */
    public ArrayList<String> getMessages() {
        return messages;
    }

    public static String repeat(int count, String with) {
        return new String(new char[count]).replace("\0", with);
    }
}
