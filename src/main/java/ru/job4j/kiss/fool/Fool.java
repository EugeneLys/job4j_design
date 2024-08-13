package ru.job4j.kiss.fool;

import java.util.Scanner;

public class Fool {

    static int startAt = 1;

    public static void check(String right, String answer) {
        if (!right.equals(answer)) {
            System.out.println("Ошибка. Начинай снова.");
            startAt = 0;
        }
    }

    public static void main(String[] args) {
        System.out.println("Игра FizzBuzz.");
        var input = new Scanner(System.in);
        while (startAt < 100) {
            if (startAt % 3 == 0 && startAt % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (startAt % 3 == 0) {
                System.out.println("Fizz");
            } else if (startAt % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(startAt);
            }
            startAt++;
            var answer = input.nextLine();
            if (startAt % 3 == 0 && startAt % 5 == 0) {
                check("FizzBuzz", answer);
            } else if (startAt % 3 == 0) {
                check("Fizz" ,answer);
            } else if (startAt % 5 == 0) {
                check("Buzz", answer);
            } else {
                check(String.valueOf(startAt), answer);
            }
            startAt++;
        }
    }
}
