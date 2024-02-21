package com.example.routehandler;

public class MenuRouteHandler implements RouteHandler {
    @Override
    public String handleRequest() {
        return "Menu - Item 1, Item 2";
    }
}
