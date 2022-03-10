package fr.lernejo.logger;

import java.util.function.Predicate;

public class LoggerFactory {
    public static Logger getLogger(String name) {
        Predicate<String> condition = log -> log.contains("simulation");
        return new CompositeLogger(new ContextualLogger(name, new ConsoleLogger()),
                new ContextualLogger(
                    name,
                    new FilteredLogger(
                        new FileLogger(System.getProperty("user.home") + "/Desktop/test.txt"),
                        condition
                        )
                )
        );
    }
}
