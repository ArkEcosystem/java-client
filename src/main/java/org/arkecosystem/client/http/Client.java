package org.arkecosystem.client.http;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import okhttp3.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Client {
    private String host;
    private String version;
    private OkHttpClient client;
    private Headers headers;
    private MediaType JSON = MediaType.parse("application/json");

    public Client(String host, String version) {
        this.host = host;
        this.version = version;
        this.client = new OkHttpClient();

        HashMap<String, String> headers = new HashMap<>();
        headers.put("API-Version", this.version);
        headers.put("content-type", this.JSON.toString());

        this.headers = Headers.of(headers);
    }

    public LinkedTreeMap<String, Object> get(String url, Map<String, Object> params) throws IOException {
        HttpUrl.Builder httpBuilder = HttpUrl.parse(this.host + url).newBuilder();

        if (params != null) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                httpBuilder.addQueryParameter(entry.getKey(), entry.getValue().toString());
            }
        }

        Request request = new Request.Builder().headers(this.headers).url(httpBuilder.build()).build();

        Response response = client.newCall(request).execute();
        return new Gson().fromJson(response.body().string(), new LinkedTreeMap<String, Object>().getClass());
    }

    public LinkedTreeMap<String, Object> get(String url) throws IOException {
        return get(url, new HashMap());
    }

    public LinkedTreeMap<String, Object> post(String url, Map payload) throws IOException {
        RequestBody body = RequestBody.create(JSON, new Gson().toJson(payload));
        Request request = new Request.Builder().headers(this.headers).url(this.host + url).post(body).build();
        Response response = client.newCall(request).execute();
        return new Gson().fromJson(response.body().string(), new LinkedTreeMap<String, Object>().getClass());
    }

    public OkHttpClient getClient() {
        return client;
    }

    public void setClient(OkHttpClient client) {
        this.client = client;
    }

}
