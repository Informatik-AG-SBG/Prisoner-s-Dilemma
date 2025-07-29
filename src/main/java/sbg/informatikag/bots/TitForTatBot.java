package sbg.informatikag.bots;

import sbg.informatikag.Bot;
import sbg.informatikag.Move;

public class TitForTatBot implements Bot {
    @Override
    public String getName() {
        return "Samuel's Tit for Tat Bot";
    }

    @Override
    public Move move(Move myOwnMoveLastRound, Move othersMoveLastRound) {
        switch (othersMoveLastRound) {
            case Cooperation -> {
                return Move.Cooperation;
            }
            case Defection -> {
                return Move.Defection;
            }
            default -> {
                return Move.Cooperation;
            }
        }
    }
}
