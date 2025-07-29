package sbg.informatikag;

import java.util.ArrayList;

public class DilemmaGameManager {

    public ArrayList<MatchData> matchDatas = new ArrayList<MatchData>();

    public BotRegistration botRegistration = new BotRegistration();

    MatchData playMatch(MatchData matchDataLastRound, Bot bot1, Bot bot2) {
        return new MatchData(
                bot1.move(matchDataLastRound.moveBot1, matchDataLastRound.moveBot2),
                bot2.move(matchDataLastRound.moveBot2, matchDataLastRound.moveBot1),
                bot1,
                bot2);
    }

    /**
     * @param skipSameBotMatches
     *
     *                           Do not call from within a bot
     */
    public void playGame(boolean skipSameBotMatches, int matchRepetitions) {
        matchDatas.clear();
        int matchIndex = 0;
        for (Bot bot1 : this.botRegistration.bots) {
            for (int i = 0; i < matchRepetitions; i++) {
                for (Bot bot2 : this.botRegistration.bots) {
                    if (bot1.equals(bot2) && skipSameBotMatches) {
                        continue; // Skip match if bot plays against itself and skipSameBotMatches is enabled.
                    }
                    if (matchDatas.isEmpty()) {
                        this.matchDatas.add(this.playMatch(new MatchData(Move.NoMoveBecauseOfFirstMatch,
                                Move.NoMoveBecauseOfFirstMatch, bot1, bot2), bot1, bot2));
                    } else {
                        this.matchDatas.add(this.playMatch(this.matchDatas.get(matchIndex - 1), bot1, bot2));
                    }
                    matchIndex++;
                }
            }
        }
    }

}
