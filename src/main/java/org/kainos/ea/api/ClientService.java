package org.kainos.ea.api;

import org.kainos.ea.cli.Client;
import org.kainos.ea.cli.ClientOutput;
import org.kainos.ea.cli.Project;
import org.kainos.ea.cli.SalesEmployee;
import org.kainos.ea.client.FailedToGetClientsException;
import org.kainos.ea.client.FailedToGetProjectsException;
import org.kainos.ea.client.FailedToGetSalesEmployeeException;
import org.kainos.ea.client.SalesEmployeeDoesNotExistException;
import org.kainos.ea.db.ClientDao;
import org.kainos.ea.db.ProjectDao;
import org.kainos.ea.db.SalesEmployeeDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientService {
    ClientDao clientDao = new ClientDao();
    SalesEmployeeService salesEmployeeService = new SalesEmployeeService();
    ProjectService projectService = new ProjectService();

    public List<ClientOutput> getAllClientsInfo()
            throws FailedToGetClientsException,
            FailedToGetSalesEmployeeException,
            SalesEmployeeDoesNotExistException,
            FailedToGetProjectsException {
        List<ClientOutput> clientOutputList = null;

        try {
            clientOutputList = new ArrayList<>();
            for (Client client: clientDao.getAllClients()) {
                SalesEmployee salesEmployee = salesEmployeeService.getSalesEmployeeById(client.getSalesEmpId());
                List<Project> projectList = projectService.getAllProjectsWithClient(client.getClientId());
                ClientOutput clientOutput = new ClientOutput(client, salesEmployee, projectList);
                clientOutputList.add(clientOutput);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToGetClientsException();
        }

        return clientOutputList;
    }
}
