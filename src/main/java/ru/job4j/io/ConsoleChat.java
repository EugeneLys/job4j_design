package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {

    }

    private List<String> readPhrases() {
        List<String> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("./src/data/text.txt", Charset.forName("WINDOWS-1251")))) {
            result = br.lines().toList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private void saveLog(List<String> log) {

    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("", "");
        cc.run();
    }
}
