package com.mguindin.cryptochat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * author: matt <matt@guindin.com>
 */
public class Server {
    private static final Logger LOGGER = LoggerFactory.getLogger(Server.class);
    private ServerSocket serverSocket = null;

    public Server (int port) {
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            LOGGER.error("Count not open port: {}", port);
        }
    }

    public void startServer(Contact contact) throws IOException {
        boolean listening = true;
        while (listening) {
            new ChatThread(serverSocket.accept(), contact).start();
            serverSocket.close();
        }
    }
}
