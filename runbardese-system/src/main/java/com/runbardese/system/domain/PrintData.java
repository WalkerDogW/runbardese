package com.runbardese.system.domain;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("打印标签实体")
public class PrintData {

    //批号
    private String jarNo;
    //二维码内容
    private String qRCode;
    //客户编码
    private String contactNum;
    //产品编码
    private String inventory_Id;
    //产品名称
    private String inventory_Name;
    //规格码
    private String packid;
    //罐
    private String jarModelID;
    //箱
    private String boxCode;
    //净重
    private float unit_Weight;
    //生产日期
    private Date createDate;
    //二维码ID
    private String qRId;
    //管理码
    private String admCode;
    //所在库位
    private String stock_ID;
    //操作员
    private String lastUpMan;
    //操作日期
    private Date lastUpDate;
    //型号
    private String fmodel;
    //执行标准(国标)
    private String guoStandard;
    //执行标准
    private String qiStandard;
    //主要成膜物质
    private String resinCatID;
    //配比
    private String fPeibi;
    //保质期
    private String qualityDay;
    //等级
    private String grade;
    //3C标志工厂代码
    private String f3CCode;
    //打印状态
    private String printStatus;
    //品牌
    private String logo;

    //标签模板名称
    private String jarReportName;


}
