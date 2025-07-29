package sbg.informatikag.bots;

import sbg.informatikag.Bot;
import sbg.informatikag.Move;

public class AlwaysCooperates implements Bot {

    @Override
    public String getName() {
        return "Samuel's Always Cooperates Example Bot";
    }

    @Override
    public Move move(Move myOwnMoveLastRound, Move othersMoveLastRound) {
        return Move.Cooperation;
    }

}
