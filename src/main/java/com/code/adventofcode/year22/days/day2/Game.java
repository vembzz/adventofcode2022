package com.code.adventofcode.year22.days.day2;

public class Game {
    private RockPaperScissors myPick;
    private RockPaperScissors elfPick;
    private Outcome outcome;

    public RockPaperScissors getMyPick() {
        return myPick;
    }

    public void setMyPick(RockPaperScissors myPick) {
        this.myPick = myPick;
    }

    public RockPaperScissors getElfPick() {
        return elfPick;
    }

    public void setElfPick(RockPaperScissors elfPick) {
        this.elfPick = elfPick;
    }

    public Outcome getOutcome() {
        return outcome;
    }

    public Game setOutcome(Outcome outcome) {
        this.outcome = outcome;
        return null;
    }
}
