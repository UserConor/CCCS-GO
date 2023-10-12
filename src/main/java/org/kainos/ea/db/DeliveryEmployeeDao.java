package org.kainos.ea.db;

import org.kainos.ea.cli.DeliveryEmployee;
import org.kainos.ea.cli.DeliveryEmployeeRequest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeliveryEmployeeDao {
    private DatabaseConnector databaseConnector = new DatabaseConnector();

    public List<DeliveryEmployee> getAllDeliveryEmployees() throws SQLException {
        Connection c = databaseConnector.getConnection();
        Statement st = c.createStatement();

        ResultSet rs = st.executeQuery("SELECT DEmpID, Forename, Surname, Salary, BankNum, NINum FROM `DeliveryEmployee`;");

        List<DeliveryEmployee> deliveryEmployeeList = new ArrayList<>();

        while (rs.next()) {
            DeliveryEmployee deliveryEmployee = new DeliveryEmployee(
                    rs.getInt("DEmpID"),
                    rs.getString("Forename"),
                    rs.getString("Surname"),
                    rs.getDouble("Salary"),
                    rs.getString("BankNum"),
                    rs.getString("NINum")
            );

            deliveryEmployeeList.add(deliveryEmployee);
        }

        return deliveryEmployeeList;
    }


    public DeliveryEmployee getDeliveryEmployeeById(int id) throws SQLException {
        Connection c = databaseConnector.getConnection();

        Statement st = c.createStatement();

        ResultSet rs = st.executeQuery("SELECT DEmpID, Forename, Surname, Salary, BankNum, NINum" +
                " FROM DeliveryEmployee where DEmpID=" + id);

        while (rs.next()) {
            return new DeliveryEmployee(
                    rs.getInt("DEmpID"),
                    rs.getString("Forename"),
                    rs.getString("Surname"),
                    rs.getDouble("Salary"),
                    rs.getString("BankNum"),
                    rs.getString("NINum")
            );
        }

        return null;
    }


    public int createDeliveryEmployee(DeliveryEmployeeRequest deliveryEmployee) throws SQLException {
        Connection c = databaseConnector.getConnection();

        String insertStatement = "INSERT INTO DeliveryEmployee (Forename, Surname, Salary, BankNum, NINum) VALUES (?,?,?,?,?)";

        PreparedStatement st = c.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS);

        st.setString(1, deliveryEmployee.getForename());
        st.setString(2, deliveryEmployee.getSurname());
        st.setDouble(3, deliveryEmployee.getSalary());
        st.setString(4, deliveryEmployee.getBankNum());
        st.setString(5, deliveryEmployee.getNINum());

        st.executeUpdate();

        ResultSet rs = st.getGeneratedKeys();

        if (rs.next()) {
            return rs.getInt(1);
        }

        return -1;
    }


    public void deleteDeliveryEmployee(int id) throws SQLException {
        Connection c = databaseConnector.getConnection();

        String deleteStatement = "DELETE FROM DeliveryEmployee WHERE DEmpID = ?";

        PreparedStatement st = c.prepareStatement(deleteStatement);

        st.setInt(1, id);

        st.executeUpdate();
    }
}
