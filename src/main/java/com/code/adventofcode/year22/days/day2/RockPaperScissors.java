package com.code.adventofcode.year22.days.day2;

public enum RockPaperScissors {
    ROCK(1),
    PAPER(2),
    SCISSORS(3);

    final int score;

    RockPaperScissors(int score) {
        this.score = score;
    }
}
