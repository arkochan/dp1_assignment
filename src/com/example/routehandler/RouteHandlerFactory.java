package com.example.routehandler;

public class RouteHandlerFactory {
    public RouteHandler createRouteHandler(String route) {
        if (route.equals("/home")) {
            return new HomeRouteHandler();
        } else if (route.equals("/about")) {
            return new AboutRouteHandler();
        } else if (route.equals("/menu")) {
            return new MenuRouteHandler();
        } else {
            throw new IllegalArgumentException("Invalid route: " + route);
        }
    }
}
