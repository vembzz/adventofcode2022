package com.code.adventofcode.year22;

import com.code.adventofcode.common.Day;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {
  public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException, InvocationTargetException, NoSuchMethodException {
    for (int day = 1; day <= 25; day++) {
      System.out.println("Day " + day + ":");
      Day instance = (Day) Class.forName("com.code.adventofcode.year22.days.Day" + day).getDeclaredConstructor().newInstance();
      instance.printParts();
      System.out.println();
    }
  }
}
