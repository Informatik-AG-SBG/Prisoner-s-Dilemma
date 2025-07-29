package sbg.informatikag;

public class MatchData {
    public Move moveBot1;
    public Move moveBot2;
    public Bot bot1;
    public Bot bot2;

    public MatchData(Move moveBot1, Move moveBot2, Bot bot1, Bot bot2) {
        this.moveBot1 = moveBot1;
        this.moveBot2 = moveBot2;
        this.bot1 = bot1;
        this.bot2 = bot2;
    }
}
