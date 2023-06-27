package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter pw = new PrintWriter(new FileWriter(path, Charset.forName("WINDOWS-1251"), true))) {
            List<String> list = readPhrases();
            System.out.println("Введите сообщение: ");
            String str = br.readLine();
            pw.println(str);
            while (!str.equals(OUT)) {
                if (str.equals(STOP)) {
                    while (!str.equals(CONTINUE)) {
                        str = br.readLine();
                        pw.println(str);
                    }
                } else {
                    pw.println(list.get((int) (Math.random() * list.size())));
                    System.out.println(list.get((int) (Math.random() * list.size())));
                    str = br.readLine();
                    pw.println(str);
                }
            }
            br.close();
            System.out.println("Program execution finished");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<String> readPhrases() {
        List<String> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader
                (new FileReader(botAnswers, Charset.forName("WINDOWS-1251")))) {
            br.lines().forEach(result::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path, Charset.forName("WINDOWS-1251"), true))) {
            log.forEach(pw::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("./src/data/log.txt", "./src/data/botAnswers.txt");
        cc.run();
    }
}
