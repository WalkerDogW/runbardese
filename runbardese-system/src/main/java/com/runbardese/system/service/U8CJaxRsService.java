package com.runbardese.system.service;

import com.runbardese.system.domain.voucher.Ufinterface;
import com.runbardese.system.domain.voucher.UfinterfaceCTB;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

public interface U8CJaxRsService {

    /**
     * 获取凭证
     * @return
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("/getU8CXml")
    public Ufinterface selectUfinterface();


    /**
     * 获取客商档案
     * @return
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("/getU8CTBXml")
    public UfinterfaceCTB selectUfinterfaceCTB();



}
