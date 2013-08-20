package com.mguindin.cryptochat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * author: matt <matt@guindin.com>
 */
public class ChatThread extends Thread {
    private static final Logger LOGGER = LoggerFactory.getLogger(ChatThread.class);
    private Socket socket = null;
    private Contact contact;

    public ChatThread(Socket socket, Contact contact) {
        super("ChatThread");
        this.socket = socket;
        this.contact = contact;
    }

    public void run() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String inputLine;
            while ((inputLine = input.readLine()) != null) {
                //process input
                System.out.println(contact.decryptMessage(inputLine));
            }
        } catch (IOException e) {
            LOGGER.error("IOException during ChatThread: {}", e.getMessage());
        }
    }
}
