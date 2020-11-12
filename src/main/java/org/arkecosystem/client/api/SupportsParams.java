package org.arkecosystem.client.api;

public interface SupportsParams<T> {

    T param(String name, Object value);

}
