package fr.lernejo.guessgame;

import fr.lernejo.logger.*;

import java.text.SimpleDateFormat;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;
    private long numberToGuess;

    public Simulation(Player player) {
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        long numberPlayer = player.askNextGuess();
        if (numberPlayer == numberToGuess) {
            return true;
        } else if (numberPlayer > numberToGuess) {
            player.respond(true);
        } else {
            player.respond(false);
        }
        return false;
    }

    public void loopUntilPlayerSucceed(Long maxRound) {
        Long round = 0L;
        boolean guessed = false;
        long start = System.currentTimeMillis();
        while (round != maxRound && !guessed) {
            guessed = nextRound();
            round += 1;
        }
        long end = System.currentTimeMillis();
        SimpleDateFormat dateFormat = new SimpleDateFormat("mm:ss.SSS");
        String timeToGuess = dateFormat.format(end - start);
        if (guessed)
            logger.log("Well played, you won ! You guess the age of the capitaine. He is " + numberToGuess + " years old. (" + timeToGuess + ")");
        else
            logger.log("Shame you lost ! (" + timeToGuess + ")");
    }
}
