package org.utilites;

import java.util.ArrayList;
import java.util.List;

public class CustomLogger {

    private static List<String> logMessages = new ArrayList<String>();

    public static void log(String message) {
        logMessages.add(message);
    }

    public static List<String> getLogMessages() {
        return logMessages;
    }
}
