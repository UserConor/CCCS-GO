package org.kainos.ea.resources;

import io.swagger.annotations.Api;
import org.kainos.ea.api.ProjectService;
import org.kainos.ea.cli.ProjectRequest;
import org.kainos.ea.cli.ProjectRequestClient;
import org.kainos.ea.client.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api("Dropwizard Project API")
@Path("/api")
public class ProjectController {
    ProjectService projectService = new ProjectService();

    @GET
    @Path("/projects/{clientId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProjectsWithClient(@PathParam("clientId") int clientId) {
        try {
            return Response.ok(projectService.getAllProjectsWithClient(clientId)).build();
        } catch (FailedToGetProjectsException e) {
            System.err.println(e.getMessage());

            return Response.serverError().build();
        }
    }

    @PUT
    @Path("/projects/{projectId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateProject(@PathParam("projectId") int id, ProjectRequestClient project) {
        try{
            projectService.updateProjectClient(id, project);

            return Response.ok().build();
        } catch (ProjectDoesNotExistException | ClientDoesNotExistException e) {
            System.err.println(e.getMessage());

            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        } catch (FailedToUpdateProjectException e) {
            System.err.println(e.getMessage());

            return Response.serverError().build();
        }
    }
}
