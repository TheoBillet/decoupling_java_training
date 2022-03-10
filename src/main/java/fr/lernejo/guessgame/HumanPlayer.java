package fr.lernejo.guessgame;

import fr.lernejo.logger.*;
import java.util.Scanner;

public class HumanPlayer implements Player {
    private final Logger logger = LoggerFactory.getLogger("player");

    @Override
    public long askNextGuess() {
        logger.log("What is your next guess ?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLong();
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater) {
            logger.log("Your guess is too greater !");
        } else {
            logger.log("Your guess is too lower !");
        }
    }
}
