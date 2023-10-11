package org.kainos.ea.api;

import org.kainos.ea.cli.Project;
import org.kainos.ea.client.FailedToGetClientsException;
import org.kainos.ea.client.FailedToGetProjectsException;
import org.kainos.ea.db.ProjectDao;

import java.sql.SQLException;
import java.util.List;

public class ProjectService {
    ProjectDao projectDao = new ProjectDao();

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
}
