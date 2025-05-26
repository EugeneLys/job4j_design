package ru.job4j.algo;

import java.util.Stack;

public class Brackets {
    public boolean isValid(String s) {
        var result = true;
        var elements = s.split("");
        var stack = new Stack<>();
        for (var element : elements) {
            if (element.equals("{") || element.equals("[") || element.equals("(")) {
                stack.push(element);
            }

            if (element.equals(")")) {
                if (stack.isEmpty() || !stack.pop().equals("(")) {
                    result = false;
                }
            }
            if (element.equals("}")) {
                if (stack.isEmpty() || !stack.pop().equals("{")) {
                    result = false;
                }
            }

            if (element.equals("]")) {
                if (stack.isEmpty() || !stack.pop().equals("[")) {
                    result = false;
                }
            }
        }
        if (!stack.isEmpty()) {
            result = false;
        }
        return result;
    }
}