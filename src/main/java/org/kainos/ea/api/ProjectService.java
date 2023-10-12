package org.kainos.ea.api;

import org.kainos.ea.cli.Client;
import org.kainos.ea.cli.Project;
import org.kainos.ea.cli.ProjectRequest;
import org.kainos.ea.cli.ProjectRequestClient;
import org.kainos.ea.client.*;
import org.kainos.ea.db.ClientDao;
import org.kainos.ea.db.ProjectDao;

import java.sql.SQLException;
import java.util.List;

public class ProjectService {
    ProjectDao projectDao = new ProjectDao();
    ClientDao clientDao = new ClientDao();

    public List<Project> getAllProjectsWithClient(int clientId) throws FailedToGetProjectsException {
        List<Project> projectList;

        try {
            projectList = projectDao.getAllProjectsWithClient(clientId);
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToGetProjectsException();
        }

        return projectList;
    }

    public void updateProjectClient(int id, ProjectRequestClient project) throws ProjectDoesNotExistException, FailedToUpdateProjectException, ClientDoesNotExistException {
        try {
            Project projectToUpdate = projectDao.getProjectById(id);

            if (projectToUpdate == null) {
                throw new ProjectDoesNotExistException();
            }

            Client clientToUpdate = clientDao.getClientById(project.getClientId());

            if (clientToUpdate == null) {
                throw new ClientDoesNotExistException();
            }

            projectDao.updateProjectClient(id, project);
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToUpdateProjectException();
        }
    }
}
