package org.kainos.ea.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.kainos.ea.cli.SalesEmployeeRequest;
import org.kainos.ea.cli.SalesEmployee;

public class SalesEmployeeDAO {
    private DatabaseConnector databaseConnector = new DatabaseConnector();

    public int createSalesEmployee(SalesEmployeeRequest salesEmployee) throws SQLException {
        Connection c = databaseConnector.getConnection();

        String insertStatement = "INSERT INTO SalesEmployee (Forename, Surname, Salary, BankNum, NINum, ComRate) VALUES (?,?,?,?,?,?)";

        PreparedStatement s = c.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS);

        s.setString(1, salesEmployee.getForename());
        s.setString(2, salesEmployee.getSurname());
        s.setBigDecimal(3, salesEmployee.getSalary());
        s.setString(4, salesEmployee.getBAN());
        s.setString(5, salesEmployee.getNINumber());
        s.setBigDecimal(6, salesEmployee.getComRate());

        s.executeUpdate();

        ResultSet rs = s.getGeneratedKeys();

        if (rs.next()) {
            return rs.getInt(1);
        }
        return -1;
    }

    public SalesEmployee getSalesEmployeeByID(int id) throws SQLException {
        Connection c = databaseConnector.getConnection();

        Statement s = c.createStatement();

        ResultSet rs = s.executeQuery("SELECT SalesEmpID, Forename, Surname, Salary, BankNum, NINum, ComRate" +
                " FROM SalesEmployee where SalesEmpID = " + id);

        while (rs.next()) {
            return new SalesEmployee(
                    rs.getInt("SalesEmpID"),
                    rs.getString("Forename"),
                    rs.getString("Surname"),
                    rs.getBigDecimal("Salary"),
                    rs.getString("BankNum"),
                    rs.getString("NINum"),
                    rs.getBigDecimal("ComRate")
            );
        }
        return null;
    }

    public void updateSalesEmployee(int id, SalesEmployeeRequest salesEmployee) throws SQLException {
        Connection connection = databaseConnector.getConnection();

        String updateStatement = "UPDATE SalesEmployee SET Forename = ?, Surname = ?, Salary = ?, BankNum = ?, NINum = ?, ComRate = ? WHERE SalesEmpID = ?";

        PreparedStatement s = connection.prepareStatement(updateStatement);

        s.setString(1, salesEmployee.getForename());
        s.setString(2, salesEmployee.getSurname());
        s.setBigDecimal(3, salesEmployee.getSalary());
        s.setString(4, salesEmployee.getBAN());
        s.setString(5, salesEmployee.getNINumber());
        s.setBigDecimal(6, salesEmployee.getComRate());
        s.setInt(7, id);

        s.executeUpdate();
    }

    public List<SalesEmployee> getAllSalesEmployees() throws SQLException {
        Connection connection = databaseConnector.getConnection();

        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery("SELECT SalesEmpID, Forename, Surname, Salary, BankNum, NINum, ComRate FROM SalesEmployee");

        List<SalesEmployee> salesEmployeeList = new ArrayList<>();

        while (rs.next()) {
            SalesEmployee salesEmployee = new SalesEmployee(
                    rs.getInt("SalesEmpID"),
                    rs.getString("Forename"),
                    rs.getString("Surname"),
                    rs.getBigDecimal("Salary"),
                    rs.getString("BankNum"),
                    rs.getString("NINum"),
                    rs.getBigDecimal("ComRate")
            );

            salesEmployeeList.add(salesEmployee);
        }
        return salesEmployeeList;
    }
    
    public void deleteSalesEmployee(int id) throws SQLException {
        Connection connection = databaseConnector.getConnection();

        String deleteStatement = "DELETE FROM SalesEmployee WHERE SalesEmpID = ?";

        PreparedStatement statement = connection.prepareStatement(deleteStatement);

        statement.setInt(1,id);

        statement.executeUpdate();
    }
}