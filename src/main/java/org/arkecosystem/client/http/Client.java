package org.arkecosystem.client.http;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import okhttp3.*;

public class Client {
    private static final MediaType JSON = MediaType.parse("application/json");

    private final Map<String, String> hosts;
    private String api = "api";
    private OkHttpClient client;
    private final Headers headers;

    public Client(Object hostOrHosts) {
        this.hosts = validateHosts(hostOrHosts);
        this.client = new OkHttpClient();

        HashMap<String, String> headers = new HashMap<>();
        headers.put("content-type", JSON.toString());

        this.headers = Headers.of(headers);
    }

    public Map<String, Object> get(String url, Map<String, Object> params) throws IOException {
        HttpUrl.Builder httpBuilder = HttpUrl.parse(buildUrl(url)).newBuilder();

        for (Map.Entry<String, String> entry : DotHelper.toDot(params).entrySet()) {
            if (entry.getValue() != null) {
                httpBuilder.addQueryParameter(entry.getKey(), entry.getValue().toString());
            }
        }

        Request request =
                new Request.Builder().headers(this.headers).url(httpBuilder.build()).build();

        Response response = client.newCall(request).execute();
        return new Gson().fromJson(response.body().string(), Map.class);
    }

    public Map<String, Object> get(String url) throws IOException {
        return get(url, new HashMap<>());
    }

    public Map<String, Object> post(String url, Map<String, Object> payload) throws IOException {
        RequestBody body = RequestBody.create(JSON, new Gson().toJson(payload));
        Request request = new Request.Builder().url(buildUrl(url)).post(body).build();
        Response response = client.newCall(request).execute();
        return new Gson().fromJson(response.body().string(), Map.class);
    }

    public OkHttpClient getClient() {
        return client;
    }

    public void setClient(OkHttpClient client) {
        this.client = client;
    }

    public Client withApi(String api) {
        this.api = api;
        return this;
    }

    public void setHost(String host, String type) {
        if (!type.equals("api") && !type.equals("transactions") && !type.equals("evm")) {
            throw new IllegalArgumentException("Invalid host type.");
        }
        this.hosts.put(type, host);
    }

    public Map<String, String> getHosts() {
        return this.hosts;
    }

    private String buildUrl(String path) {
        String baseUri = this.hosts.get(api);

        // Reset the API to the default value.
        this.api = "api";

        return baseUri.endsWith("/") ? baseUri + path : baseUri + "/" + path;
    }

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

                if (key.equals("api") || key.equals("transactions") || key.equals("evm")) {
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
