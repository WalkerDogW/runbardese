package com.runbardese.system.service.impl;

import com.runbardese.common.annotation.DataSource;
import com.runbardese.common.enums.DataSourceType;
import com.runbardese.system.domain.CodeMsg;
import com.runbardese.system.domain.PrintCode;
import com.runbardese.system.mapper.WSServerMapper;
import com.runbardese.system.service.WsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import java.util.List;

@Component
@WebService(serviceName = "WebService",
        targetNamespace = "http://service.system.runbardese.com",
        endpointInterface = "com.runbardese.system.service.WsService")
//@WebService(endpointInterface = "com.runbardese.system.service.WsService")
@DataSource(value = DataSourceType.SLAVE)
public class WsServiceImpl implements WsService{

    @Autowired
    private WSServerMapper wsServerMapper;

    @Override
    public List<PrintCode> getSelectAll(String orderId) {
        return wsServerMapper.selectWSAll(orderId);
    }


    /**
     * 根据编码修改防伪码
     * @param orderId
     * @return
     */
    @Override
    public CodeMsg updateCode(String orderId) {
        int flag = wsServerMapper.updateCode(orderId);
        CodeMsg codeMsg = new CodeMsg();
        if(flag<1){
            codeMsg.setCode(1);
            codeMsg.setMsg("失败");
            //codeMsg.setUpdate(flag);
            return codeMsg;
        }
        codeMsg.setCode(0);
        codeMsg.setMsg("成功");
        //codeMsg.setUpdate(flag);
        return codeMsg;
    }
}
