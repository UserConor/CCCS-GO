package org.kainos.ea.db;

import org.kainos.ea.cli.DeliveryEmployee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
}