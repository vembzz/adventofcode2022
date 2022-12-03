package com.code.adventofcode.year22.days.day2;

public enum Outcome {
    WIN(6),
    DRAW(3),
    LOOSE(0);

    final int score;

    Outcome(int score) {
        this.score = score;
    }
}
