package sbg.informatikag;

import sbg.informatikag.bots.AlwaysCooperatesBot;
import sbg.informatikag.bots.AlwaysDefectsBot;
import sbg.informatikag.bots.RandomBot;
import sbg.informatikag.bots.TitForTatBot;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        DilemmaGameManager gameManager = new DilemmaGameManager();
        gameManager.botRegistration.registerBot(new AlwaysCooperatesBot());
        gameManager.botRegistration.registerBot(new RandomBot());
        gameManager.botRegistration.registerBot(new TitForTatBot());

        gameManager.playGame(true, 1);

        MatchData lastData = null;
        int currentBotScore = 0;
        for (MatchData data : gameManager.matchDatas) {
            if (!(lastData == null)) {
                if (!data.bot1.equals(lastData.bot1)) {
                    System.out.printf("Result: %s has score of %s against %s \n", lastData.bot1.getName(), currentBotScore,
                            lastData.bot2.getName());
                    System.out.println();
                    currentBotScore = 0;
                } else if (!data.bot2.equals(lastData.bot2)) {
                    System.out.printf("Result: %s has score of %s against %s \n", lastData.bot1.getName(), currentBotScore,
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

            System.out.printf("Match: %s : %s, %s : %s \n", data.bot1.getName(), data.moveBot1, data.bot2.getName(), data.moveBot2);
            lastData = data;
        }
        System.out.printf("Result: %s has score of %s against %s \n", lastData.bot1.getName(), currentBotScore,
                lastData.bot2.getName());
        currentBotScore = 0;
        /* Register all bots here */
    }
}
