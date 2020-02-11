package org.arkecosystem.client.api;

import com.google.gson.internal.LinkedTreeMap;
import java.io.IOException;
import java.util.Map;
import org.arkecosystem.client.http.Client;

public class Bridgechains {
  private Client client;

  public Bridgechains(Client client) {
    this.client = client;
  }

  public LinkedTreeMap<String, Object> all() throws IOException {
    return this.client.get("bridgechains");
  }

  public LinkedTreeMap<String, Object> show(String id) throws IOException {
    return this.client.get("bridgechains/" + id);
  }

  public LinkedTreeMap<String, Object> search(Map<String, Object> parameters) throws IOException {
    return this.client.post("bridgechains/search", parameters);
  }
}
