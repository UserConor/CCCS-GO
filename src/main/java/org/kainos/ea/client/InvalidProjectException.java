package org.kainos.ea.client;

public class InvalidProjectException extends Exception {
    public InvalidProjectException(String validation) {

        super(validation);
    }

}
