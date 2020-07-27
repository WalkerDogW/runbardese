package com.runbardese.system.service;

import com.runbardese.system.domain.CodeMsg;
import com.runbardese.system.domain.IPrintCode;
import com.runbardese.system.domain.PrintCode;
import org.springframework.stereotype.Service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Service
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@WebService
public interface CodeQueryService {

    @WebMethod
    public List<PrintCode> selectAllCode(@WebParam(name="PrintS") int PrintS);

    @WebMethod
    public CodeMsg updateCode(@WebParam(name="OrderId") String OrderId);

    @WebMethod
    public int insertParamCode(@WebParam(name="OrderId") String OrderId ,
                          @WebParam(name="AdmCode") String AdmCode,
                          @WebParam(name ="ProjectBatch") String ProjectBatch,
                          @WebParam(name="Inventory_ID") String Inventory_ID,
                          @WebParam(name="InventoryName") String InventoryName,
                          @WebParam(name="QRcode") String QRcode,
                          @WebParam(name="PrintS") int PrintS);
    @WebMethod
    public CodeMsg insertCode(@WebParam(name = "printCode") PrintCode printCode);

    @WebMethod
    public List<PrintCode> selectCode(@WebParam(name= "orderId") String orderId);

}
