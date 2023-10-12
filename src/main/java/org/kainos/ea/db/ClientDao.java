package org.kainos.ea.db;

import org.kainos.ea.cli.Client;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientDao {
    public List<Client> getAllClients() throws SQLException {
        Connection connection = DatabaseConnector.getConnection();
        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery("SELECT " +
                "ClientID, Forename, Surname, SalesEmpID " +
                "FROM Client");

        List<Client> clientList = new ArrayList<>();

        while (rs.next()) {
            Client client = new Client(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4)
            );

            clientList.add(client);
        }

        return clientList;
    }
}
