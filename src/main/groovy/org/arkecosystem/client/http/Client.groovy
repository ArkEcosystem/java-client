package org.arkecosystem.client.http

import okhttp3.*
import com.google.gson.Gson

class Client {
    String host
    int version

    OkHttpClient client
    MediaType JSON = MediaType.parse("application/json charset=utf-8")

    Client (String host, int version) {
        this.host = host
        this.version = version
        this.client = new OkHttpClient()
    }

    Object get(String url, Map params = [:]) throws IOException {
        HttpUrl.Builder httpBuider = HttpUrl.parse(this.host + url).newBuilder()

        if (params != null) {
            params.entrySet().each { Map.Entry<String, String> param ->
                httpBuider.addQueryParameter(param.getKey(), param.getValue().toString())
            }
        }

        Request request = new Request.Builder().url(httpBuider.build()).build()

        Response response = client.newCall(request).execute()

        return new Gson().fromJson(response.body().string(), Object.class)
    }

    Object post(String url, Map payload) throws IOException {
        RequestBody body = RequestBody.create(JSON, new Gson().toJson(payload))

        Request request = new Request.Builder()
            .url(this.host + url)
            .post(body)
            .build()

        Response response = client.newCall(request).execute()

        return new Gson().fromJson(response.body().string(), Object.class)
    }
}
