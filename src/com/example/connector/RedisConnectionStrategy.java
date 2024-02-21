package com.example.connector;
// Concrete strategy for Redis connection
public class RedisConnectionStrategy implements ConnectionStrategy {
    @Override
    public void connect() {
        // Implementation for connecting to Redis
        System.out.println("Connecting to Redis...");
        // Add your Redis connection logic here
    }
}
