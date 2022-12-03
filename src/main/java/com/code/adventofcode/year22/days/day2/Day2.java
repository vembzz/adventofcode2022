package com.code.adventofcode.year22.days.day2;

import com.code.adventofcode.year22.Day2022;

import java.util.List;
import java.util.stream.Stream;


public class Day2 extends Day2022 {

    private static final String UNKNOWN_INPUT = "Unknown input";

    public Day2() {
        super(2);
    }

    public static void main(String[] args) {
        new Day2().printParts();
    }

    @Override
    public Object part1() {
        int totalScorePart1 = getTotalScore(dayStream().map(this::mapToPickPart1));
        return "What would your total score be if everything goes exactly according to your strategy guide? " + totalScorePart1;
    }

    @Override
    public Object part2() {
        int totalScorePart2 = getTotalScore(dayStream().map(this::mapToPickPart2));
        return "What would your total score be if everything goes exactly according to your strategy guide? " + totalScorePart2;
    }

    private int getTotalScore(Stream<Game> gameStream) {
        List<Game> picks = gameStream.toList();
        picks.stream().map(this::mapToScores).toList();

        int sumMyPick = picks.stream().map(game -> game.getMyPick().score).reduce(0, Integer::sum);
        int sumOutcome = picks.stream().map(game -> game.getOutcome().score).reduce(0, Integer::sum);

        return sumMyPick + sumOutcome;
    }

    private Game mapToPickPart1(String line) {
        Game game = new Game();

        switch (line.charAt(0)) {
            case 'A' -> game.setElfPick(RockPaperScissors.ROCK);
            case 'B' -> game.setElfPick(RockPaperScissors.PAPER);
            case 'C' -> game.setElfPick(RockPaperScissors.SCISSORS);
            default -> throw new IllegalArgumentException(UNKNOWN_INPUT);
        }

        switch (line.charAt(2)) {
            case 'X' -> game.setMyPick(RockPaperScissors.ROCK);
            case 'Y' -> game.setMyPick(RockPaperScissors.PAPER);
            case 'Z' -> game.setMyPick(RockPaperScissors.SCISSORS);
            default -> throw new IllegalArgumentException(UNKNOWN_INPUT);
        }
        return game;
    }

    private Game mapToPickPart2(String line) {
        Game game = new Game();

        switch (line.charAt(0)) {
            case 'A' -> game.setElfPick(RockPaperScissors.ROCK);
            case 'B' -> game.setElfPick(RockPaperScissors.PAPER);
            case 'C' -> game.setElfPick(RockPaperScissors.SCISSORS);
            default -> throw new IllegalArgumentException(UNKNOWN_INPUT);
        }

        switch (line.charAt(2)) {
            case 'X' -> game.setMyPick(winFromElf(game.getElfPick()));
            case 'Y' -> game.setMyPick(game.getElfPick());
            case 'Z' -> game.setMyPick(looseFromElf(game.getElfPick()));
            default -> throw new IllegalArgumentException(UNKNOWN_INPUT);
        }
        return game;
    }

    private RockPaperScissors winFromElf(RockPaperScissors elfPick) {
        if (elfPick == RockPaperScissors.ROCK) {
            return RockPaperScissors.SCISSORS;
        } else if (elfPick == RockPaperScissors.SCISSORS) {
            return RockPaperScissors.PAPER;
        } else {
            return RockPaperScissors.ROCK;
        }
    }

    private RockPaperScissors looseFromElf(RockPaperScissors elfPick) {
        if (elfPick == RockPaperScissors.ROCK) {
            return RockPaperScissors.PAPER;
        } else if (elfPick == RockPaperScissors.SCISSORS) {
            return RockPaperScissors.ROCK;
        } else {
            return RockPaperScissors.SCISSORS;
        }
    }

    private Game mapToScores(Game game) {
        if (game.getMyPick() == game.getElfPick()) {
            return game.setOutcome(Outcome.DRAW);
        }
        if ((game.getMyPick() == RockPaperScissors.PAPER && game.getElfPick() == RockPaperScissors.ROCK)
                || (game.getMyPick() == RockPaperScissors.ROCK && game.getElfPick() == RockPaperScissors.SCISSORS)
                || (game.getMyPick() == RockPaperScissors.SCISSORS && game.getElfPick() == RockPaperScissors.PAPER)) {
            return game.setOutcome(Outcome.WIN);
        }
        return game.setOutcome(Outcome.LOOSE);
    }
}
