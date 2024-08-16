package ru.job4j.kiss.fool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.job4j.kiss.fool.Fool.checkAnswer;

class FoolTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(output));
    }

    @Test
    void whenCorrectAnswer() {
        var answer = "FizzBuzz";
        checkAnswer("FizzBuzz", answer);
        assertEquals("", output.toString().strip());
    }


    @Test
    void whenWrongAnswer() {
        var answer = "15";
        checkAnswer("FizzBuzz", answer);
        assertEquals("Ошибка. Начинай снова.", output.toString().strip());
    }
}