package org.kainos.ea.resources;

import io.swagger.annotations.Api;
import org.kainos.ea.api.DeliveryEmployeeService;
import org.kainos.ea.cli.DeliveryEmployeeRequest;
import org.kainos.ea.client.DeliveryEmployeeDoesNotExistException;
import org.kainos.ea.client.FailedToCreateDeliveryEmployeeException;
import org.kainos.ea.client.FailedToGetDeliveryEmployeesException;
import org.kainos.ea.client.InvalidDeliveryEmployeeException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api("Dropwizard Delivery Employee API")
@Path("/api")
public class DeliveryEmployeeController {

        private DeliveryEmployeeService deliveryEmployeeService = new DeliveryEmployeeService();

        @GET
        @Path("/deliveryemployees")
        @Produces(MediaType.APPLICATION_JSON)
        public Response getAllDeliveryEmployees() {
            try {
                return Response.ok(deliveryEmployeeService.getAllDeliveryEmployees()).build();
            } catch (FailedToGetDeliveryEmployeesException e) {
                System.err.println(e.getMessage());

                return Response.serverError().build();
            }
        }


    @GET
    @Path("/deliveryemployees/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDeliveryEmployeeById(@PathParam("id") int id) {
        try {
            return Response.ok(deliveryEmployeeService.getDeliveryEmployeeById(id)).build();
        } catch (FailedToGetDeliveryEmployeesException e) {
            System.err.println(e.getMessage());

            return Response.serverError().build();
        } catch (DeliveryEmployeeDoesNotExistException e) {
            System.err.println(e.getMessage());

            return Response.status(Response.Status.BAD_REQUEST.getStatusCode(), "Delivery employee does not exist").build();
        }
    }


    @POST
    @Path("/deliveryemployees")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createDeliveryEmployee(DeliveryEmployeeRequest deliveryEmployee) {
        try {
            return Response.ok(deliveryEmployeeService.createDeliveryEmployee(deliveryEmployee)).build();
        } catch (FailedToCreateDeliveryEmployeeException e) {
            System.err.println(e.getMessage());

            return Response.serverError().build();
        } catch (InvalidDeliveryEmployeeException e) {
            System.err.println(e.getMessage());

            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();

        }
    }
}
