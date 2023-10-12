package org.kainos.ea.client;

public class FailedToCreateDeliveryEmployeeException extends Exception {
    @Override
    public String getMessage() {

        return "Unable to create delivery employee";
    }
}
