package org.kainos.ea.db;

import org.kainos.ea.cli.Client;
import org.kainos.ea.cli.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDao {

    private DatabaseConnector databaseConnector = new DatabaseConnector();

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

    public Client getClientById(int id) throws SQLException {
        Connection c = databaseConnector.getConnection();

        Statement st = c.createStatement();

        ResultSet rs = st.executeQuery("SELECT ClientID" +
                " FROM Client WHERE ClientID=" + id);


        while (rs.next()) {
            return new Client(
                    rs.getInt("ClientID")
            );
        }

        return null;

    }
}



