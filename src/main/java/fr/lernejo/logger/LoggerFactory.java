package fr.lernejo.logger;

public class LoggerFactory {
    public static Logger getLogger(String name) {
        return new CompositeLogger(new ContextualLogger(name, new ConsoleLogger()), new FileLogger(System.getProperty("user.home") + "/Desktop/test.txt"));
    }
}
