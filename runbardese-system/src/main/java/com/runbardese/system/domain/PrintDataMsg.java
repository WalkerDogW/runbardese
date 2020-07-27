package com.runbardese.system.domain;

import io.swagger.annotations.ApiModel;

import java.util.List;

@ApiModel("打印标签返回结果实体")
public class PrintDataMsg {
    //返回消息实体
    private CodeMsg codeMsg;
    //打印标签结果实体
    private List<PrintData> printData;

    public PrintDataMsg() {
    }

    public PrintDataMsg(CodeMsg codeMsg, List<PrintData> printData) {
        this.codeMsg = codeMsg;
        this.printData = printData;
    }

    public CodeMsg getCodeMsg() {
        return codeMsg;
    }

    public void setCodeMsg(CodeMsg codeMsg) {
        this.codeMsg = codeMsg;
    }

    public List<PrintData> getPrintData() {
        return printData;
    }

    public void setPrintData(List<PrintData> printData) {
        this.printData = printData;
    }

    @Override
    public String toString() {
        return "PrintDataMsg{" +
                "codeMsg=" + codeMsg +
                ", printData=" + printData +
                '}';
    }
}
