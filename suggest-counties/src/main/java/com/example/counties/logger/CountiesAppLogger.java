package com.example.counties.logger;

import lombok.extern.slf4j.Slf4j;

/**
 * It's a wrapper class for the Lombok Slf4j logger.
 * 
 * @author Manoj SP
 * @since 1.0
 */
@Slf4j
public final class CountiesAppLogger {

    /**
     * This function takes a string as an argument and logs it to the console
     * 
     * @param msg The message you want to log.
     */
    public static void info(String msg) {
        log.info(msg);
    }

    /**
     * It logs a message to the console if the log level is set to debug
     * 
     * @param msg The message to be logged.
     */
    public static void debug(String msg) {
        log.debug(msg);
    }

    /**
     * It logs an error message
     * 
     * @param msg The message to be logged.
     */
    public static void error(String msg) {
        log.error(msg);
    }
}
