package ru.job4j.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private Properties properties;

    public TableEditor(Properties properties) throws SQLException {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws SQLException {
        String url = properties.getProperty("jdbc.url");
        String login = properties.getProperty("jdbc.username");
        String password = properties.getProperty("jdbc.password");
        connection = DriverManager.getConnection(url, login, password);
    }

    public void createTable(String tableName) throws SQLException {
        createStatement(String.format("CREATE TABLE IF NOT EXISTS %s()", tableName));
    }

    public void dropTable(String tableName) throws SQLException {
        createStatement(String.format("DROP TABLE %s", tableName));
    }

    public void addColumn(String tableName, String columnName, String type) throws SQLException {
        createStatement(String.format("ALTER TABLE %s ADD IF NOT EXISTS %s %s", tableName, columnName, type));
    }

    public void dropColumn(String tableName, String columnName) throws SQLException {
        createStatement(String.format("ALTER TABLE %s DROP COLUMN %s", tableName, columnName));
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws SQLException {
        createStatement(String.format("ALTER TABLE %s RENAME COLUMN %s TO %s", tableName, columnName, newColumnName));
    }

    public String getTableScheme(String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "SELECT * FROM %s LIMIT 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public void createStatement(String sql) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }

    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        try (InputStream in = TableEditor.class.getClassLoader().getResourceAsStream("app.properties")) {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        TableEditor te = new TableEditor(properties);
        te.initConnection();
        te.createTable("myTable");
        System.out.println(te.getTableScheme("myTable"));
        te.addColumn("myTable", "first", "varchar(255)");
        System.out.println(te.getTableScheme("myTable"));
        te.renameColumn("myTable", "first", "third");
        System.out.println(te.getTableScheme("myTable"));
        te.dropColumn("myTable", "third");
        System.out.println(te.getTableScheme("myTable"));
        te.dropTable("myTable");
    }
}
