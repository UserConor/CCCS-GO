package org.kainos.ea.db;

import org.kainos.ea.cli.Project;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProjectDao {
    public List<Project> getAllProjectsWithClient(int clientId) throws SQLException {
        Connection connection = DatabaseConnector.getConnection();
        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery("SELECT " +
                "ProjectID, ProjectName, ProjectValue, ClientID, TechLeadID, IsCompleted " +
                "FROM Project " +
                "WHERE ClientID=" + clientId);

        List<Project> projectList = new ArrayList<>();

        while (rs.next()) {
            Project project = new Project(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getFloat(3),
                    rs.getInt(4),
                    rs.getInt(5),
                    rs.getBoolean(6)
            );

            projectList.add(project);
        }

        return projectList;
    }
}
