package sbg.informatikag.bots;

import java.util.Random;

import sbg.informatikag.Bot;
import sbg.informatikag.Move;

public class RandomBot implements Bot {

    Random random = new Random(System.currentTimeMillis());


    @Override
    public String getName() {
        return "Samuel's Random Example Bot";
    }

    @Override
    public Move move(Move myOwnMoveLastRound, Move othersMoveLastRound) {

        if (random.nextBoolean()) {
            return Move.Defection;
        } else {
            return Move.Cooperation;
        }
    }

}
