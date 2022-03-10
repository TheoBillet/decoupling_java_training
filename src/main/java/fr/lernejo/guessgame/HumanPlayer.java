package fr.lernejo.guessgame;

import fr.lernejo.logger.*;
import java.util.Scanner;

public class HumanPlayer implements  Player{
    private final Logger logger = LoggerFactory.getLogger("player");

    @Override
    public long askNextGuess() {
        System.out.println("What is your next guess ?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLong();
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater) {
            System.out.println("Your guess is too high !");
        } else {
            System.out.println("Your guess is too low !");
        }
    }
}
