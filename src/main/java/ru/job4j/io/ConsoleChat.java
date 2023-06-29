package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

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
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            List<String> list = readPhrases();
            List<String> log = new ArrayList<>();
            System.out.println("Введите первое сообщение: ");
            String str = br.readLine();
            log.add(str);
            while (str != null) {
                if (OUT.equals(str)) {
                    System.out.println("Программа закрыта.");
                    saveLog(log);
                    break;
                } else if (STOP.equals(str)) {
                    while (!CONTINUE.equals(str)) {
                        str = br.readLine();
                        log.add(str);
                    }
                } else {
                    String answer = list.get((int) (Math.random() * list.size()));
                    System.out.println(answer);
                    log.add(answer);
                    str = br.readLine();
                    log.add(str);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<String> readPhrases() {
        List<String> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(botAnswers, Charset.forName("WINDOWS-1251")))) {
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
