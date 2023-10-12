package org.kainos.ea.client;

public class ClientDoesNotExistException extends Exception {
    @Override
    public String getMessage() { return "Client does not exist"; }
}

