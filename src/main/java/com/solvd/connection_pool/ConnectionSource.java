package com.solvd.connection_pool;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.stream.Collectors;

public class ConnectionSource {
    private static final String DB_URL = "jdbc:hsqldb:mem:myDb";
    private static final String USER = "admin";
    private static final String PASS = "root";

    private static final ConnectionSource instance = new ConnectionSource();

    public static ConnectionSource instance() {
        return instance;
    }

    public Connection createConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

    private ConnectionSource() {

        try {
            DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());

            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
                try (Statement statement = conn.createStatement()) {
                    statement.execute(getSql("init-ddl.sql"));
                }
                try (Statement statement = conn.createStatement()) {
                    statement.execute(getSql("init-dml.sql"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private static String getSql(final String resourceName) {
        return new BufferedReader(
                new InputStreamReader(
                        Objects.requireNonNull(
                                ConnectionSource.class.getClassLoader().getResourceAsStream(resourceName))))
                .lines()
                .collect(Collectors.joining("\n"));
    }
}
