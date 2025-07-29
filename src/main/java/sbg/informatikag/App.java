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

        gameManager.playGame(true, 5);

        MatchData lastData = null;
        int currentBotScore = 0;
        for (MatchData data : gameManager.matchDatas) {
            if (!(lastData == null)) {
                if (!data.bot1.equals(lastData.bot1)) {
                    System.out.printf("%s has score of %s against %s \n", lastData.bot1.getName(), currentBotScore,
                            lastData.bot2.getName());
                    currentBotScore = 0;
                } else if (!data.bot2.equals(lastData.bot2)) {
                    System.out.printf("%s has score of %s against %s \n", lastData.bot1.getName(), currentBotScore,
                            lastData.bot2.getName());
                    currentBotScore = 0;
                }
            }

            switch (data.moveBot1) {
                case Cooperation:
                    switch (data.moveBot2) {
                        case Cooperation: // CC
                            currentBotScore += 3;
                            break;
                        case Defection: // CD
                            currentBotScore += 1;
                            break;
                    }
                    break;
                case Defection:
                    switch (data.moveBot2) {
                        case Cooperation: // DC
                            currentBotScore += 4;
                            break;
                        case Defection: // DD
                            currentBotScore += 2;
                            break;
                    }
                    break;
            }

            lastData = data;
        }
        System.out.printf("%s has score of %s against %s \n", lastData.bot1.getName(), currentBotScore,
                lastData.bot2.getName());
        currentBotScore = 0;
        /* Register all bots here */
    }
}
