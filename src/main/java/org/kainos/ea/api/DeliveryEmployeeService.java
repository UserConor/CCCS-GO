package org.kainos.ea.api;

import org.kainos.ea.cli.DeliveryEmployee;
import org.kainos.ea.cli.DeliveryEmployeeRequest;
import org.kainos.ea.cli.DeliveryEmployeeUpdateRequest;
import org.kainos.ea.client.*;
import org.kainos.ea.core.DeliveryEmployeeValidator;
import org.kainos.ea.db.DeliveryEmployeeDao;

import java.sql.SQLException;
import java.util.List;

public class DeliveryEmployeeService {
    private DeliveryEmployeeDao deliveryEmployeeDao = new DeliveryEmployeeDao();
    private DeliveryEmployeeValidator deliveryEmployeeValidator = new DeliveryEmployeeValidator();

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

  
    public int createDeliveryEmployee(DeliveryEmployeeRequest deliveryEmployee) throws InvalidDeliveryEmployeeException, FailedToCreateDeliveryEmployeeException, InvalidDeliveryEmployeeException {
        try {
            String validation = deliveryEmployeeValidator.isValidDeliveryEmployee(deliveryEmployee);

            if (validation != null) {
                throw new InvalidDeliveryEmployeeException(validation);
            }

            int id = deliveryEmployeeDao.createDeliveryEmployee(deliveryEmployee);

            if (id == -1) {
                throw new FailedToCreateDeliveryEmployeeException();
            }

            return id;
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToCreateDeliveryEmployeeException();
        }
    }

    public void updateDeliveryEmployee(int id, DeliveryEmployeeUpdateRequest deliveryEmployeeUpdate) throws InvalidDeliveryEmployeeException, FailedToUpdateDeliveryEmployeeException, DeliveryEmployeeDoesNotExistException {
        try {
            String validation = deliveryEmployeeValidator.isValidDeliveryEmployeeUpdate(deliveryEmployeeUpdate);

            if (validation != null) {
                throw new InvalidDeliveryEmployeeException(validation);
            }

            DeliveryEmployee deliveryEmployeeToUpdate = deliveryEmployeeDao.getDeliveryEmployeeById(id);

            if (deliveryEmployeeToUpdate == null) {
                throw new DeliveryEmployeeDoesNotExistException();
            }

            deliveryEmployeeDao.updateDeliveryEmployee(id, deliveryEmployeeUpdate);
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToUpdateDeliveryEmployeeException();
        }
    }
}