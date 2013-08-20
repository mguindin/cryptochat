package com.mguindin.cryptochat;

/**
 * author: matt <matt@guindin.com>
 */
public class App {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java -jar cryptochat.jar <IP> <public key file>");
            System.exit(-1);
        }
        // create Contact to communicate with
        Contact contact = new Contact(args[0], args[1]);

        //next we need to initialize a server to communicate
    }
}
