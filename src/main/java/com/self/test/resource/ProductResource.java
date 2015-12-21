package com.self.test.resource;

import com.self.test.model.Product;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/products")
public class ProductResource {

    @Context
    protected UriInfo uriInfo;

    @Path("{code}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getProduct(@PathParam("code") String code){
        System.out.println("code: " + code);
        final Product product = new Product();
        product.setName("Bag");
        product.setPrice(23.11);
        product.setCode("C001");
        try {
            if(product.getCode()== null)
                return Response.noContent().build();
            else
                return Response.ok(product).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.NO_CONTENT).build();
        }

    }

}
