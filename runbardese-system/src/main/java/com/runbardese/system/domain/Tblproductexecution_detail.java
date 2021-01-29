package com.runbardese.system.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tblproductexecution_detail {

    private String batchNo;
    private int execNOID;
    private double nOID;
    private String wipID;
    private String equipmentNum;
    private String commandType;
    private String execCode;
    private String execName;
    private double param1;
    private double param2;
    private double param3;
    private double param4;
    private double param5;
    private int optStatus;
    private String beginDate;
    private String endDate;
    private String optMan;
    private String equipmentIP;
    private double actualTimes;
    private String createDate;
    private double actParam1;
    private double actParam2;
    private double actParam3;
    private double actParam4;
    private double actParam5;
    private int mfgType;
    private int gtMType;
    private String pcName;
    private double fweight;
    private int ftype;
    private int rountNO;
    private String inventory_ID;
    private String inventoryDes;
    private String summary;
    private int aOptStatus;
    private int execALStatus;
    private int prevCode;
    private int nextCode;
    private double planTimes;
    private int stageNum;
    private String style;
}
