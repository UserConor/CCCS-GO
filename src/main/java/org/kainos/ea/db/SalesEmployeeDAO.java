package org.kainos.ea.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.kainos.ea.cli.SalesEmployeeRequest;
import org.kainos.ea.cli.SalesEmployee;

public class SalesEmployeeDAO {
    private DatabaseConnector databaseConnector = new DatabaseConnector();

    public int createSalesEmployee(SalesEmployeeRequest salesEmployee) throws SQLException {
        Connection connection = databaseConnector.getConnection();

        String insertStatement = "INSERT INTO SalesEmployee (Forename, Surname, Salary, BankNum, NINum, ComRate) VALUES (?,?,?,?,?,?)";

        PreparedStatement statement = connection.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS);

        statement.setString(1, salesEmployee.getForename());
        statement.setString(2, salesEmployee.getSurname());
        statement.setBigDecimal(3, salesEmployee.getSalary());
        statement.setString(4, salesEmployee.getBAN());
        statement.setString(5, salesEmployee.getNINumber());
        statement.setBigDecimal(6, salesEmployee.getComRate());

        statement.executeUpdate();

        ResultSet resultSet = statement.getGeneratedKeys();

        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return -1;
    }

    public SalesEmployee getSalesEmployeeByID(int id) throws SQLException {
        Connection connection = databaseConnector.getConnection();

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT SalesEmpID, Forename, Surname, Salary, BankNum, NINum, ComRate" +
                " FROM SalesEmployee where SalesEmpID = " + id);

        while (resultSet.next()) {
            return new SalesEmployee(
                    resultSet.getInt("SalesEmpID"),
                    resultSet.getString("Forename"),
                    resultSet.getString("Surname"),
                    resultSet.getBigDecimal("Salary"),
                    resultSet.getString("BankNum"),
                    resultSet.getString("NINum"),
                    resultSet.getBigDecimal("ComRate")
            );
        }
        return null;
    }
    public void updateSalesEmployee(int id, SalesEmployeeRequest salesEmployee) throws SQLException {
        Connection connection = databaseConnector.getConnection();

        String updateStatement = "UPDATE SalesEmployee SET Forename = ?, Surname = ?, Salary = ?, BankNum = ?, NINum = ?, ComRate = ? WHERE SalesEmpID = ?";

        PreparedStatement statement = connection.prepareStatement(updateStatement);

        statement.setString(1, salesEmployee.getForename());
        statement.setString(2, salesEmployee.getSurname());
        statement.setBigDecimal(3, salesEmployee.getSalary());
        statement.setString(4, salesEmployee.getBAN());
        statement.setString(5, salesEmployee.getNINumber());
        statement.setBigDecimal(6, salesEmployee.getComRate());
        statement.setInt(7, id);

        statement.executeUpdate();
    }
    public List<SalesEmployee> getAllSalesEmployees() throws SQLException {
        Connection connection = databaseConnector.getConnection();

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT SalesEmpID, Forename, Surname, Salary, BankNum, NINum, ComRate FROM SalesEmployee");

        List<SalesEmployee> salesEmployeeList = new ArrayList<>();

        while (resultSet.next()) {
            SalesEmployee salesEmployee = new SalesEmployee(
                    resultSet.getInt("SalesEmpID"),
                    resultSet.getString("Forename"),
                    resultSet.getString("Surname"),
                    resultSet.getBigDecimal("Salary"),
                    resultSet.getString("BankNum"),
                    resultSet.getString("NINum"),
                    resultSet.getBigDecimal("ComRate")
            );

            salesEmployeeList.add(salesEmployee);
        }
        return salesEmployeeList;
    }
}