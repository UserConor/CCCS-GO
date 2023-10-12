package org.kainos.ea.cli;

public class ProjectDeliveryEmployee {
    private int EmployeeID;
    private int ProjectID;

    public ProjectDeliveryEmployee(int EmployeeID, int ProjectID) {
        this.EmployeeID = EmployeeID;
        this.ProjectID = ProjectID;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int employeeID) {
        EmployeeID = employeeID;
    }

    public int getProjectID() {
        return ProjectID;
    }

    public void setProjectID(int projectID) {
        ProjectID = projectID;
    }
}
