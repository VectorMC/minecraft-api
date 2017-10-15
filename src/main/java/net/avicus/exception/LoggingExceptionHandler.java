package net.avicus.exception;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingExceptionHandler implements ExceptionHandler {

    private final Logger logger;

    public LoggingExceptionHandler(Logger logger) {
        this.logger = checkNotNull(logger);
    }

    @Override
    public void handleException(Throwable exception, String message) {
        logger.log(Level.SEVERE, message, exception);
    }

    public static LoggingExceptionHandler forGlobalLogger() {
        if(GLOBAL == null) {
            GLOBAL = new LoggingExceptionHandler(Logger.getGlobal());
        }
        return GLOBAL;
    }

    private static LoggingExceptionHandler GLOBAL;
}
