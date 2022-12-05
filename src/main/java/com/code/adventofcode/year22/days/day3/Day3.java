package com.code.adventofcode.year22.days.day3;

import com.code.adventofcode.year22.Day2022;

import java.util.List;
import java.util.stream.Collectors;


public class Day3 extends Day2022 {
    public Day3() {
        super(3);
    }

    public static void main(String[] args) {
        new Day3().printParts();
    }

    @Override
    public Object part1() {
        Integer totalMissingItems = inputStream().map(this::findDuplicateGifts).reduce(Integer::sum).get();
        return "What is the sum of the priorities of those item types? " + totalMissingItems;
    }

    @Override
    public Object part2() {
        Integer duplicateGiftsPart2 = findDuplicateGiftsPart2(inputStream().toList());
        return "What is the sum of the priorities of those item types? " + duplicateGiftsPart2;
    }

    private Integer findDuplicateGifts(String bag) {
        //check which gift is in both compartments
        String duplicateGift = bag.substring(0, bag.length() / 2).chars()
                .filter(c1 -> bag.substring(bag.length() / 2).chars().anyMatch(c2 -> c1 == c2))
                .distinct()
                .mapToObj(Character::toString)
                .collect(Collectors.joining());

        return calculatePriority(duplicateGift.charAt(0));
    }

    private static int calculatePriority(int duplicateGift) {
        //convert to priority
        //Lowercase item types a through z have priorities 1 through 26
        //Uppercase item types A through Z have priorities 27 through 52
        if (Character.isLowerCase(duplicateGift)) {
            return duplicateGift - 'a' + 1;
        } else {
            return duplicateGift - 'A' + 27;
        }
    }
    private Integer findDuplicateGiftsPart2(List<String> bags) {
        List<String> bagTrim = bags.stream().map(String::trim).toList();

        int prioritySum = 0;
        int value = 0;

        for (int x = 0, y = 1, z = 2; x < bagTrim.size(); x += 3, y += 3, z += 3) {
            char[] part1 = bagTrim.get(x).toCharArray();
            char[] part2 = bagTrim.get(y).toCharArray();
            char[] part3 = bagTrim.get(z).toCharArray();

            //check which gift is in both compartments
            value = loop(part1, part2, part3);

            int duplicateGifts = calculatePriority(value);

            prioritySum += duplicateGifts;
        }
        return prioritySum;
    }

    private char loop(char[] a, char[] b, char[] c) {
        for (char i : a) {
            for (char u : b) {
                if (i == u) {
                    for (char y : c) {
                        if (u == y) {
                            return y;
                        }
                    }
                }
            }
        }
        return 0;
    }
}
