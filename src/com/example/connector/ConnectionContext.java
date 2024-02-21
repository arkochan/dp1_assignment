package com.example.connector;
// Context class
public class ConnectionContext {
    private ConnectionStrategy connectionStrategy;

    public ConnectionContext(ConnectionStrategy connectionStrategy) {
        this.connectionStrategy = connectionStrategy;
    }

    public void setConnectionStrategy(ConnectionStrategy connectionStrategy) {
        this.connectionStrategy = connectionStrategy;
    }

    public void connect() {
        // Delegating connection logic to the strategy
        connectionStrategy.connect();
    }
}

