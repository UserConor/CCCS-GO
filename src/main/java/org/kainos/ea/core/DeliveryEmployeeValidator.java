package org.kainos.ea.core;

import org.kainos.ea.cli.DeliveryEmployeeRequest;

public class DeliveryEmployeeValidator {
    public String isValidDeliveryEmployee(DeliveryEmployeeRequest deliveryEmployee) {
        if (deliveryEmployee.getForename().length() > 20) {
            return "Forename cannot be greater than 20 characters";
        }

        if (deliveryEmployee.getSurname().length() > 20) {
            return "Surname cannot be greater than 20 characters";
        }

        if (deliveryEmployee.getBankNum().length() > 16) {
            return "Bank number cannot be greater than 16 characters";
        }

        if (deliveryEmployee.getNINum().length() > 9) {
            return "National insurance number cannot be greater than 9 characters";
        }

        return null;
    }
}
