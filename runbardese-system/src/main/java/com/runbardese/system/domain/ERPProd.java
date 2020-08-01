package com.runbardese.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Tao
 * @Date 2020/7/30
 * @Time 15:43
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ERPProd {

    private  String BomId;
    private  String ProdCode;
    private  String ProdName;
    private  String Version;
    private  String PlanCreater;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate planCreateDate;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private  LocalDate requiedFinishDate;
    private  Double TotalQty;
    private  String Remark = "";
    private  String CompanyId;
    private  String ProdId;
    private  String InventBatchId;
    private  String WrkCtrId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private  LocalDateTime beginTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private  LocalDateTime finishedTime;
    private  String Color;
    private  Double RealQty;
    private  Integer InterfaceStatus;
    private  String Reason;
}
