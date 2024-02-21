package com.example.routehandler;

public class HomeRouteHandler implements RouteHandler {
    @Override
    public String handleRequest() {
        return "Welcome to Home!";
    }
}
