package com.runbardese.system.service.impl;

import com.runbardese.system.domain.CodeMsg;
import com.runbardese.system.mapper.PrintCodeMapper;

import com.runbardese.system.service.UpdatePrintCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdatePrintCodeServiceImpl implements UpdatePrintCodeService {

    @Autowired
    private PrintCodeMapper printCodeMapper;
    @Override
    public CodeMsg updateCode(String orderId) {
        int flag = printCodeMapper.updateCode(orderId);
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
