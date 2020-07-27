package com.runbardese.system.service;

import com.runbardese.system.domain.CodeData;
import com.runbardese.system.domain.PrintCode;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Consumes({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
public interface CodeServiceJaxRs {
    @GET
    @Produces({ MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
    @Path( "/get/{orderId}" )
    public List<PrintCode> getData(@PathParam("orderId") String orderId);
}
