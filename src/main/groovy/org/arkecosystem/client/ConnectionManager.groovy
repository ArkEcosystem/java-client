package org.arkecosystem.client

class ConnectionManager {
    String defaultConnection = 'main'
    Map<String, Connection> connections

    ConnectionManager () {
        this.connections = new HashMap<String, Connection>()
    }

    Connection connect(Map config, String name = 'main')
    {
        if (this.connections.containsKey(name)) {
            throw new IllegalArgumentException("Connection [$name] is already configured.")
        }

        this.connections.put(name, new Connection(config))

        this.connections.get(name)
    }

    void disconnect(String name = null)
    {
        if (!name) {
            name = getDefaultConnection()
        }

        this.connections.remove(name)
    }

    Connection connection(String name = null)
    {
        if (!name) {
            name = getDefaultConnection()
        }

        if (!this.connections.containsKey(name)) {
            throw new IllegalArgumentException("Connection [$name] not configured.")
        }

        this.connections.get(name)
    }

    String getDefaultConnection()
    {
        this.defaultConnection
    }

    void setDefaultConnection(String name)
    {
        this.defaultConnection = name
    }

    Map<String, Connection> getConnections()
    {
        this.connections
    }
}
