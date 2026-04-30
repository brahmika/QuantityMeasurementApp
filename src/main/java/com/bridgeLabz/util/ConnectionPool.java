package com.bridgeLabz.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {

    private static final int INITIAL_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;

    private final List<Connection> availableConnections = new ArrayList<>();
    private final List<Connection> usedConnections = new ArrayList<>();

    private final String url;
    private final String username;
    private final String password;

    private static ConnectionPool instance;

    private ConnectionPool(String url, String username, String password) throws SQLException {
        this.url = url;
        this.username = username;
        this.password = password;

        for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
            availableConnections.add(createConnection());
        }
    }

    public static ConnectionPool getInstance(String url, String username, String password) throws SQLException {
        if (instance == null) {
            instance = new ConnectionPool(url, username, password);
        }
        return instance;
    }

    private Connection createConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    public synchronized Connection getConnection() throws SQLException {
        if (availableConnections.isEmpty()) {
            if (usedConnections.size() < MAX_POOL_SIZE) {
                availableConnections.add(createConnection());
            } else {
                throw new SQLException("Maximum pool size reached");
            }
        }

        Connection connection = availableConnections.remove(availableConnections.size() - 1);
        usedConnections.add(connection);
        return connection;
    }

    public synchronized void releaseConnection(Connection connection) {
        usedConnections.remove(connection);
        availableConnections.add(connection);
    }

    public int getAvailableConnectionsCount() {
        return availableConnections.size();
    }

    public int getUsedConnectionsCount() {
        return usedConnections.size();
    }

    public void shutdown() throws SQLException {
        for (Connection conn : availableConnections) {
            conn.close();
        }
        for (Connection conn : usedConnections) {
            conn.close();
        }
        availableConnections.clear();
        usedConnections.clear();
    }
}