package com.code.adventofcode.year22.days;

import com.code.adventofcode.year22.Day2022;

import java.util.Arrays;
import java.util.List;

public class Day4 extends Day2022 {

    public Day4() {
        super(4);
    }

    public static void main(String[] args) {
        new Day4().printParts();
    }

    @Override
    public Object part1() {
        long total = inputStream().map(this::totalElfCleaning).filter(this::fullyContains).count();
        return "In how many assignment pairs does one range fully contain the other? " + total;
    }

    @Override
    public Object part2() {
        long total = inputStream().map(this::totalElfCleaning).filter(this::overlaps).count();
        return "In how many assignment pairs do the ranges overlap? " + total;
    }


    private String[] totalElfCleaning(String rooms) {
        return rooms.trim().split(",");
    }

    private boolean fullyContains(String[] section) {
        List<Integer> section1 = Arrays.stream(section[0].split("-")).map(Integer::parseInt).toList();
        List<Integer> section2 = Arrays.stream(section[1].split("-")).map(Integer::parseInt).toList();

        return (section1.get(0) >= section2.get(0) && section1.get(1) <= section2.get(1))
                || (section2.get(0) >= section1.get(0) && section2.get(1) <= section1.get(1));
    }

    private boolean overlaps(String[] section) {
        List<Integer> section1 = Arrays.stream(section[0].split("-")).map(Integer::parseInt).toList();
        List<Integer> section2 = Arrays.stream(section[1].split("-")).map(Integer::parseInt).toList();

        return section1.get(0) <= section2.get(1) && section1.get(1) >= section2.get(0);
    }
}
