package fr.lernejo.logger;

import java.util.ArrayList;
import java.util.List;

public class CompositeLogger implements  Logger {
    List<Logger> loggers;

    public CompositeLogger(Logger loggerA, Logger loggerB) {
        loggers = new ArrayList<Logger>();
        loggers.add(loggerA);
        loggers.add(loggerB);
    }

    @Override
    public void log(String message) {
        loggers.forEach(logger -> logger.log(message));
    }
}
