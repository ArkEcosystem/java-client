package org.arkecosystem.client.http;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import okhttp3.*;

public class Client {
    private static final MediaType JSON = MediaType.parse("application/json");

    private final String host;
    private OkHttpClient client;
    private final Headers headers;

    public Client(String host) {
        this.host = host;
        this.client = new OkHttpClient();

        HashMap<String, String> headers = new HashMap<>();
        headers.put("content-type", JSON.toString());

        this.headers = Headers.of(headers);
    }

    public Map<String, Object> get(String url, Map<String, Object> params)
            throws IOException {
        HttpUrl.Builder httpBuilder = HttpUrl.parse(this.host + url).newBuilder();

        for (Map.Entry<String, String> entry : DotHelper.toDot(params).entrySet()) {
            if (entry.getValue() != null) {
                httpBuilder.addQueryParameter(entry.getKey(), entry.getValue().toString());
            }
        }

        Request request =
                new Request.Builder().headers(this.headers).url(httpBuilder.build()).build();

        Response response = client.newCall(request).execute();
        return new Gson()
                .fromJson(response.body().string(), Map.class);
    }

    public Map<String, Object> get(String url) throws IOException {
        return get(url, new HashMap<>());
    }

    public Map<String, Object> post(String url, Map<String, Object> payload) throws IOException {
        RequestBody body = RequestBody.create(JSON, new Gson().toJson(payload));
        Request request = new Request.Builder().url(this.host + url).post(body).build();
        Response response = client.newCall(request).execute();
        return new Gson()
                .fromJson(response.body().string(), Map.class);
    }

    public OkHttpClient getClient() {
        return client;
    }

    public void setClient(OkHttpClient client) {
        this.client = client;
    }
}
