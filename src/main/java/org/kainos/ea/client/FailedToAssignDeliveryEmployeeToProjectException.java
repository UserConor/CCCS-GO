package org.kainos.ea.client;

public class FailedToAssignDeliveryEmployeeToProjectException extends Exception {
    @Override
    public String getMessage() {
        return "Failed to assign delivery employee to project in the database";
    }
}
