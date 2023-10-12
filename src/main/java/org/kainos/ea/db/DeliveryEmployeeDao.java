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

        ResultSet resultSet = st.executeQuery("SELECT DEmpID, Forename, Surname, Salary, BankNum, NINum FROM `DeliveryEmployee`;");

        List<DeliveryEmployee> deliveryEmployeeList = new ArrayList<>();

        while (resultSet.next()) {
            DeliveryEmployee deliveryEmployee = new DeliveryEmployee(
                    resultSet.getInt("DEmpID"),
                    resultSet.getString("Forename"),
                    resultSet.getString("Surname"),
                    resultSet.getDouble("Salary"),
                    resultSet.getString("BankNum"),
                    resultSet.getString("NINum")
            );

            deliveryEmployeeList.add(deliveryEmployee);
        }

        return deliveryEmployeeList;
    }
}
