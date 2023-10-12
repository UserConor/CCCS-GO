package org.kainos.ea.cli;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProjectRequest {
    private int projectId;
    private String projectName;
    private double projectValue;
    private int clientId;
    private int techLeadId;
    private int isCompleted;

    @JsonCreator
    public ProjectRequest(
        @JsonProperty("projectId") int projectId,
        @JsonProperty("projectName") String projectName,
        @JsonProperty("projectValue") double projectValue,
        @JsonProperty("clientId") int clientId,
        @JsonProperty("techLeadId") int techLeadId,
        @JsonProperty("isCompleted") int isCompleted) {

        this.projectId = projectId;
        this.projectName = projectName;
        this.projectValue = projectValue;
        this.clientId = clientId;
        this.techLeadId = techLeadId;
        this.isCompleted = isCompleted;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public double getProjectValue() {
        return projectValue;
    }

    public void setProjectValue(double projectValue) {
        this.projectValue = projectValue;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getTechLeadId() {
        return techLeadId;
    }

    public void setTechLeadId(int techLeadId) {
        this.techLeadId = techLeadId;
    }

    public int getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(int isCompleted) {
        this.isCompleted = isCompleted;
    }

}
