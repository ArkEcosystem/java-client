package org.arkecosystem.client;

import java.util.HashMap;
import java.util.Map;

public class ConnectionManager {
    private Map<String, Connection> connections;
    private String defaultConnection = "main";

    public ConnectionManager() {
        this.connections = new HashMap<>();
    }

    public String getDefaultConnection() {
        return this.defaultConnection;
    }

    public void setDefaultConnection(String name) {
        this.defaultConnection = name;
    }

    public Map<String, Connection> getConnections() {
        return this.connections;
    }

    public Connection connect(Map config, String name) {
        if (this.connections.containsKey(name)) {
            throw new IllegalArgumentException("Connection [" + name + "] is already configured.");
        }

        this.connections.put(name, new Connection(config));

        return this.connections.get(name);
    }

    public Connection connect(Map config) {
        return connect(config, "main");
    }

    public void disconnect(String name) {
        if (name == null || name.isEmpty()) {
            name = getDefaultConnection();
        }

        this.connections.remove(name);
    }

    public void disconnect() {
        disconnect(null);
    }

    public Connection connection(String name) {
        if (name == null || name.isEmpty()) {
            name = getDefaultConnection();
        }

        if (!this.connections.containsKey(name)) {
            throw new IllegalArgumentException("Connection [" + name + "] not configured.");
        }

        return this.connections.get(name);
    }

    public Connection connection() {
        return connection(null);
    }

}
