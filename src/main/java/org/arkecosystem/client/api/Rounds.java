package org.arkecosystem.client.api;

import com.google.gson.internal.LinkedTreeMap;
import java.io.IOException;
import org.arkecosystem.client.http.Client;

public class Rounds {
  private Client client;

  public Rounds(Client client) {
    this.client = client;
  }

  public LinkedTreeMap<String, Object> delegates(int id) throws IOException {
    return this.client.get("rounds/" + id + "/delegates");
  }
}
