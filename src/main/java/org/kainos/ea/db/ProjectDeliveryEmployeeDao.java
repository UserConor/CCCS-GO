package org.kainos.ea.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ProjectDeliveryEmployeeDao {
    private DatabaseConnector databaseConnector = new DatabaseConnector();
    public void assignDeliveryEmployeeToProject(int projectId, List<Integer> deliveryEmployeeIds) throws SQLException {
        Connection connection = databaseConnector.getConnection();

        StringBuilder statement = new StringBuilder(
                "INSERT INTO Project_DeliveryEmployee (EmployeeID, ProjectID) VALUES ");
        int numDeliveryEmployees = deliveryEmployeeIds.size();
        for (int i = 0; i < numDeliveryEmployees; i++) {
            int deliveryEmployeeId = deliveryEmployeeIds.get(i);
            statement.append(String.format("(%s, %s)", deliveryEmployeeId, projectId));
            if (i < numDeliveryEmployees - 1) {
                statement.append(",");
            }
        }

        PreparedStatement preparedStatement = connection.prepareStatement(String.valueOf(statement));
        preparedStatement.executeUpdate();
    }
}
