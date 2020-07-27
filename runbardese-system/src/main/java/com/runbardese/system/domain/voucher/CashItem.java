package com.runbardese.system.domain.voucher;

import lombok.Data;

@Data
public class CashItem {
    //年份
    private String FYear;
    //月份
    private String Fmonth;
    //凭证号
    private String Fpzh;
    //单据编号
    private String evidenceNumber;
    //科目编码
    private String Fkmbh;
    //摘要
    private String Fzy;
    //金额
    private String fje;
    //借贷标识
    private String Fdc;
    //人员
    private String fbmdm;
    //客商
    private String Fdwdm;
    //核算部门
    private String deptID;
    //U8凭证字号
    private String U8Code;
    //现金流量编码
    private String cashCode;

}
