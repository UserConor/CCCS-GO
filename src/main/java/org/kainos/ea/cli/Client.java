package org.kainos.ea.cli;

import org.kainos.ea.api.ProjectService;
import org.kainos.ea.api.SalesEmployeeService;
import org.kainos.ea.client.FailedToGetProjectsException;
import org.kainos.ea.client.FailedToGetSalesEmployeeException;
import org.kainos.ea.client.SalesEmployeeDoesNotExistException;

import java.util.List;

public class Client {
    private int clientId;
    private String forename;
    private String surname;
    private int salesEmpId;

    public Client(int clientId, String forename, String surname, int salesEmpId) {
        this.clientId = clientId;
        this.forename = forename;
        this.surname = surname;
        this.salesEmpId = salesEmpId;
    }

    public Client(int clientID) {

    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSalesEmpId() {
        return salesEmpId;
    }

    public void setSalesEmpId(int salesEmpId) {
        this.salesEmpId = salesEmpId;
    }

    public ClientOutput getClientOutput(
            SalesEmployeeService salesEmployeeService,
            ProjectService projectService
    )
            throws SalesEmployeeDoesNotExistException,
            FailedToGetSalesEmployeeException,
            FailedToGetProjectsException {
        SalesEmployee salesEmployee = salesEmployeeService.getSalesEmployeeById(this.getSalesEmpId());
        List<Project> projectList = projectService.getAllProjectsWithClient(this.getClientId());
        return new ClientOutput(this, salesEmployee, projectList);
    }
}
