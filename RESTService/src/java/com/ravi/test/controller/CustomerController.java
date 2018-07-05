/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ravi.test.controller;

import com.ravi.test.services.CustomerServices;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Ravi.Nistala
 */
@Path("customer")
public class CustomerController {
    
     @Inject CustomerServices cs;

// @Inject      private LocalStoreMap localMap;
        @Context
    private UriInfo context;

    /**
     * Creates a new instance of HelloWorld
     */
    public CustomerController() {
        this.cs = new CustomerServices();
    }
/**
 * Default Hello Method
 * @return 
 */

    @GET
    @Produces("text/html")
    public String getHelloHtml() {
        return "<html lang=\"en\"><body><h1>Hello, World!!</h1></body></html>";
    }

    /**
 * customize Hello Method
 * @return 
 */
    @GET
    @Produces("text/html")
    @Path("/{param}")
    public String getHelloHtml(@PathParam("param") String param) {
        return "<html lang=\"en\"><body><h1>Hello, " + param + "!!</h1></body></html>";
    }

    /**
     * CRUD Operations on concurrent HashMap
     * @param Id
     * @return 
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getValue/{Id}")
    public String getValue(@PathParam("Id") int Id) {       
         return cs.getValue(Id);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/deleteValue/{Id}")
    public String deleteValue(@PathParam("Id") int Id) {       
         return cs.deleteValue(Id);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/addValue/{Id}/{value}")
    public String addValue(@PathParam("Id") int Id,@PathParam("value") String value) {       
         return cs.addValue(Id, value);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/updateValue/{Id}/{value}")
    public String updateValue(@PathParam("Id") int Id,@PathParam("value") String value) {       
         return cs.updateValue(Id,value);
    }

    /**
     * CRUD Operations on Customer Entity Class
     * @param message 
     */
    
    @POST
    @Consumes("text/plain")
    public void postHtml(String message) {
        // Store the message
    }
}
