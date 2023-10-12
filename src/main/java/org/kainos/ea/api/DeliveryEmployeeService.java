package org.kainos.ea.api;

import org.kainos.ea.cli.DeliveryEmployee;
import org.kainos.ea.client.DeliveryEmployeeDoesNotExistException;
import org.kainos.ea.client.FailedToGetDeliveryEmployeesException;
import org.kainos.ea.db.DeliveryEmployeeDao;

import java.sql.SQLException;
import java.util.List;

public class DeliveryEmployeeService {
    private DeliveryEmployeeDao deliveryEmployeeDao = new DeliveryEmployeeDao();


    public List<DeliveryEmployee> getAllDeliveryEmployees() throws FailedToGetDeliveryEmployeesException {
        try {
            List<DeliveryEmployee> deliveryEmployeeList = deliveryEmployeeDao.getAllDeliveryEmployees();

            return deliveryEmployeeList;
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToGetDeliveryEmployeesException();
        }
    }


    public DeliveryEmployee getDeliveryEmployeeById(int id) throws FailedToGetDeliveryEmployeesException, DeliveryEmployeeDoesNotExistException {
        try {
            DeliveryEmployee deliveryEmployee = deliveryEmployeeDao.getDeliveryEmployeeById(id);

            if (deliveryEmployee == null) {
                throw new DeliveryEmployeeDoesNotExistException();
            }

            return deliveryEmployee;
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToGetDeliveryEmployeesException();
        }
    }
}