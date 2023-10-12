package org.kainos.ea.db;

import org.kainos.ea.cli.Project;
import org.kainos.ea.cli.ProjectRequestClient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectDao {
    private DatabaseConnector databaseConnector = new DatabaseConnector();

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

    public Project getProjectById(int id) throws SQLException {
        Connection c = databaseConnector.getConnection();

        Statement st = c.createStatement();

        ResultSet rs = st.executeQuery("SELECT ProjectID" +
                " FROM Project WHERE ProjectID=" + id);


        while (rs.next()) {
            return new Project(
                    rs.getInt("ProjectID")
            );

        }

        return null;
    }

    public void updateProjectClient(int id, ProjectRequestClient project) throws SQLException {
        Connection connection = databaseConnector.getConnection();

        String updateStatement = "UPDATE Project SET ClientID = ? WHERE ProjectID = ?";

        PreparedStatement st = connection.prepareStatement(updateStatement);

        st.setInt(1, project.getClientId());
        st.setInt(2, id);

        st.executeUpdate();
    }

}
