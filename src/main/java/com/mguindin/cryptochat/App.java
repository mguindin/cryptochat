package com.mguindin.cryptochat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * author: matt <matt@guindin.com>
 */
public class App {
    private static final int SERVER_PORT = 5555;
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java -jar cryptochat.jar <IP> <public key file>");
            System.exit(-1);
        }
        try {
            // create Contact to communicate with
            Contact contact = new Contact(args[0], args[1]);

            //next we need to initialize a server to communicate
            Server server = new Server(SERVER_PORT);
            server.startServer(contact);
        } catch (IOException e) {
            LOGGER.error("IOException during server operation: {}", e.getMessage());
        }
    }
}
