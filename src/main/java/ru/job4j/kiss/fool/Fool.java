package ru.job4j.kiss.fool;

import java.util.Scanner;

public class Fool {

    static int startAt = 1;
    static String word;
    static String answer;

    static void checkAnswer(String right, String answer) {
        if (!right.equals(answer)) {
            System.out.println("Ошибка. Начинай снова.");
            startAt = 0;
        }
    }

    static void makeMove(boolean humanTurn) {
        word = String.valueOf(startAt);
        if (startAt % 3 == 0 && startAt % 5 == 0) {
            word = "FizzBuzz";
        } else if (startAt % 3 == 0) {
            word = "Fizz";
        } else if (startAt % 5 == 0) {
            word = "Buzz";
        }
        if (humanTurn) {
            checkAnswer(word, answer);
        } else {
            System.out.println(word);
        }
        startAt++;
    }

    public static void main(String[] args) {
        System.out.println("Игра FizzBuzz.");
        var input = new Scanner(System.in);
        while (startAt < 100) {
            makeMove(false);
            answer = input.nextLine();
            makeMove(true);
        }
    }
}
