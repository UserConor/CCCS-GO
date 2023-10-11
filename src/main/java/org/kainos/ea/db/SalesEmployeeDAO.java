package org.kainos.ea.db;

import java.sql.*;
import org.kainos.ea.cli.SalesEmployeeRequest;

public class SalesEmployeeDAO {
    private DatabaseConnector databaseConnector = new DatabaseConnector();

    public int createSalesEmployee(SalesEmployeeRequest salesEmployee) throws SQLException {
        Connection connection = databaseConnector.getConnection();

        String insertStatement = "INSERT INTO SalesEmployee  (Forename, Surname, Salary, BAN, NINumber, ComRate) VALUES (?,?,?,?,?,?)";

        PreparedStatement statement = connection.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS);

        statement.setString(1, salesEmployee.getForename());
        statement.setString(1, salesEmployee.getSurname());
        statement.setBigDecimal(1, salesEmployee.getSalary());
        statement.setString(1, salesEmployee.getBAN());
        statement.setString(1, salesEmployee.getNINumber());
        statement.setBigDecimal(1, salesEmployee.getComRate());

        statement.executeUpdate();

        ResultSet resultSet = statement.getGeneratedKeys();

        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return -1;
    }

}