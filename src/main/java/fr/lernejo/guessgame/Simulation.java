package fr.lernejo.guessgame;

import fr.lernejo.logger.*;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;  //TODO add variable type
    private long numberToGuess; //TODO add variable type

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

    public void loopUntilPlayerSucceed() {
        while (!nextRound()) {}
        System.out.println("Well played ! You guess the age of the capitaine. He is " + numberToGuess + " years old.");
    }
}
