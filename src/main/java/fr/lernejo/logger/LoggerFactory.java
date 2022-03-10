package fr.lernejo.logger;

public class LoggerFactory {
    public static Logger getLogger(String name) {
        return new ContextualLogger(name, new FileLogger(System.getProperty("user.home") + "/Desktop/test.txt"));
    }
}
