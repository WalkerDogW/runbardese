package com.runbardese.system.service.impl;

import com.runbardese.common.annotation.DataSource;
import com.runbardese.common.enums.DataSourceType;
import com.runbardese.system.domain.CodeMsg;
import com.runbardese.system.domain.IPrintCode;
import com.runbardese.system.domain.PrintCode;
import com.runbardese.system.mapper.PrintCodeMapper;
import com.runbardese.system.service.CodeQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebService;
import java.util.List;

@Component
@WebService(serviceName = "codeQuery",
        targetNamespace = "http://service.system.runbardese.com",
        endpointInterface = "com.runbardese.system.service.CodeQueryService")
@DataSource(value = DataSourceType.SLAVE)
public class CodeQueryImpl implements CodeQueryService {

    @Autowired
    private PrintCodeMapper printCodeMapper;

    /**
     * 根据打印状态查询条码
     * @param PrintS 打印状态
     * @return
     */
    @Override
    public List<PrintCode> selectAllCode(int PrintS) {
        return printCodeMapper.selectAllCode(PrintS);
    }

    /**
     * 根据编码修改防伪码
     * @param OrderId
     * @return
     */
    @Override
    public CodeMsg updateCode(String OrderId) {
        int flag = printCodeMapper.updateCode(OrderId);
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

    /**
     * 新增防伪码
     * @param printCode
     * @return
     */
    @Override
    public CodeMsg insertCode(PrintCode printCode) {
        int flag= printCodeMapper.insertCode(printCode.getOrderId(),printCode.getAdmCode(),printCode.getProjectBatch(),
                printCode.getInventory_ID(),printCode.getInventoryName(),printCode.getPrintS(),printCode.getqRcode());
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

    /**
     * 根据编号查询防伪码
     * @param orderId
     * @return
     */
    @Override
    public List<PrintCode> selectCode(String orderId) {
        return printCodeMapper.selectCode(orderId);
    }

    @Override
    public int insertParamCode(String OrderId ,String AdmCode,String ProjectBatch, String Inventory_ID, String InventoryName, String QRcode, int PrintS) {
        return printCodeMapper.insertCode(OrderId ,AdmCode,ProjectBatch,Inventory_ID,InventoryName,PrintS,QRcode);
    }


}
