package org.kainos.ea.client;

public class FailedToUpdateDeliveryEmployeeException extends Exception {
    @Override
    public String getMessage() {

        return "Failed to update the Delivery Employee";
    }
}
