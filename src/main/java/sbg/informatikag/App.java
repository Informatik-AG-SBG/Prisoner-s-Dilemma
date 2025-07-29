package sbg.informatikag;

import sbg.informatikag.bots.AlwaysCooperates;
import sbg.informatikag.bots.AlwaysDefects;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        DilemmaGameManager gameManager = new DilemmaGameManager();
        gameManager.botRegistration.registerBot(new AlwaysCooperates());
        gameManager.botRegistration.registerBot(new AlwaysDefects());

        gameManager.playGame(true, 100);

        System.out.println("Played all matches");

        /*Register all bots here*/
    }
}
