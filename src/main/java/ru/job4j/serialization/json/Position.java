package ru.job4j.serialization.json;

import java.util.Arrays;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Position {
    private final String title;
    private final int grade;
    private final Person person;
    private final boolean occupied;
    private final String[] requirements;

    public Position(String title, int grade, Person person, boolean occupied, String[] requirements) {
        this.title = title;
        this.grade = grade;
        this.person = person;
        this.occupied = occupied;
        this.requirements = requirements;
    }

    @Override
    public String toString() {
        return "Position{"
                + "title='" + title + '\''
                + ", grade=" + grade
                + ", person=" + person
                + ", occupied=" + occupied
                + ", requirements=" + Arrays.toString(requirements)
                + '}';
    }

    public static void main(String[] args) {
        final Position pos = new Position("Director", 10, new Person("Eugene", false, 30,
                new Contact("333-33-33"), new String[] {"manager"}), true,
                new String[] {"Higher education", "Connections", "Experience"});
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(pos));
        final String positionJson =
                "{"
                + "\"title\":\"Director\","
                + "\"grade\":10,"
                + "\"person\":"
                + "{"
                + "\"name\":\"Eugene\","
                + "\"sex\":false,"
                + "\"age\":30,"
                + "\"contact\":"
                + "{"
                + "\"phone\":\"333-33-33\""
                + "},"
                + "\"statuses\":"
                + "[\"manager\"]"
                + "},"
                + "\"occupied\":true,"
                +  "\"requirements\":"
                + "[\"Clever\",\"Smart\",\"Experienced\"]"
                + "}";
        final Position positionMod = gson.fromJson(positionJson, Position.class);
        System.out.println(positionMod);
    }
}
