package com.runbardese.system.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tblproductexecution {
    private String batchNo;
    private String nOID;
    private String wipID;
    private String equipmentNum;
    private String inventory_ID;
    private String eMID;
    private String planStaDate;
    private String planFinDate;
    private double planSumTimes;
    private String actStaDate;
    private String actFinDate;
    private double planQty;
    private double actQty;
    private String fmaker;
    private int rountNO;
    private int fStatus;
    private String fSummary;
    private String createDate;
    private String issueDate;
    private String rountDes;
    private double actSumTimes;
    private int syskis;
    private int stageNum;
    private String Description;
    private LocalDate DuDate;

}
