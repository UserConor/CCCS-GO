package org.kainos.ea.api;

import org.kainos.ea.cli.SalesEmployee;
import org.kainos.ea.cli.SalesEmployeeRequest;
import org.kainos.ea.client.FailedToCreateSalesEmployeeException;
import org.kainos.ea.client.FailedToGetSalesEmployeeException;
import org.kainos.ea.client.InvalidSalesEmployeeException;
import org.kainos.ea.client.SalesEmployeeDoesNotExistException;
import org.kainos.ea.core.SalesEmployeeValidator;
import org.kainos.ea.db.SalesEmployeeDAO;

import java.sql.SQLException;

public class SalesEmployeeService {
    SalesEmployeeDAO salesEmployeeDAO = new SalesEmployeeDAO();

    SalesEmployeeValidator salesEmployeeValidator = new SalesEmployeeValidator();

    public int createSalesEmployee(SalesEmployeeRequest salesEmployeeRequest)
            throws FailedToCreateSalesEmployeeException, InvalidSalesEmployeeException {
        try {
            String validation = salesEmployeeValidator.isValidSalesEmployee(salesEmployeeRequest);

            if (validation != null) {
                throw new InvalidSalesEmployeeException(validation);
            }

            int id = salesEmployeeDAO.createSalesEmployee(salesEmployeeRequest);

            if (id == -1) {
                throw new FailedToCreateSalesEmployeeException();
            }

            return id;
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToCreateSalesEmployeeException();
        }
    }

    public SalesEmployee getSalesEmployeeById(int id)
            throws FailedToGetSalesEmployeeException, SalesEmployeeDoesNotExistException {
        try {
            SalesEmployee salesEmployee = salesEmployeeDAO.getSalesEmployeeByID(id);

            if (salesEmployee == null) {
                throw new SalesEmployeeDoesNotExistException();
            }

            return salesEmployee;
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToGetSalesEmployeeException();
        }
    }
}
