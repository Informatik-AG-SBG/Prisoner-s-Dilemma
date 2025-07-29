package sbg.informatikag.bots;

import sbg.informatikag.Bot;
import sbg.informatikag.Move;

public class AlwaysDefectsBot implements Bot {

    @Override
    public String getName() {
        return "Samuel's Always Defects Example Bot";
    }

    @Override
    public Move move(Move myOwnMoveLastRound, Move othersMoveLastRound) {
        return Move.Defection;
    }

}
