package com.runbardese.system.service.impl;

import com.runbardese.system.domain.CodeData;
import com.runbardese.system.domain.PrintCode;
import com.runbardese.system.service.CodeServiceJaxRs;
import com.runbardese.system.service.WsService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/")
public class CodeServiceJaxRsImpl implements CodeServiceJaxRs {

    @Autowired
    private WsService wsService;

    @Override
    @GET
    @Path("/getjson/{orderId}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<PrintCode> getData(@PathParam("orderId") String orderId) {
        return wsService.getSelectAll(orderId);
    }

    @GET
    @Path("/getxml/{orderId}")
    @Produces({MediaType.APPLICATION_XML})
    public List<PrintCode> getData2(@PathParam("orderId") String orderId) {
        return wsService.getSelectAll(orderId);
    }
}
