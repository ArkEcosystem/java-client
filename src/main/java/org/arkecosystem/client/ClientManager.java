package org.arkecosystem.client;

import java.util.HashMap;
import java.util.Map;

public class ClientManager {
    private final Map<String, ArkClient> clients;
    private String defaultClient = "main";

    public ClientManager() {
        this.clients = new HashMap<>();
    }

    /**
     * Get the default client name.
     *
     * @return The name of the default client.
     */
    public String getDefaultClient() {
        return this.defaultClient;
    }

    /**
     * Set the default client name.
     *
     * @param name The name of the default client to set.
     */
    public void setDefaultClient(String name) {
        this.defaultClient = name;
    }

    /**
     * Return all created clients.
     *
     * @return A map of all created clients.
     */
    public Map<String, ArkClient> getClients() {
        return this.clients;
    }

    /**
     * Connect to a given client.
     *
     * @param host The host URL for the client.
     * @param name The name to assign to this client instance.
     * @return The newly created ArkClient instance.
     */
    public ArkClient connect(String host, String name) {
        if (this.clients.containsKey(name)) {
            throw new IllegalArgumentException("Client [" + name + "] is already configured.");
        }

        this.clients.put(name, new ArkClient(host));

        return this.clients.get(name);
    }

    /**
     * Connect to the default client.
     *
     * @param host The host URL for the client.
     * @return The newly created ArkClient instance.
     */
    public ArkClient connect(String host) {
        return connect(host, "main");
    }

    /**
     * Disconnect from a given client.
     *
     * @param name The name of the client to disconnect.
     */
    public void disconnect(String name) {
        if (name == null || name.isEmpty()) {
            name = getDefaultClient();
        }

        this.clients.remove(name);
    }

    /**
     * Disconnect from the default client.
     */
    public void disconnect() {
        disconnect(null);
    }

    /**
     * Get a client instance by name.
     *
     * @param name The name of the client to retrieve.
     * @return The corresponding ArkClient instance.
     */
    public ArkClient client(String name) {
        if (name == null || name.isEmpty()) {
            name = getDefaultClient();
        }

        if (!this.clients.containsKey(name)) {
            throw new IllegalArgumentException("Client [" + name + "] not configured.");
        }

        return this.clients.get(name);
    }

    /**
     * Get the default client instance.
     *
     * @return The default ArkClient instance.
     */
    public ArkClient client() {
        return client(null);
    }
}
