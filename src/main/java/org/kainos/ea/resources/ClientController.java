package org.kainos.ea.resources;

import io.swagger.annotations.Api;
import org.kainos.ea.api.ClientService;
import org.kainos.ea.api.ProjectService;
import org.kainos.ea.api.SalesEmployeeService;
import org.kainos.ea.cli.Client;
import org.kainos.ea.cli.ClientOutput;
import org.kainos.ea.cli.Project;
import org.kainos.ea.cli.SalesEmployee;
import org.kainos.ea.client.FailedToGetClientsException;
import org.kainos.ea.client.FailedToGetProjectsException;
import org.kainos.ea.client.FailedToGetSalesEmployeeException;
import org.kainos.ea.client.SalesEmployeeDoesNotExistException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Api("Dropwizard Client API")
@Path("/api")
public class ClientController {
    ClientService clientService = new ClientService();
    ProjectService projectService = new ProjectService();
    SalesEmployeeService salesEmployeeService = new SalesEmployeeService();

    @GET
    @Path("/clients")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllClients() {
        try {
            List<ClientOutput> clientOutputList = new ArrayList<>();
            for (Client client: clientService.getAllClients()) {
                SalesEmployee salesEmployee = salesEmployeeService.getSalesEmployeeById(client.getSalesEmpId());
                List<Project> projectList = projectService.getAllProjectsWithClient(client.getClientId());
                ClientOutput clientOutput = new ClientOutput(client, salesEmployee, projectList);
                clientOutputList.add(clientOutput);
            }
            return Response.ok(clientOutputList).build();
        } catch (FailedToGetClientsException | FailedToGetProjectsException |
                 FailedToGetSalesEmployeeException e) {
            System.err.println(e.getMessage());

            return Response.serverError().build();
        } catch (SalesEmployeeDoesNotExistException e) {
            System.err.println(e.getMessage());

            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
