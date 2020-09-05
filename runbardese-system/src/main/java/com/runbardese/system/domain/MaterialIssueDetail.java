package com.runbardese.system.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Tao
 * @Date 2020/7/25
 * @Time 14:35
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialIssueDetail {
    //计划编号
    private String No;
    //物料编号
    private String Inventory_ID;
    private Integer NOID;
    //需求数量
    private Double Require_Qty;

//    //利用车间库存数量
//    private Double Use_Wip_Qty;
//    //计划实发
//    private Double Qty;
//    //多发数量
//    private Double Overissue_Qty;
//    //实际发料数量
//    private Double Actual_Issue_Qty;
//    //欠发数量
//    private Double Shortage_Qty;

    //领料方式 (4  PLC配料)
    private Integer GtMType;
    //第1次发料数量
    private Double Q1;

//    //第2次发料数量
//    private Double Q2;
//    //第3次发料数量
//    private Double Q3;
//    //第4次发料数量
//    private Double Q4;
//    //第5次发料数量
//    private Double Q5;

    private Double ActUsedQty;




}
