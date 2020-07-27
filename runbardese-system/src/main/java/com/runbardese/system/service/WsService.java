package com.runbardese.system.service;

import com.runbardese.system.domain.CodeMsg;
import com.runbardese.system.domain.PrintCode;
import org.springframework.stereotype.Service;


import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Service("wsServiceImpl")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@WebService
public interface WsService {


    @WebMethod
    public List<PrintCode> getSelectAll(@WebParam(name ="orderId") String orderId);


    @WebMethod
    public CodeMsg updateCode(@WebParam(name="orderId") String orderId);
}
