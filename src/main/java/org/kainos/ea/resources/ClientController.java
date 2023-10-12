package org.kainos.ea.resources;

import io.swagger.annotations.Api;
import org.kainos.ea.api.ClientService;
import org.kainos.ea.client.FailedToGetClientsException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api("Dropwizard Client API")
@Path("/api")
public class ClientController {
    ClientService clientService = new ClientService();

    @GET
    @Path("/clients")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllClients() {
        try {
            return Response.ok(clientService.getAllClients()).build();
        } catch (FailedToGetClientsException e) {
            System.err.println(e.getMessage());

            return Response.serverError().build();
        }
    }
}
