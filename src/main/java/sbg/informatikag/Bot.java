package sbg.informatikag;

public interface Bot {
    /*
     * Needs to return the bot's name*/
    public String getName();
    /*
     * Needs to return the move for this round.
     * You receive your last move and the other bot's last move*/
    public Move move(Move myOwnMoveLastRound, Move othersMoveLastRound);
}
