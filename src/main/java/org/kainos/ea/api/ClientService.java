package org.kainos.ea.api;

import org.kainos.ea.cli.Client;
import org.kainos.ea.client.FailedToGetClientsException;
import org.kainos.ea.db.ClientDao;

import java.sql.SQLException;
import java.util.List;

public class ClientService {
    ClientDao clientDao = new ClientDao();

    public List<Client> getAllClients() throws FailedToGetClientsException {
        List<Client> clientList;

        try {
            clientList = clientDao.getAllClients();
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToGetClientsException();
        }

        return clientList;
    }
}
