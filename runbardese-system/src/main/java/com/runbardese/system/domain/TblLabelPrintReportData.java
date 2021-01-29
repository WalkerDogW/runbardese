package com.runbardese.system.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TblLabelPrintReportData {
    /*private String iD;
    private String inventory_ID;
    private String custInventoryID;
    private double unit_weight;
    private String jarModelID;
    private String boxCode;
    private double jarQty;
    private double boxQty;
    private String summary;
    private String ctn;
    private String duDate;
    private String projectBatch;
    private String no;
    private String markBarCode;
    private String isPrint;
    private double printQty;
    private String summaryOther;
    private String lOGO;
    private String contactNum;
    private String admCode;
    private String qiStandard;
    private String guoStandard;
    private String flevel;
    private String shelfLife;
    private String resinCatID;
    private String fPeibi;
    private String f3CCode;
    private String fmodel;
    private String summary1;
    private String summary2;
    private String summary3;
    private String logoid;
    private String inventoryName;
    private String tunit_weight;
    private int printed;
    private double printedQty;
    private String createDate;
    private String packPlanNum;
    private String ordDept;
    private String proDept;
    private String jarReportID;
    private String jarReportName;
    private String orderId;
    private int selfType;
    private String fromEviNum;
    private int sUITNOID;
    private String qrCode;
    private String groupSumm;
    private int evType;
    private int invType;
    private String bInventory_ID;
    private String invProjectBatch;
    private double nBox;
    private String logoPic;
    private String contactName;
    private String packID;*/
    private Date dudate; //生产日期
    private String No;//生产批号
    private String inventory_ID;// 产品编码
    private String unit_weight;// 净重
    private String bInventory_ID;// 标识半成品
    private int printed;// 计划数量
    private int printedQty;// 已经打印的数量
    private int ID;//
}
