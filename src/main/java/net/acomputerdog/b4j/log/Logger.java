package net.acomputerdog.b4j.log;

import java.io.PrintWriter;
import java.io.StringWriter;

public class Logger {
    public static void log(LogLevel level, Object source, Object message) {
        String messageStr = messageToString(message);

        if (level == LogLevel.RAW) {
            System.out.println(messageStr);
        } else {
            System.out.printf("[%s] [%s] %s\n", level.getLabel(), String.valueOf(source), messageStr);
        }
    }

    public static void logTrace(Object source, Object message) {
        log(LogLevel.TRACE, source, message);
    }

    public static void logDebug(Object source, Object message) {
        log(LogLevel.DEBUG, source, message);
    }

    public static void logInfo(Object source, Object message) {
        log(LogLevel.INFO, source, message);
    }

    public static void logWarn(Object source, Object message) {
        log(LogLevel.WARN, source, message);
    }

    public static void logError(Object source, Object message) {
        log(LogLevel.ERROR, source, message);
    }

    public static void logFatal(Object source, Object message) {
        log(LogLevel.FATAL, source, message);
    }

    private static String messageToString(Object o) {
        if (o instanceof Throwable) {
            return exToString((Throwable)o);
        }
        return String.valueOf(o);
    }

    private static String exToString(Throwable t) {
        // this should not be necessary

        StringWriter sw = new StringWriter();
        t.printStackTrace(new PrintWriter(sw));
        return sw.toString();
    }
}
