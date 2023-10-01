package ru.job4j.spammer;

import ru.job4j.jdbc.TableEditor;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Pattern;

public class ImportDB {

    private Properties cfg;
    private String dump;

    public ImportDB(Properties cfg, String dump) {
        this.cfg = cfg;
        this.dump = dump;
    }

    public List<User> load() throws IOException {
        List<User> users = new ArrayList<>();
        String br = ";";
        try (BufferedReader rd = new BufferedReader(new FileReader(dump))) {
            rd.lines().filter(this::checkUser)
                    .forEach(e -> users.add(new User(e.substring(0, e.indexOf(br)), e.substring(e.indexOf(br) + 1))));
        }
        return users;
    }

    public void save(List<User> users) throws ClassNotFoundException, SQLException {
        Class.forName(cfg.getProperty("jdbc.driver"));
        try (Connection cnt = DriverManager.getConnection(
                cfg.getProperty("jdbc.url"),
                cfg.getProperty("jdbc.username"),
                cfg.getProperty("jdbc.password")
        )) {
            for (User user : users) {
                try (PreparedStatement ps = cnt.prepareStatement("INSERT INTO users(name, email) values (?, ?)")) {
                    ps.setString(1, user.name);
                    ps.setString(2, user.email);
                    ps.execute();
                }
            }
        }
    }

    public boolean checkUser(String str) {
        if (Pattern.matches("[^;]+;$", str)) {
            throw new IllegalArgumentException("bad spammer data - no email");
        }
        if (Pattern.matches("[;].+@.+;", str)) {
            throw new IllegalArgumentException("bad spammer data - no name");
        }
        if (Pattern.matches("^[;]$", str)) {
            throw new IllegalArgumentException("spammer data is empty");
        } else {
            return true;
        }
    }

    private static class User {
        String name;
        String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }

    public static void main(String[] args) throws Exception {
        Properties cfg = new Properties();
        try (InputStream in = ImportDB.class.getClassLoader().getResourceAsStream("app2.properties")) {
            cfg.load(in);
        }
        ImportDB db = new ImportDB(cfg, "C:\\projects\\job4j_design\\data\\dump.txt");
        TableEditor editor = new TableEditor(cfg);
        editor.createTable("users");
        editor.addColumn("users", "name", "text");
        editor.addColumn("users", "email", "text");
        db.save(db.load());
    }
}
