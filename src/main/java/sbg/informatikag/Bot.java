package sbg.informatikag;

public interface Bot {
    /**
     * @return Returns the Bots Name
     * Needs to return the bot's name*/
    public String getName();
    /**
     * @param myOwnMoveLastRound your own move from last round
     * @param othersMoveLastRound the other prisoners move from last round
     * @return Returns the Move the Bot has decided to use
     *
     * Needs to return the move for this round.
     * You receive your last move and the other bot's last move*/
    public Move move(Move myOwnMoveLastRound, Move othersMoveLastRound);
}
