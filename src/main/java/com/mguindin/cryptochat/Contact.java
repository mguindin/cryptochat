package com.mguindin.cryptochat;

import java.net.Inet4Address;
import java.security.KeyStore;

/**
 * author: matt <matt@guindin.com>
 */
public class Contact {
    private Inet4Address address;
    private KeyStore pubKey;

    public Contact(String IP, String fileLocation) {
        address = convertStringIp(IP);
        pubKey = createKeyStore(fileLocation);
    }

    private static Inet4Address convertStringIp(String IP) {
        Inet4Address addy = null;

        return addy;
    }

    private static KeyStore createKeyStore(String fileLocation) {
        KeyStore keyStore = null;

        return keyStore;
    }

    public String decryptMessage(String input) {
        String output = "";
        return output;
    }
}
