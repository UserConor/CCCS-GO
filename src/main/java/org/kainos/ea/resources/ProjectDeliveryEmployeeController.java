package org.kainos.ea.resources;

import io.swagger.annotations.Api;
import org.kainos.ea.api.ProjectDeliveryEmployeeService;
import org.kainos.ea.client.DeliveryEmployeeDoesNotExistException;
import org.kainos.ea.client.FailedToAssignDeliveryEmployeeToProjectException;
import org.kainos.ea.client.ProjectDoesNotExistException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api("Dropwizard Project - Delivery Employee API")
@Path("/api")
public class ProjectDeliveryEmployeeController {
    ProjectDeliveryEmployeeService projectDeliveryEmployeeService = new ProjectDeliveryEmployeeService();

    @PUT
    @Path("/project-delivery-employees/{projectId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response assignDeliveryEmployeeToProject(
            @PathParam("projectId") int projectId, List<Integer> deliveryEmployeeIds) {
        try {
            projectDeliveryEmployeeService.assignDeliveryEmployeeToProject(projectId, deliveryEmployeeIds);

            return Response.ok().build();
        } catch (ProjectDoesNotExistException | DeliveryEmployeeDoesNotExistException e) {
            System.err.println(e.getMessage());

            return Response.status(javax.ws.rs.core.Response.Status.BAD_REQUEST).build();
        } catch (FailedToAssignDeliveryEmployeeToProjectException e) {
            System.err.println(e.getMessage());

            return Response.serverError().build();
        }
    }
}
