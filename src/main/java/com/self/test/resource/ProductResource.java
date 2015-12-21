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
import java.util.HashMap;
import java.util.Map;

@Path("/products")
public class ProductResource {

    @Context
    protected UriInfo uriInfo;

    private static Map<String, Product> productsCollection = new HashMap<String, Product>();

    private void prepareProducts()
    {
        final Product product1 = new Product("C001","Bag",23.212);
        final Product product2 = new Product("C002", "Pen", 2.42);
        final Product product3 = new Product("C003", "Book",43.67);
        productsCollection.put("C001", product1);
        productsCollection.put("C002", product2);
        productsCollection.put("C003", product3);
    }

    @Path("{code}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getProduct(@PathParam("code") String code){
        System.out.println("code: " + code);
        prepareProducts();
        if(productsCollection.containsKey(code)){
            return Response.ok(productsCollection.get(code)).build();
        }
            return Response.status(Response.Status.NO_CONTENT).build();
    }

}
