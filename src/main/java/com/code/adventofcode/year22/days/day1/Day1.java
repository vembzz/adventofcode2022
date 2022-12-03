package com.code.adventofcode.year22.days.day1;

import com.code.adventofcode.common.Day;
import com.code.adventofcode.year22.Day2022;

import java.util.ArrayList;
import java.util.List;

public class Day1 extends Day2022 {


  public Day1() {
    super(1);
  }

  public static void main(String[] args) {
    Day d = new Day1();
    d.downloadIfNotDownloaded();
    d.printParts();
  }

  @Override
  public Object part1() {
    return input1();
  }

  @Override
  public Object part2() {
    return input2();
  }

  private Integer input1() {
    List<Integer> elves = new ArrayList<>();
    int[] current = new int[]{0};

    dayStream().forEach(elf -> elvesCalories(elves, current, elf));
    elves.add(current[0]);

    return elves.get(0);
  }

  private static void elvesCalories(List<Integer> elves, int[] current, String elf) {
    if (elf.isBlank()) {
      elves.add(current[0]);
      current[0] = 0;
    } else {
      current[0] += Integer.parseInt(elf.trim());
    }
  }

  private Integer input2() {
    List<Integer> elves = new ArrayList<>();
    int[] current = new int[]{0};

    dayStream().forEach(elf -> {
      elvesCalories(elves, current, elf);
    });

    elves.add(current[0]);
    elves.sort((a, b) -> b - a);

    return elves.get(0) + elves.get(1) + elves.get(2);
  }
}
