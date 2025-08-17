package ru.job4j.algo;

import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String string) {
        if (string.length() < 2) {
            return false;
        }
        char[] array = string.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : array) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (c == ')' && stack.pop() != '(') {
                    return false;
                }
                if (c == ']' && stack.pop() != '[') {
                    return false;
                }
                if (c == '}' && stack.pop() != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
