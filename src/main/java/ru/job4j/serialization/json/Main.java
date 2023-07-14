package ru.job4j.serialization.json;

import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        final Contact contact = new Contact("33-333");
        final Contact contact2 = new Contact("22-222");
        final Person person = new Person("Ivan", false, 30, contact, new String[] {"Worker", "Married"});
        final Person person2 = new Person("Mary", true, 25, contact2, new String[] {"Manager", "Single"});
        final Position position = new Position("Director", 10, person, true,
                new String[] {"Experienced", "MBA", "Smart and clever"});

        JSONObject contactJO = new JSONObject();
        contactJO.put("phone", contact.getPhone());

        JSONObject personJO = new JSONObject();
        personJO.put("name", person.getName());
        personJO.put("sex", person.isSex());
        personJO.put("age", person.getAge());
        personJO.put("contact", person.getContact());
        personJO.put("statuses", person.getStatuses());

        JSONObject positionJO = new JSONObject(position);

        String ln = System.lineSeparator();
        System.out.println("contact: " + ln + contactJO);
        System.out.println("person: " + ln + personJO);
        System.out.println("position: " + ln + positionJO);
        System.out.println("person2: " + ln + new JSONObject(person2));
    }
}