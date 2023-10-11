package org.kainos.ea.client;

public class FailedToGetDeliveryEmployeesException extends Throwable {
    @Override
    public String getMessage() {
        return "Failed to get delivery employees from the database";
    }
}
