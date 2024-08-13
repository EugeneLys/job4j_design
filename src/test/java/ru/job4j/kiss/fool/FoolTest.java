package ru.job4j.kiss.fool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class FoolTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(output));
    }

    @Test
    void When3and5Denominator() {
        Fool fool = new Fool();
        var next = "13";
        var answer = "FizzBuzz";
        Fool.check(next, answer);
        assertEquals("Ошибка. Начинай снова.", output.toString().trim());
    }
}