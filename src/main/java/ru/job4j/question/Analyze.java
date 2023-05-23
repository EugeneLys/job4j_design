package ru.job4j.question;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Analyze {

    public static Info diff(Set<User> previous, Set<User> current) {
        int addCount = 0;
        int changeCount = 0;
        int delCount = 0;

        return new Info (addCount,changeCount,delCount);
    }

}
