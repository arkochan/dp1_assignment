package com.example.server;

import com.example.routehandler.RouteHandler;
import com.example.routehandler.RouteHandlerFactory;
import com.example.decorator.*;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import com.example.connector.*;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class SimpleHttpServer {

    public static void main(String[] args) throws IOException {
        // Create an HTTP server that listens on port 8080
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        // Create strategies
        ConnectionStrategy jdbcStrategy = new JdbcConnectionStrategy();
        ConnectionStrategy redisStrategy = new RedisConnectionStrategy();

        // Create context with JDBC strategy
        ConnectionContext jdbcContext = new ConnectionContext(jdbcStrategy);
        jdbcContext.connect(); // Output: Connecting to JDBC...

        // Switch strategy to Redis
        jdbcContext.setConnectionStrategy(redisStrategy);
        jdbcContext.connect(); // Output: Connecting to Redis...       

        // Create a context for the "/home" route and set its handler
        server.createContext("/home", new CustomRouteHandler("/home"));

        // Create a context for the "/about" route and set its handler
        server.createContext("/about", new CustomRouteHandler("/about"));

        // Create a context for the "/menu" route and set its handler
        server.createContext("/menu", new CustomRouteHandler("/menu"));

        // Start the server
        server.setExecutor(null); // Use the default executor
        server.start();

        System.out.println("Server is running on port 8080");
    }

    // Handler for custom routes using Strategy and Decorator patterns
    static class CustomRouteHandler implements HttpHandler {
        private String route;

        public CustomRouteHandler(String route) {
            this.route = route;
        }
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            // Set the response headers
            exchange.sendResponseHeaders(200, 0);

            // Get the output stream to write the response
            OutputStream os = exchange.getResponseBody();

            // Create a RouteHandler using the Factory Pattern
            RouteHandlerFactory routeHandlerFactory = new RouteHandlerFactory();
            RouteHandler routeHandler = routeHandlerFactory.createRouteHandler(route);
            // Create a decorator using the Decorator Pattern
            HtmlComponent decoratedHtml = new BlueTextColorDecorator(new BasicHtml(routeHandler.handleRequest()));

            // Write the HTML content to the output stream
            os.write(decoratedHtml.getHtml().getBytes());

            // Close the output stream and the exchange
            os.close();
            exchange.close();
        }
    }
}
