package ru.job4j.question;

import java.util.*;

public class Analyze {

    public static Info diff(Set<User> previous, Set<User> current) {
        int changeCount = 0;
        int delCount = previous.size();

        Map<Integer, String> check = new HashMap<>();
        for (User u : current) {
            check.put(u.getId(), u.getName());
        }

        int addCount = check.size();

        for (User u : previous) {
            if (check.containsKey(u.getId())) {
                if (!Objects.equals(check.get(u.getId()), u.getName())) {
                    changeCount++;
                }
                delCount--;
                addCount--;
            }
        }
        return new Info(addCount, changeCount, delCount);
    }
}
