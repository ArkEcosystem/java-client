package org.arkecosystem.client;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import org.arkecosystem.client.api.Api;
import org.arkecosystem.client.http.Client;

public class ArkClient {
    private final Api api;
    private final Client client;
    private final Map<String, String> hosts;

    /**
     * Constructor to create an instance of ArkClient.
     *
     * @param hostOrHosts Can be a string representing the host URL or a map with different types of hosts.
     */
    public ArkClient(Object hostOrHosts) {
        this.hosts = validateHosts(hostOrHosts);
        this.client = new Client(this.hosts.get("api"));
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
        if (!Objects.equals(type, "api") && !Objects.equals(type, "transactions") && !Objects.equals(type, "evm")) {
            throw new IllegalArgumentException("Invalid host type.");
        }
        this.hosts.put(type, host);
    }

    /**
     * Method to get the current hosts.
     *
     * @return A map with the current hosts.
     */
    public Map<String, String> getHosts() {
        return this.hosts;
    }

    /**
     * Validate the format of the hosts.
     *
     * @param hostOrHosts Can be a string or a map.
     * @return A validated map of hosts.
     */
    private Map<String, String> validateHosts(Object hostOrHosts) {
        Map<String, String> validatedHosts = new HashMap<>();

        if (hostOrHosts instanceof String) {
            validatedHosts.put("api", (String) hostOrHosts);
        } else if (hostOrHosts instanceof Map) {
            Map<?, ?> hostsMap = (Map<?, ?>) hostOrHosts;

            if (!hostsMap.containsKey("api")) {
                throw new IllegalArgumentException("The hosts map must contain the key 'api'.");
            }

            for (Map.Entry<?, ?> entry : hostsMap.entrySet()) {
                String key = entry.getKey().toString();
                String value = entry.getValue().toString();

                if (Objects.equals(key, "api") || Objects.equals(key, "transactions") || Objects.equals(key, "evm")) {
                    validatedHosts.put(key, value);
                } else {
                    throw new IllegalArgumentException("Invalid host type: " + key);
                }
            }
        } else {
            throw new IllegalArgumentException("Invalid host format. Must be a string or a map.");
        }

        return validatedHosts;
    }
}
