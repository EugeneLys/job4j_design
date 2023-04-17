package ru.job4j.map;

import java.util.*;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return children == user.children && Objects.equals(name, user.name) && Objects.equals(birthday, user.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        Calendar birthday = Calendar.getInstance();
        User first = new User("Name", 3, birthday);
        int hashCode1 = first.hashCode();
        int hash1 = hashCode1 ^ (hashCode1 >>> 16);
        int bucket1 = hash1 & 15;
        //System.out.println(first.birthday);
        User second = new User("Name", 3, birthday);
        int hashCode2 = second.hashCode();
        int hash2 = hashCode2 ^ (hashCode2 >>> 16);
        int bucket2 = hash2 & 15;
        //System.out.println(second.birthday);
        Map<User, Object> map = new HashMap<User, Object>(16);
        map.put(first, new Object());
        map.put(second, new Object());
        Set<User> mapSet = map.keySet();
        System.out.println(mapSet);
        /*System.out.printf("first - hashCode: %s, hash: %s, bucket: %s", hashCode1, hash1, bucket1);
        System.out.println();
        System.out.printf("second - hashCode: %s, hash: %s, bucket: %s", hashCode2, hash2, bucket2);
        System.out.println();
        System.out.println(map.get(first));
        System.out.println(map.get(second));*/
    }
}