package org.kainos.ea.resources;

import io.swagger.annotations.Api;
import org.kainos.ea.api.ProjectService;
import org.kainos.ea.client.FailedToGetClientsException;
import org.kainos.ea.client.FailedToGetProjectsException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
}
