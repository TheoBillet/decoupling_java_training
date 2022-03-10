package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {
    public static boolean isLong(String str) {
        try {
            Long.parseLong(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static void main(String[] args) {
        if (args.length >= 1 && "-interactive".equals(args[0])) {
            HumanPlayer humanPlayer = new HumanPlayer();
            SecureRandom random = new SecureRandom();
            long randomNumber = random.nextInt(100);

            Simulation simulation = new Simulation(humanPlayer);
            simulation.initialize(randomNumber);
            simulation.loopUntilPlayerSucceed(Long.MAX_VALUE);
        } else if (args.length == 2 && "-auto".equals(args[0]) && isLong(args[1])) {
            ComputerPlayer computerPlayer = new ComputerPlayer();

            Simulation simulation = new Simulation(computerPlayer);
            simulation.initialize(Long.parseLong(args[1]));
            simulation.loopUntilPlayerSucceed(1000L);
        } else {
            System.out.println("Usage : arguments \"-interactive\" or \"-auto [number]\"");
        }
    }
}
