package com.example.routehandler;

public class AboutRouteHandler implements RouteHandler {
    @Override
    public String handleRequest() {
        return "About Us - Learn more about our company.";
    }
}
