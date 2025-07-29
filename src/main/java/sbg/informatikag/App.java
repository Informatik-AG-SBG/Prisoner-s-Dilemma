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

        MatchData lastData = null;
        int currentBotScore = 0;
        for (MatchData data : gameManager.matchDatas) {
            if (!(lastData == null)) {
                if (!data.bot1.equals(lastData.bot1)) {
                    System.out.printf("%s has score of %s \n", lastData.bot1.getName(), currentBotScore);
                    currentBotScore = 0;
                }
            }

            switch (data.moveBot1) {
                case Cooperation:
                    switch (data.moveBot2) {
                        case Cooperation:   //CC
                            currentBotScore += 3;
                            break;
                        case Defection:     //CD
                            currentBotScore += 1;
                            break;
                    }
                    break;
                case Defection:
                    switch (data.moveBot2) {
                        case Cooperation:   //DC
                            currentBotScore += 4;
                            break;
                        case Defection:     //DD
                            currentBotScore += 2;
                            break;
                    }
                    break;
            }


            lastData = data;
        }
        System.out.printf("%s has score of %s \n", lastData.bot1.getName(), currentBotScore);
        System.out.println("Played all matches");

        /*Register all bots here*/
    }
}
