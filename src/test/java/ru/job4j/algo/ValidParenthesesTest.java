package ru.job4j.algo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ValidParenthesesTest {

    @Test
    void whenCorrect1() {
        ValidParentheses validParentheses = new ValidParentheses();
        String string = "()[]{}";
        assertThat(validParentheses.isValid(string)).isTrue();
    }

}