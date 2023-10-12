package org.kainos.ea.api;

import org.kainos.ea.cli.DeliveryEmployee;
import org.kainos.ea.cli.Project;
import org.kainos.ea.client.DeliveryEmployeeDoesNotExistException;
import org.kainos.ea.client.FailedToAssignDeliveryEmployeeToProjectException;
import org.kainos.ea.client.FailedToUpdateProjectException;
import org.kainos.ea.client.ProjectDoesNotExistException;
import org.kainos.ea.db.DeliveryEmployeeDao;
import org.kainos.ea.db.ProjectDao;
import org.kainos.ea.db.ProjectDeliveryEmployeeDao;

import java.sql.SQLException;
import java.util.List;

public class ProjectDeliveryEmployeeService {
    ProjectDeliveryEmployeeDao projectDeliveryEmployeeDao = new ProjectDeliveryEmployeeDao();
    ProjectDao projectDao = new ProjectDao();
    DeliveryEmployeeDao deliveryEmployeeDao = new DeliveryEmployeeDao();

    public void assignDeliveryEmployeeToProject(int projectId, List<Integer> deliveryEmployeeIds)
            throws FailedToAssignDeliveryEmployeeToProjectException, DeliveryEmployeeDoesNotExistException,
            ProjectDoesNotExistException {
        try {
            Project project = projectDao.getProjectById(projectId);
            if (project == null) {
                throw new ProjectDoesNotExistException();
            }

            for (Integer deliveryEmployeeId: deliveryEmployeeIds) {
                DeliveryEmployee deliveryEmployee = deliveryEmployeeDao.getDeliveryEmployeeById(
                        deliveryEmployeeId);
                if (deliveryEmployee == null) {
                    throw new DeliveryEmployeeDoesNotExistException();
                }
            }

            projectDeliveryEmployeeDao.assignDeliveryEmployeeToProject(projectId, deliveryEmployeeIds);
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToAssignDeliveryEmployeeToProjectException();
        }
    }
}
