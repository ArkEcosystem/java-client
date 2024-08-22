package org.arkecosystem.client;

import java.util.Map;
import org.arkecosystem.client.api.Api;
import org.arkecosystem.client.http.Client;

public class ArkClient {
    private final Api api;
    private final Client client;

    /**
     * Constructor to create an instance of ArkClient.
     *
     * @param hostOrHosts Can be a string representing the host URL or a map with different types of
     *     hosts.
     */
    public ArkClient(Object hostOrHosts) {
        this.client = new Client(hostOrHosts);
        this.api = new Api(this.client);
    }

    /**
     * Method to get the API instance.
     *
     * @return The API instance.
     */
    public Api api() {
        return this.api;
    }

    /**
     * Method to get the HTTP client instance.
     *
     * @return The HTTP client instance.
     */
    public Client client() {
        return this.client;
    }

    /**
     * Method to set a new host for a specific type.
     *
     * @param host The host URL.
     * @param type The type of host (api, transactions, evm).
     */
    public void setHost(String host, String type) {
        this.client.setHost(host, type);
    }

    /**
     * Method to get the current hosts.
     *
     * @return A map with the current hosts.
     */
    public Map<String, String> getHosts() {
        return this.client.getHosts();
    }
}
