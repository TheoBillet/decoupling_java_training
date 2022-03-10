package fr.lernejo.guessgame;

import fr.lernejo.logger.*;

import java.util.Scanner;

public class ComputerPlayer implements Player {
    private final Logger logger = LoggerFactory.getLogger("player");
    private Long guess;
    private Long max = Long.MAX_VALUE;
    private Long min = Long.MIN_VALUE;

    @Override
    public long askNextGuess() {
        this.guess = (this.max + this.min) / 2;
        return this.guess;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater) {
            this.max = this.guess;
        } else {
            this.min = this.guess;
        }
    }
}
