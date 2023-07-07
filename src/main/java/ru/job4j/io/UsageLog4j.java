package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Eugene";
        int age = 111;
        char gender = 'm';
        long weight = 85L;
        double height = 1.75;
        float size = 50.0F;
        byte course = 1;
        boolean student = true;

        LOG.debug("User info name : {}, age : {}, gender : {}, weight : {},"
                + " height : {}, size {}, course : {}, student : {}",
                name, age, gender, weight, height, size, course, student);
    }
}
