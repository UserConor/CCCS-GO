package org.kainos.ea.resources;

import io.swagger.annotations.Api;
import org.kainos.ea.api.DeliveryEmployeeService;
import org.kainos.ea.client.DeliveryEmployeeDoesNotExistException;
import org.kainos.ea.client.FailedToGetDeliveryEmployeesException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
}