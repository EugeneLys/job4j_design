package ru.job4j.algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PalindromeNumber {


    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int reverse = 0;
        int digit;
        while (x > reverse) {
            digit = x % 10;
            reverse = reverse * 10 + digit;
            x = x / 10;
        }
        return x == reverse ||  x == reverse / 10;
        /*char[] array = String.valueOf(x).toCharArray();
        int count = array.length / 2;
        int i = 0;
        while (i < count) {
            if (array[i] != array[array.length - 1 - i]) {
                return false;
            }
            i++;
        }*/
        /*return true;*/
    }

   /* @Test
    void whenCorrect1() {
        int x = 121;
        assertTrue(isPalindrome(x));
    }

    @Test
    void whenCorrect2() {
        int x = 1221;
        assertTrue(isPalindrome(x));
    }

    @Test
    void whenIncorrect1() {
        int x = -121;
        assertFalse(isPalindrome(x));
    }

    @Test
    void whenIncorrect2() {
        int x = 123;
        assertFalse(isPalindrome(x));
    }*/

    /*@Test
    void whenIncorrect3() {
        int x = 10;
        assertFalse(isPalindrome(x));
    }*/
}
